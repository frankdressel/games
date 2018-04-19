import Route from '@ember/routing/route';
import RSVP from 'rsvp';
const Cell = Ember.Object.extend({})

export default Route.extend({
    queryParams: {
        id: {
            refreshModel: true
        }
    },
    model(){
        return new RSVP.Promise(function(resolve) {
            var worker = new Worker('sudokugenerator.js');
            worker.addEventListener('message', function(e) {
                let rawsudoku=e.data;
                let n=new Array(rawsudoku.length);
                for(let i=0;i<n.length;i++){
                    n[i]=[null, null, null, null, null, null, null, null, null];
                }
                for(let i=0;i<n.length;i++){
                    for(let j=0;j<n[i].length;j++){
                        if(rawsudoku[i][j]!=null){
                            n[i][j]=Cell.create({generated: true, symbol: rawsudoku[i][j]});
                        }
                        else{
                            n[i][j]=Cell.create({generated: false, symbol: ''});
                        }
                    }
                } 

                resolve(n);
            }, false);
            worker.postMessage({'cmd':'puzzle', 'diffscore': 40});
        });
    }
});
