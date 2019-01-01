import Ember from 'ember';

export default Ember.Component.extend({
    actions: {
        berechnet(){
            this.sendAction('berechnet');
        },
        korrigiert(){
            this.get('model').get('results')[this.get('model').get('counter')].result=
                parseInt(this.get('value31')+''+this.get('value32')+''+this.get('value33')+''+this.get('value34')+''+this.get('value35')+''+this.get('value36'));
            this.sendAction('korrigiert');
            this.set('clearon', this.get('clearon')+1);
        },
        numberEntered(name, value){
            this.set(name, value);
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

        for(let i=1; i<=3;i++){
            for(let j=1;j<=6;j++){
                this.set('value'+i+j, '');
            }
        }
        for(let i=1;i<Math.min(6, firstString.length+1);i++){
            this.set('value1'+(i+6-firstString.length), firstString.substr(i-1, 1));
        }
        for(let i=1;i<Math.min(6, secondString.length+1);i++){
            this.set('value2'+(i+6-secondString.length), secondString.substr(i-1, 1));
        }
    }
});
