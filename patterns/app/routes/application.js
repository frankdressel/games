import Ember from 'ember';
import EmberObject from '@ember/object';

export default Ember.Route.extend({
    modelObj: EmberObject.extend({'data': new Map(), 'time': 0, 'radius': 32}).create(),
    rule: {'born': [2, ], 'survive': [2, 3]},
    actions:{
        next(data){
            let that=this;
            if(this.get('loop')){
                window.clearInterval(this.get('loop'));
                this.set('loop', undefined);
                return;
            }
//
//            let neighbors = [[1, 0, -1], [1, -1, 0], [0, -1, 1], [-1, 0, 1], [-1, 1, 0], [0, 1, -1]];
//
//            function relative2absolute(cell, neighbor){
//                return [cell['x'] + neighbor[0], cell['y'] + neighbor[1], cell['z'] + neighbor[2]];
//            }
//
//            function numOfNeighbors(cell, data){
//                let ncells = neighbors.map(n => data.get(JSON.stringify(relative2absolute(cell, n)))).filter(n => n);
//                let state = ncells.map(c => c.state);
//                return state.reduce((p, c) => c + p, 0);
//            }
//
            function loop(){
//                let cells = Array.from(data.values());
//                for(let cell of cells){
//                    cell['_state'] = 0;
//                }
//
//                for(let cell of cells){
//                    let nn = numOfNeighbors(cell, data);
//                    if(cell['state'] == 0){
//                        if(that.get('rule')['born'].indexOf(nn)>-1){
//                            cell['_state'] = 1;
//                        }
//                    }
//                    else{
//                        if(that.get('rule')['survive'].indexOf(nn)<0){
//                            cell['_state'] = 0;
//                        }
//                        else{
//                            cell['_state'] = 1;
//                        }
//                    }
//                }
//
//                for(let cell of cells){
//                    cell['state'] = cell['_state'];
//                }
            
                let data = that.get('modelObj').get('data');
                $.ajax({
                    'url': 'http://localhost:8080/simulation/step',
                    'type': 'POST',
                    'contentType': 'application/json',
                    'data': JSON.stringify(Array.from(data.values())),
                }).
                done(function(response){
                    response.forEach(function(c){
                        let key = JSON.stringify([c.coordinate.x, c.coordinate.y, c.coordinate.z]);
                        data.set(key, c);
                    });
                    that.get('modelObj').set('time', that.get('modelObj').get('time') + 1);
                    this.set('loop', window.setTimeout(loop, 500));
                });
            }

            loop();
            //this.set('loop', window.setInterval(loop, 500));
        },
        street(cell, data){
            cell['state'] = (cell['state'] + 1) % 3;
        },
    },
    model(){
        let data = this.get('modelObj').get('data');
        let radius = this.get('modelObj').get('radius');
        for(let z = -radius; z <= radius; z = z + 1){
            for(let x = -radius; x <= radius; x = x + 1){
                let y = -(x+z);
                if(Math.abs(y)>radius){
                    continue;
                }
                let key = JSON.stringify([x, -(x + z), z]);
                let cell = {
                    'coordinate': {
                        'x': x,
                        'y': y,
                        'z': z
                    },
                    'state': 0,//Math.random() > 0.8 ? Math.floor(Math.random() * (2 - 0 + 1)) + 0 : 0,
                }; 
                data.set(key, cell);
            }
        }
        return this.get('modelObj');
    }
});
