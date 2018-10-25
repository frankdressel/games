import Ember from 'ember';

export default Ember.Route.extend({
    actions:{
        next(data){
            console.log(Array.from(data).filter(([key, value])=>value['value']==1));
        }
    },
    model(){
        let data = new Map();
        let size = 8
        for(let z = -size; z <= size; z = z + 1){
            for(let x = -size; x <= size; x = x + 1){
                let y = -(x+z);
                if(Math.abs(y)>size){
                    continue;
                }
                data.set([x, -(x + z), z], {'x': x, 'y': y, 'z': z, 'value': 0});
            }
        }
        return {'data': data};
    }
});
