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
    let counter=results.reduce(function(p, c){return p+(c.result?1:0)}, 0);
    if(results[counter-1].result==results[counter-1].third){
        results[counter-1].correct=true;
    }
    else{
        results[counter-1].correct=false;
    }

    //let modelresults=this.model.get('results');
    //modelresults.clear();
    //results.forEach(function(e){modelresults.pushObject(copy(e));});
    this.model.counter = counter;
    if(counter==this.model.results.length){
        this.model.done = true;
    }

    this.model.startState = true;
    this.model.berechnetState = false;
  }

  @action
  lernen(){
    window.location.replace('https://klexikon.zum.de/wiki/Spezial:Zuf%C3%A4llige_Seite');
  }
}
