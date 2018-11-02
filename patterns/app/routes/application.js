import Ember from 'ember';
import EmberObject from '@ember/object';

export default Ember.Route.extend({
    modelObj: EmberObject.extend({'data': new Map(), 'time': 0}).create(),
    size: 3,
    actions:{
        next(data){
            let that=this;
            if(this.get('loop')){
                window.clearInterval(this.get('loop'));
                this.set('loop', undefined);
                return;
            }

            let neighbors = [[1, 0, -1], [1, -1, 0], [0, -1, 1], [-1, 0, 1], [-1, 1, 0], [0, 1, -1]];

            function car(cell, data){
                let directions = Object.keys(cell['street']);
                let direction = directions[Math.floor(Math.random() * directions.length)];
                cell['cars'].push(direction);
                that.send('noise', cell, data, 1);

            }

            function relative2absolute(cell, neighbor){
                return [cell['x'] + neighbor[0], cell['y'] + neighbor[1], cell['z'] + neighbor[2]];
            }

            function dist(cell1, cell2){
                return Math.max(
                    Math.abs(cell1['x']-cell2['x']),
                    Math.abs(cell1['y']-cell2['y']),
                    Math.abs(cell1['z']-cell2['z'])
                );
            }

            function noise2(){
                let cells = Array.from(data.values());
                let cars = cells.filter(c => c['cars'].length>0);
                for(let cell of cells){
                    let sum = 0;
                    for(let car of cars){
                        let d = dist(cell, car);
                        let l = 90 - 16.61 * Math.log10(d/1);
                        sum = sum + Math.pow(10, 0.1 * l);
                    }
                    cell['noise']['value'] = (10 * Math.log10(sum))/100;
                }
            }

            function loop(){
                let cells = Array.from(data.values()).filter(c => c['street']);
                for(let cell of cells){
                    let neighborsWithStreets = neighbors.filter(n => data.get(JSON.stringify(relative2absolute(cell, n)))).filter(n => data.get(JSON.stringify(relative2absolute(cell, n)))['street']);
                    if(neighborsWithStreets.length == 1){
                        let r = Math.random();
                        if(r <= 0.2){
                            car(cell, data);
                        }
                    }
                }

                let cars = Array.from(data.values()).filter(c => c['cars'].length>0);
                for(let cell of cells){
                    cell['_cars'] = [];
                }
                for(let cell of cars){
                    let key = [cell['x'], cell['y'], cell['z']];

                    for(let dir of cell['cars']){
                        // End of street reached.
                        if(typeof(cell['street'][dir]) == 'undefined'){
                            continue;
                        }
                        let directions = Object.keys(cell['street'][dir]);
                        let direction = directions[Math.floor(Math.random() * directions.length)];
                        
                        let r = Math.random();
                        for(let d of Object.keys(directions)){
                            if(r <= cell['street'][dir][d]){
                                direction = directions[d];
                                break;
                            }
                        }
                        key = relative2absolute(cell, neighbors[direction]);
                        if(!data.has(JSON.stringify(key))){
                            continue;
                        }
                        let newcell = data.get(JSON.stringify(key));
                        newcell['_cars'] = newcell['_cars'] || [];
                        newcell['_cars'].push(direction);
                    }
                    cell['cars'] = [];
                }
                for(let cell of cells){
                    cell['cars'] = cell['_cars'];
                }

                noise2(); 
                that.get('modelObj').set('time', that.get('modelObj').get('time') + 1);
            }

            this.set('loop', window.setInterval(loop, 500));
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
                        // See: https://www.schweizer-fn.de/akustik/schallpegelaenderung/schallpegel.php
                        // See: http://www.sengpielaudio.com/TabelleDerSchallpegel.htm
                        // Annahme: 1 Feld =10m. 90db ist der Schalldruck eines Dieselmotors in 10m Entfernung.
                        // L = 90 - 16.61 * log(d)
                        cell2['noise']['time'][time + deltatime] = (cell2['noise']['time'][time + deltatime] || 0) + 1 / d;
                        cell2['noise']['time'][time + 1 + deltatime] = (cell2['noise']['time'][time + 1 + deltatime] || 0) - 1 / d;
                    }
                }
            }
        },
        street(cell, data){
            cell['street']={};
        },
        make(data){
            function relative2absolute(cell, neighbor){
                return [cell['x'] + neighbor[0], cell['y'] + neighbor[1], cell['z'] + neighbor[2]];
            }

            let neighbors = [[1, 0, -1], [1, -1, 0], [0, -1, 1], [-1, 0, 1], [-1, 1, 0], [0, 1, -1]];
            let cells = Array.from(data.values()).filter(c => c['street']);
            // Remove existing street directions.
            for(let cell of cells){
                cell['street'] = {};
            }
            for(let cell of cells){
                let neighborsWithStreets = neighbors.filter(n => data.get(JSON.stringify(relative2absolute(cell, n)))).filter(n => data.get(JSON.stringify(relative2absolute(cell, n)))['street']);
                console.log(neighborsWithStreets.length);
                if(neighborsWithStreets.length > 1){
                    for(let i = 0; i < neighbors.length;i++){
                        // The direction we are coming from.
                        let neighbor = neighbors[(i+3)%6];
                        if(data.get(JSON.stringify(relative2absolute(cell, neighbor))) && data.get(JSON.stringify(relative2absolute(cell, neighbor)))['street']){
                            cell['street'][i] = {};
                            let cumm=0;
                            for(let j=0;j < neighbors.length;j++){
                                let neighborTo = neighbors[j];
                                if(Math.abs(i -j) != 3 && data.get(JSON.stringify(relative2absolute(cell, neighborTo))) && data.get(JSON.stringify(relative2absolute(cell, neighborTo)))['street']){
                                    cumm = cumm + 1 / Math.max(1,neighborsWithStreets.length - 1);
                                    cell['street'][i][j] = cumm;
                                }
                            }
                        }
                    }
                }
                //If this is at the edge: Create inbound connections.
                else{
                    for(let j=0;j < neighbors.length;j++){
                        let neighborTo = neighbors[j];
                        if(data.get(JSON.stringify(relative2absolute(cell, neighborTo))) && data.get(JSON.stringify(relative2absolute(cell, neighborTo)))['street']){
                            cell['street'][j] = {};
                            cell['street'][j][j] = 1;
                        }
                    }
                }
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
                let cell = {
                    'x': x,
                    'y': y,
                    'z': z,
                    'value': 0,
                    'noise':{'value': 0, 'time': {}},
                    'cars': [],
                }; 
                data.set(key, cell);
            }
        }
        return this.get('modelObj');
    }
});
