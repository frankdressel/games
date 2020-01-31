import Component from '@ember/component';

export default Component.extend({
    actions: {
        berechnet(){
            this.sendAction('berechnet');
        },
        korrigiert(){
            this.model.get('results')[this.model.get('counter')].result=parseInt(this.thirdnumbers.reduce((p, c) => p+''+c));
            this.sendAction('korrigiert');
            this.set('clearon', this.clearon+1);
        },
        numberEntered(index, value){
            this.thirdnumbers[index]=value;
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
        if(this.model.get('done')){
            return;
        }
        this.set('plusminus', this.model.get('results')[this.model.get('counter')].plusminus)

        let firstString=""+this.model.get('results')[this.model.get('counter')].first;
        let secondString=""+this.model.get('results')[this.model.get('counter')].second;
        let thirdString=""+this.model.get('results')[this.model.get('counter')].third;

        
        this.set('firstnumbers', firstString.padStart(6, ' ').split(''));
        this.set('secondnumbers', secondString.padStart(6, ' ').split(''));
        this.set('thirdnumbers', thirdString.padStart(6, ' ').split(''));
    }
});
