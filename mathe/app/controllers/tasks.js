import Controller from '@ember/controller';
import { action } from "@ember/object";

export default class TasksController extends Controller {
  constructor(){
    super(...arguments);
  }

  @action
  berechnet(){
    this.model.startState = false;
    this.model.berechnetState = true;
  }

  @action
  korrigiert(){
    let results=this.model.results.map(function(e){return e;});
    let counter=results.reduce(function(p, c){return p+(c.result != null ? 1 : 0)}, 0);
    if(results[counter-1].result==results[counter-1].third){
        results[counter-1].correct=true;
    }
    else{
        results[counter-1].correct=false;
    }

    this.model.counter = counter;
    if(counter==this.model.results.length){
        this.model.done = true;
    }

    this.model.startState = true;
    this.model.berechnetState = false;
  }
}
