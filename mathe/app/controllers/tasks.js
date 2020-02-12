import Controller from '@ember/controller';
import { action } from "@ember/object";

export default class TasksController extends Controller {
  constructor(){
    super(...arguments);
    this.counter =0;
  }

  @action
  berechnet(){
    this.model.startState = false;
    this.model.berechnetState = true;
  }

  @action
  korrigiert(){
    let results=this.model.results.map(function(e){return e;});
    if(results[this.counter].result==results[this.counter].third){
        results[this.counter].correct=true;
    }
    else{
        results[this.counter].correct=false;
    }

    this.counter = this.counter + 1;
    this.model.counter = this.counter;
    if(this.counter==this.model.results.length){
        this.model.done = true;
    }

    this.model.startState = true;
    this.model.berechnetState = false;
  }
}
