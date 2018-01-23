import Ember from 'ember';

export default Ember.Controller.extend({
    actions: {
        berechnet(){
            this.get('model').set('startState', false);
            this.get('model').set('berechnetState', true);
        },
        korrigiert(){

            let results=this.get('model').get('results').map(function(e){return e;});
            let counter=results.reduce(function(p, c){return p+(c.result?1:0)}, 0);
            if(results[counter-1].result==results[counter-1].third){
                results[counter-1].correct=true;
            }
            else{
                results[counter-1].correct=false;
            }

            let modelresults=this.get('model').get('results');
            modelresults.clear();
            results.forEach(function(e){modelresults.pushObject(Ember.copy(e));});
            this.get('model').set('counter', counter);
            if(counter==this.get('model').get('results').length){
                this.get('model').set('done', true);
            }

            this.get('model').set('startState', true);
            this.get('model').set('berechnetState', false);
        },
        lernen(){
            window.location.replace('https://klexikon.zum.de/wiki/Spezial:Zuf%C3%A4llige_Seite');
        }
    },
    initialise(model){
        function getRandomInt(min, max) {
            min = Math.ceil(min);
            max = Math.floor(max);
            return Math.floor(Math.random() * (max - min)) + min;
        }

        model.set('counter', 0);
        for(let i=0;i<10;i++){
            let first=0;
            let second=0;
            let third=0;
            let plusminus='+';
            while(true){
                first=getRandomInt(0, 1000);
                second=getRandomInt(0, 1000);
                plusminus=getRandomInt(0, 2)==0?'-':'+';
                if(plusminus==='+' && first+second<=1000){
                    third=first+second;
                    break;
                }
                if(plusminus==='-' && first-second>=0){
                    third=first-second;
                    break;
                }
            }
            model.get('results').pushObject({
                first: first,
                second: second,
                third: third,
                result: 0,
                plusminus: plusminus,
            });
        }
    },
});
