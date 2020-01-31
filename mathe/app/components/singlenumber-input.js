import Component from '@ember/component';

export default Component.extend({
    actions: {
        eingabe(evt){
            if(isNaN(parseInt(evt.originalEvent.key))){
                if(evt.originalEvent.key!='Backspace'){
                    evt.originalEvent.preventDefault();
                    return false;
                }
            }
            else{
                if(!isNaN(parseInt(this.val)) && evt.originalEvent.key!='Backspace'){
                    evt.originalEvent.preventDefault();
                    return false;
                }
                else{
                    this.sendAction('numberEntered', this.index, parseInt(evt.originalEvent.key));
                }
            }
        }
    },
    didUpdateAttrs(){
        this.set('val', '');
    }
});
