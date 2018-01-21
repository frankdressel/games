import Ember from 'ember';

export default Ember.Controller.extend({
    actions: {
        berechnet(){
            this.get('model').set('startState', false);
            this.get('model').set('berechnetState', true);
        },
        korrigiert(){

            let results=this.get('model').get('results').map(function(e){return e;});
            let counter=results.reduce(function(p, c){return p+(c==null?0:1)}, 0);
            if(this.model.get('result')==this.model.get('third')){
                results[counter]={correct:true, task: ''+this.get('model').get('first')+'<br>'+this.get('model').get('plusminus')+'<br>'+this.get('model').get('second')};
            }
            else{
                results[counter]={correct:false, task: ''+this.get('model').get('first')+'<br>'+this.get('model').get('plusminus')+'<br>'+this.get('model').get('second')};
            }
            let orig=this.get('model').get('results');
            orig.clear();
            results.forEach(function(e){orig.pushObject(e);});

            counter=counter+1;
            if(counter<this.get('model').get('results').length){
                this.initialise(this.get('model'));
            }
        }
    },
    initialise(model){
        function getRandomInt(min, max) {
            min = Math.ceil(min);
            max = Math.floor(max);
            return Math.floor(Math.random() * (max - min)) + min;
        }

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
        model.set('first', first);
        model.set('second', second);
        model.set('third', third);
        model.set('result', 0);
        model.set('plusminus', plusminus);
        model.set('startState', true);
        model.set('berechnetState', false);
    },
});
