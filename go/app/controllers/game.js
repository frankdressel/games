import Controller from '@ember/controller';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';

export default class GameController extends Controller {
  @service('connection') connection;

  constructor() {
    super(...arguments);
    this.connection.set('update', this._set_state(this));
  }

  @action
  click(index_i, index_j) {
    let model = this.get('model');
    let grid = model.grid;
    if(grid[index_i][index_j] != 'e') {
      return;
    }

    this._update(grid, model, index_i, index_j);

    let state = '';
    for(let i = 0; i < grid.length; i++) {
      for(let j = 0; j < grid[i].length; j++) {
        state = state + grid[i][j];
      }
    }

    let deep_link = state + '_' + model.turn + '_' + model.score_white + '_' + model.score_black;
    this.transitionToRoute('/game/' + deep_link);

    this.connection.send(deep_link);
  }

  @action
  show_config() {
    this.transitionToRoute('/');
  }

  _set_state(self) {
    function set_stateWithController(deep_link) {
      self.transitionToRoute('/game/' + deep_link);
    }

    return set_stateWithController;
  }

  _update(grid, model, index_i, index_j) {
    grid.get(index_i).set(index_j,  model.turn);
    model.grid = grid;

    model.score_black = model.score_black + (model.turn == 'b' ? 1 : 0);
    model.score_white = model.score_white + (model.turn == 'w' ? 1 : 0);
    
    this.freedom(model.turn);
    model.turn = model.turn == 'w' ? 'b' : 'w';
    this.freedom(model.turn);
  }

  _get_neighbors(ni, nj, size) {
    let result = [];
    for(let i = Math.max(ni - 1, 0); i < Math.min(size, ni + 2); i++) {
      for(let j = Math.max(nj - 1, 0); j < Math.min(size, nj + 2); j++) {
        if((i == ni && j == nj) || (i != ni && j != nj)) {
          continue;
        }

        result.push([i,j]);
      }
    }

    return result;
  }

  _get_id(i, j, size) {
    return i * size + j;
  }

  freedom(party) {
    let model = this.get('model');
    let grid = model.grid;
    let grid_size = grid.length;

    let clusters = new Set();
    let not_visited = new Set();
    for(let i = 0; i < grid.length; i++) {
      for(let j = 0; j < grid[i].length; j++) {
        not_visited.add(this._get_id(i, j, grid_size));
      }
    }
    for(let i = 0; i < grid_size; i++) {
      for(let j = 0; j < grid_size; j++) {
        if(!not_visited.has(this._get_id(i, j, grid_size))) {
          continue;
        }
        if(grid[i][j] == 'e' || grid[i][j] == party) {
          continue;
        }

        let cluster = new Set();
        cluster.add([i, j]);
        not_visited.delete(this._get_id(i, j, grid_size));
        let size = 0;
        while(size != cluster.size) {
          size = cluster.size;
          let new_neighs = [];
          for(let c of cluster) {
            new_neighs = new_neighs.concat(this._get_neighbors(c[0], c[1], grid_size).filter(n => not_visited.has(this._get_id(n[0], n[1], grid_size))).filter(n => grid[n[0]][n[1]] == grid[i][j]));
          }
          for(let n of new_neighs) {
            if(not_visited.has(this._get_id(n[0], n[1], grid_size))) {
              cluster.add(n);
              not_visited.delete(this._get_id(n[0], n[1], grid_size));
            }
          }
        }

        clusters.add(cluster);
      }
    }

    for(let c of clusters) {
      let fd = 0;
      for(let cr of c) {
        let _fd = this._get_neighbors(cr[0], cr[1], grid_size).map(n => grid[n[0]][n[1]] == 'e' ? 1 : 0).reduce((p, c) => p + c, 0);
        fd = fd + _fd;
      }

      if(fd == 0) {
        for(let cr of c) {
          grid.get(cr[0]).set(cr[1], 'e');
        }
        if(party == 'b') {
          model.score_black = model.score_black + c.size;
          model.score_white = model.score_white - c.size;
        }
        if(party == 'w') {
          model.score_white = model.score_white + c.size;
          model.score_black = model.score_black - c.size;
        }
      }
    }
  }
}
