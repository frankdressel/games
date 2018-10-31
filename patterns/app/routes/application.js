import Ember from 'ember';
import EmberObject from '@ember/object';

export default Ember.Route.extend({
    modelObj: EmberObject.extend({'data': new Map(), 'time': 0}).create(),
    size: 30,
    actions:{
        next(data){
            let that = this;
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
        noise(cell, data, dt){
            function dist(cell1, cell2){
                return Math.max(
                    Math.abs(cell1['x']-cell2['x']),
                    Math.abs(cell1['y']-cell2['y']),
                    Math.abs(cell1['z']-cell2['z'])
                );
            }

            let deltatime = dt || 0;
            let time = this.get('modelObj').get('time');
            for(let z = -this.get('size'); z <= this.get('size'); z = z + 1){
                for(let x = -this.get('size'); x <= this.get('size'); x = x + 1){
                    let y = -(x+z);
                    if(Math.abs(y)>this.get('size')){
                        continue;
                    }

                    let key = JSON.stringify([x, -(x + z), z]);
                    let cell2 = data.get(key);
                    if(cell2 && (cell != cell2)){
                        let d = dist(cell, cell2);
                        cell2['noise']['time'][time + deltatime] = (cell2['noise']['time'][time + deltatime] || 0) + 1 / d;
                        cell2['noise']['time'][time + 1 + deltatime] = (cell2['noise']['time'][time + 1 + deltatime] || 0) - 1 / d;
                        //cell2['noise']['time'][time + d + deltatime] = (cell2['noise']['time'][time + d + deltatime] || 0) + 1 / d;
                        //cell2['noise']['time'][time + d + 1 + deltatime] = (cell2['noise']['time'][time + d + 1 + deltatime] || 0) - 1 / d;
                    }
                }
            }
        },
        car(cell, data, direction){
            let that = this;
            that.send('noise', cell, data, 1);

            let neighbors = [[1, 0, -1], [1, -1, 0], [0, -1, 1], [-1, 0, 1], [-1, 1, 0], [0, 1, -1]];
            let key = [cell['x'], cell['y'], cell['z']];
            let deltatime=1;
            while(true){
                deltatime = deltatime + 1;
                if(deltatime % 3 == 0){
                    key = [key[0] + neighbors[direction][0], key[1] + neighbors[direction][1], key[2] + neighbors[direction][2]]
                    if(!data.has(JSON.stringify(key))){
                        break;
                    }
                }
                that.send('noise', data.get(JSON.stringify(key)), data, deltatime);
            }
        }
    },
    model(){
        let data = this.get('modelObj').get('data');
        for(let z = -this.get('size'); z <= this.get('size'); z = z + 1){
            for(let x = -this.get('size'); x <= this.get('size'); x = x + 1){
                let y = -(x+z);
                if(Math.abs(y)>this.get('size')){
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
