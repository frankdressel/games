import {Game} from '../data.js';

describe('Game test', function() {
  let game;

  beforeEach(function() {
    game = new Game({base_length: 3, loop_length: 3});
  });

  it('creates the cells', function() {
    expect(game.cells.length).toBe(81);

    expect(game.cells[0].block).toBe(0);
    expect(game.cells[0].cell).toBe(0)

    expect(game.cells[80].block).toBe(8);
    expect(game.cells[80].cell).toBe(8)
  });

  it('has the given loop length for all cells', function() {
    for (let cell of game.cells) {
        expect(cell.sequence.length).toBe(3);
    }
    for (var i = 0; i < 3; i++) {
        let fields = new Set();
        for (let cell of game.cells) {
            fields.add(cell.sequence[i]);
        }
        
        expect(fields.size).toBe(81);

        for (const f of fields) {
            expect(typeof f.block).toBe('number');
            expect(typeof f.cell).toBe('number');
        }
    }
  });

  it('can switch to next round if both players did their actions', function() {
    expect(game.round).toBe(0);
    game.remaining_actions = {'one': 2, 'two': 2};
    game.process_state();
    expect(game.round).toBe(0);

    game.remaining_actions = {'one': 0, 'two': 0};
    game.process_state();
    expect(game.round).toBe(1);
    expect(game.remaining_actions['one']).toBe(2);
    expect(game.remaining_actions['two']).toBe(2);
  });
});
