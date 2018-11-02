import Ember from 'ember';
import EmberObject from '@ember/object';

export default Ember.Route.extend({
    modelObj: EmberObject.extend({'data': new Map(), 'time': 0}).create(),
    size: 20,
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
                cell['cars']++;
                that.send('noise', cell, data, 1);
                let directions = Object.keys(cell['street']);
                let direction = directions[Math.floor(Math.random() * directions.length)];

                let key = [cell['x'], cell['y'], cell['z']];
                let deltatime=1;
                while(true){
                    deltatime = deltatime + 1;
                    data.get(JSON.stringify(key))['cars'] --;
                    key = [key[0] + neighbors[direction][0], key[1] + neighbors[direction][1], key[2] + neighbors[direction][2]]
                    if(!data.has(JSON.stringify(key))){
                        break;
                    }
                    let newcell = data.get(JSON.stringify(key));
                    newcell['cars'] ++;
                    directions = newcell['street'][direction];
                    // End of street reached.
                    if(!directions){
                        break;
                    }
                    let r = Math.random();
                    for(let d of Object.keys(directions)){
                        if(r <= directions[d]){
                            direction = d;
                            break;
                        }
                    }
                    that.send('noise', newcell, data, deltatime);
                }
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
                let cars = cells.filter(c => c['cars']>0);
                for(let cell of cells){
                    let sum = 0;
                    for(let car of cars){
                        let d = dist(cell, car);
                        let l = 90 - 16.61 * Math.LN10(d/1);
                        sum = sum + Math.pow(10, 0.1 * l);
                    }
                    cell['noise']['value'] = 10 * Math.LN10(sum);
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

                that.get('modelObj').set('time', that.get('modelObj').get('time') + 1);
                let time = that.get('modelObj').get('time');
                for (let key of data.keys()) {
                    let cell = data.get(key);

                    if(cell['noise']['time'][time]){
                        cell['noise']['value'] = cell['noise']['value'] + cell['noise']['time'][time];
                    }
                    delete cell['noise']['time'][time];
                }
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
                //If this is at the edge: Create inbound connections.
                if(neighborsWithStreets.length==1){
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
                    'cars': 0,
                }; 
                if(cell['z']==0) {
                    cell['street'] = {};
                    cell['street'][1] = {1: 1};
                    cell['street'][4] = {4: 1};
                }
                data.set(key, cell);
            }
        }
        let cell = data.get(JSON.stringify([2, -2, 0]));
        cell['street'][1] = {2: 1};
        while(true){
            let key = [cell['x'] + 0, cell['y'] - 1, cell['z'] + 1];
            if(!data.has(JSON.stringify(key))){
                break;
            }
            cell = data.get(JSON.stringify(key));
            cell['street'] = {2: {2: 1}};
        }
        return this.get('modelObj');
    }
});
