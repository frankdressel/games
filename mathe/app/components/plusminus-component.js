import Component from '@glimmer/component';
import { action } from "@ember/object";
import { tracked } from "@glimmer/tracking";

export default class PlusminusComponentComponent extends Component {
  @tracked
  plusminus;
  @tracked
  firstnumbers;
  @tracked
  secondnumbers;
  @tracked
  thirdnumbers;

  constructor() {
    super(...arguments);
    this.clearon = 0;
    this.update();
  }

  @action
  berechnet(){
      this.args.berechnet();
  }

  @action
  korrigiert(){
      this.args.model.results[this.args.model.counter].result=parseInt(this.thirdnumbers.reduce((p, c) => p+''+c));
      this.args.korrigiert();
      this.clearon = this.clearon+1;
  }

  @action
  numberEntered(index, evt){
      this.thirdnumbers[index]=evt.currentTarget.value.trim();
      this.thirdnumbers=this.thirdnumbers;
  }

  @action
  update(){
    if(this.args.model.done){
        return;
    }

    this.plusminus = this.args.model.results[this.args.model.counter].plusminus;

    let firstString=""+this.args.model.results[this.args.model.counter].first;
    let secondString=""+this.args.model.results[this.args.model.counter].second;
    let thirdString="";

    
    this.firstnumbers = firstString.padStart(6, ' ').split('');
    this.secondnumbers = secondString.padStart(6, ' ').split('');
    this.thirdnumbers = thirdString.padStart(6, ' ').split('');
  }
}
