import Route from '@ember/routing/route';
import { tracked } from '@glimmer/tracking';

class Model {
  @tracked grid;
  @tracked turn;
  @tracked size;
  @tracked score_white;
  @tracked score_black;

  constructor(){
    this.grid = [];
    this.turn = 'b';
    this.size = 0;
    this.score_white = 0;
    this.score_black = 0;
  }
}

export default class GameRoute extends Route {
    model(param) {
      let split = param.game_id.split('_');
      let game_string = split[0];
      let grid = [];
      let size = Math.sqrt(game_string.length);
      if(size * size != game_string.length || split.length != 4) {
        return {};
      }

      for(let i = 0; i < size; i ++) {
        let _grid = [];
        for(let j  = 0; j < size; j++) {
          _grid.push(game_string.substr(i * size + j, 1));
        }
        grid.push(_grid);
      }

      let result = new Model();
      result.grid = grid;
      result.size = size;
      result.turn = split[1];
      result.score_white = parseInt(split[2]);
      result.score_black = parseInt(split[3]);

      return result;
    }
}
