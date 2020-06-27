function coordinates(index, base_length) {
    let block = Math.floor(index/Math.pow(base_length, 2));
    let cell = index - block * Math.pow(base_length, 2);

    return {block: block, cell: cell};
}

class Cell {
  block
  cell
  id

  constructor(index, base_length) {
    var {block, cell} = coordinates(index, base_length);
    this.block = block;
    this.cell = cell;
    this.id = 'cell' + index;
  }
}

class Game {
  base_length
  cells
  players
  active_player
  remaining_actions
  round;

  constructor({base_length, loop_length}={}) {
    this.base_length = base_length;
    this.cells = [];
    this.players = ['one', 'two'];
    this.active_player = 'one';
    this.remaining_actions = {'one': 2, 'two': 2};
    this.round = 0;

    let permutations = [];
    for(let i = 0; i < loop_length; i++) {
      let perm = [];
      for(let j = 0; j < Math.pow(base_length, 4); j++) {
        perm.push(j);
      }
      permutations.push(perm);
    }

    for(let i = 0; i < Math.pow(base_length, 4); i++) {
      let cell = new Cell(i, this.base_length)
      cell.sequence = [];
      for(let j = 0; j < loop_length; j++) {
        var new_coord = coordinates(permutations[j].splice(Math.floor(Math.random() * permutations[j].length), 1), base_length);
        cell.sequence.push(new_coord);
      }
      this.cells.push(cell);
    }
  }

  process_state() {
    let remaining = Object.values(this.remaining_actions).reduce((a, b) => a + b, 0);
    if(remaining > 0) {
      return;
    }

    this.round = this.round + 1;
    this.remaining_actions = {'one': 2, 'two': 2};
  }
}

export {Game};
