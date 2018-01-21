import Ember from 'ember';

export default Ember.Component.extend({
    actions: {
        eingabe(evt){
            if(isNaN(parseInt(evt.originalEvent.key))){
                if(evt.originalEvent.key!='Backspace'){
                    evt.originalEvent.preventDefault();
                    return false;
                }
            }
            else{
                if(!isNaN(parseInt(this.get('val'))) && evt.originalEvent.key!='Backspace'){
                    evt.originalEvent.preventDefault();
                    return false;
                }
                else{
                    this.sendAction('numberEntered', this.get('name'), parseInt(evt.originalEvent.key));
                }
            }
        }
    },
    didUpdateAttrs(){
        this.set('val', '');
    }
});
