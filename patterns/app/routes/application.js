import Ember from 'ember';
import EmberObject from '@ember/object';

export default Ember.Route.extend({
    modelObj: EmberObject.extend({'data': new Map(), 'time': 0}).create(),
    actions:{
        next(data){
            let that = this;
            let neighbors = [[1, 0, -1], [1, -1, 0], [0, -1, 1], [-1, 0, 1], [-1, 1, 0], [0, 1, -1]];
            this.get('modelObj').set('time', this.get('modelObj').get('time') + 1);
            let time = this.get('modelObj').get('time');
            for (let key of data.keys()) {
                let cell = data.get(key);

                if(cell['noise']['time'][time]){
                    cell['noise']['value'] = cell['noise']['value'] + cell['noise']['time'][time];
                }
                delete cell['noise']['time'][time];
            }
        },
        noise(cell, data){
            function dist(cell1, cell2){
                return Math.max(
                    Math.abs(cell1['x']-cell2['x']),
                    Math.abs(cell1['y']-cell2['y']),
                    Math.abs(cell1['z']-cell2['z'])
                );
            }
            let size = 8;
            let time = this.get('modelObj').get('time');
            for(let z = -size; z <= size; z = z + 1){
                for(let x = -size; x <= size; x = x + 1){
                    let y = -(x+z);
                    if(Math.abs(y)>size){
                        continue;
                    }

                    let key = JSON.stringify([x, -(x + z), z]);
                    let cell2 = data.get(key);
                    if(cell2){
                        let d = dist(cell, cell2);
                        cell2['noise']['time'][time + d] = (cell2['noise']['time'][time + d] || 0) + 1 / d;
                        cell2['noise']['time'][time + d + 1] = (cell2['noise']['time'][time + d + 1] || 0) - 1 / d;
                    }
                }
            }
        }
    },
    model(){
        let data = this.get('modelObj').get('data');
        let size = 8;
        for(let z = -size; z <= size; z = z + 1){
            for(let x = -size; x <= size; x = x + 1){
                let y = -(x+z);
                if(Math.abs(y)>size){
                    continue;
                }
                let key = JSON.stringify([x, -(x + z), z]);
                data.set(key, {
                    'x': x,
                    'y': y,
                    'z': z,
                    'value': 0,
                    'noise':{'value': 0, 'time': {}},
                    'cars': {},
                });
            }
        }
        return this.get('modelObj');
    }
});
