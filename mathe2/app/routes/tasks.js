import Route from '@ember/routing/route';
import EmberObject from '@ember/object';
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
      while(true){
          first=getRandomInt(1, 100000);
          let r = getRandomInt(0, 4);
          if(r==0){
              plusminus='+';
              second=getRandomInt(1, 100000);
              if(first+second<=100000){
                  third=first+second;
                  break;
              }
          }
          if(r==1){
              plusminus='-';
              second=getRandomInt(1, 100000);
              if(first-second>=0){
                  third=first-second;
                  break;
              }
          }
          if(r==2){
              plusminus='*';
              second=getRandomInt(1, 100);
              if(first*second<=100000){
                  third=first*second;
                  break;
              }
          }
          if(r==3){
              plusminus='/';
              second=getRandomInt(1, 100);
              if(first/second>=0){
                  third=Math.floor(first/second);
                  break;
              }
              console.log(first+","+second+","+third);
          }
      }
      model.results.pushObject({
          first: first,
          second: second,
          third: third,
          result: 0,
          plusminus: plusminus,
          @tracked
          correct: null
      });
   }

    return model;
  }
}
