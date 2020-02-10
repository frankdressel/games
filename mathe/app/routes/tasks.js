import Route from '@ember/routing/route';
import { tracked } from "@glimmer/tracking";

class Task {
  @tracked
  results = [];
  @tracked
  startState = true;
  @tracked
  berechnetState = false;
  @tracked
  counter = 0;
  @tracked
  done = false;
}

export default class TasksRoute extends Route {
  model() {
    let model = new Task();

    function getRandomInt(min, max) {
      min = Math.ceil(min);
      max = Math.floor(max);
      return Math.floor(Math.random() * (max - min)) + min;
    }

    for(let i=0;i<10;i++){
      let first=0;
      let second=0;
      let third=0;
      let plusminus='+';

      first=getRandomInt(1, 100000);
      let r = getRandomInt(0, 4);
      if(r==0){
          plusminus='+';
          second=getRandomInt(1, 100001 - first);
          third=first+second;
      }
      if(r==1){
          plusminus='-';
          second=getRandomInt(1, first);
          third=first-second;
      }
      if(r==2){
          plusminus='*';
          second=getRandomInt(1, Math.min(100, 100000 / first));
          third=first*second;
      }
      if(r==3){
          plusminus='/';
          first=getRandomInt(1, 10000);
          second = getRandomInt(1, Math.min(100, 100000 / first));
          third = first;
          first = first * second;
      }

      model.results.pushObject({
          first: first,
          second: second,
          third: third,
          plusminus: plusminus,
          @tracked
          correct: null
      });
   }

    return model;
  }
}
