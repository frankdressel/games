import Component from '@glimmer/component';
import { action } from "@ember/object";

export default class SinglenumberInputComponent extends Component {
  @action
  eingabe(evt){
    if(isNaN(parseInt(evt.key))){
      if(evt.key!='Backspace'){
        evt.preventDefault();
        return false;
      }
    }
    else{
      if(!isNaN(parseInt(this.val)) && evt.key!='Backspace'){
        evt.preventDefault();
        return false;
      }
      else{
        this.args.numberEntered(this.args.index, parseInt(evt.key));
      }
    }
  }
}
