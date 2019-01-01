import Ember from 'ember';

export default Ember.Component.extend({
    actions: {
        berechnet(){
            this.sendAction('berechnet');
        },
        korrigiert(){
            this.get('model').get('results')[this.get('model').get('counter')].result=parseInt(this.get('thirdnumbers').reduce((p, c) => p+''+c));
            this.sendAction('korrigiert');
            this.set('clearon', this.get('clearon')+1);
        },
        numberEntered(index, value){
            this.get('thirdnumbers')[index]=value;
        }
    },
    init() {
        this._super(...arguments);
        this.set('clearon', 0);
    },
    didUpdateAttrs(){
        if(arguments[0].newAttrs['startState'].value){
            this.update();
        }
    },
    didReceiveAttrs(){
        if(arguments[0].newAttrs['startState'].value){
            this.update();
        }
    },
    update(){
        if(this.get('model').get('done')){
            return;
        }
        this.set('plusminus', this.get('model').get('results')[this.get('model').get('counter')].plusminus)

        let firstString=""+this.get('model').get('results')[this.get('model').get('counter')].first;
        let secondString=""+this.get('model').get('results')[this.get('model').get('counter')].second;
        let thirdString=""+this.get('model').get('results')[this.get('model').get('counter')].third;

        
        this.set('firstnumbers', firstString.padStart(6, ' ').split(''));
        this.set('secondnumbers', secondString.padStart(6, ' ').split(''));
        this.set('thirdnumbers', thirdString.padStart(6, ' ').split(''));
    }
});
