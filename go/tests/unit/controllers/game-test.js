import { module, test } from 'qunit';
import { currentURL, settled, visit } from '@ember/test-helpers';
import { setupTest } from 'ember-qunit';

module('Unit | Controller | game', function(hooks) {
  setupTest(hooks);

  // Replace this with your real tests.
  test('it exists', function(assert) {
    let controller = this.owner.lookup('controller:game');
    assert.ok(controller);
  });

  test('click sets stone', function(assert) {
    const connectionService = this.owner.lookup('service:connection');
    const send = connectionService.send;

    // See this ember bug/PR: https://github.com/emberjs/ember.js/issues/16831
    this.owner.setupRouter();
    let controller = this.owner.lookup('controller:game');
    let game = {'grid': [['e','e'], ['e', 'e']], 'turn': 'b', 'score_white': 0, 'score_black': 0};
    controller.set('model', game);

    // Stub
    connectionService.send = () => {
      assert.ok('someMethod was called');
      connectionService.send = send;
    };
    controller.click(0, 1);

    assert.equal('b', game.grid[0][1]);
    assert.equal('e', game.grid[0][0]);
    assert.equal('e', game.grid[1][0]);
    assert.equal('e', game.grid[1][1]);
    assert.equal('w', game.turn);
    assert.equal(1, game.score_black);

    // Stub
    connectionService.send = () => {
      assert.ok('someMethod was called');
      connectionService.send = send;
    };
    controller.click(1, 0);
    assert.equal('b', game.grid[0][1]);
    assert.equal('e', game.grid[0][0]);
    assert.equal('w', game.grid[1][0]);
    assert.equal('e', game.grid[1][1]);
    assert.equal('b', game.turn);
    assert.equal(1, game.score_white);
  });

  test('clicking on set stones not possible', function(assert) {
    const connectionService = this.owner.lookup('service:connection');
    const send = connectionService.send;

    // See this ember bug/PR: https://github.com/emberjs/ember.js/issues/16831
    this.owner.setupRouter();
    let controller = this.owner.lookup('controller:game');
    let game = {'grid': [['e','e'], ['e', 'e']], 'turn': 'b', 'score_white': 0, 'score_black': 0};
    controller.set('model', game);

    // Stub
    connectionService.send = () => {
      assert.ok('someMethod was called');
      connectionService.send = send;
    };
    controller.click(0, 1);

    assert.equal('b', game.grid[0][1]);
    assert.equal('e', game.grid[0][0]);
    assert.equal('e', game.grid[1][0]);
    assert.equal('e', game.grid[1][1]);
    assert.equal('w', game.turn);

    // Stub
    connectionService.send = () => {
      assert.ok('someMethod was called');
      connectionService.send = send;
    };
    controller.click(0, 1);
    assert.equal('b', game.grid[0][1]);
    assert.equal('e', game.grid[0][0]);
    assert.equal('e', game.grid[1][0]);
    assert.equal('e', game.grid[1][1]);
    assert.equal('w', game.turn);

    // Stub
    connectionService.send = () => {
      assert.ok('someMethod was called');
      connectionService.send = send;
    };
    controller.click(0, 0);
    assert.equal('b', game.grid[0][1]);
    assert.equal('w', game.grid[0][0]);
    assert.equal('e', game.grid[1][0]);
    assert.equal('e', game.grid[1][1]);
    assert.equal('b', game.turn);
    
    // Stub
    connectionService.send = () => {
      assert.ok('someMethod was called');
      connectionService.send = send;
    };
    controller.click(0, 0);
    assert.equal('b', game.grid[0][1]);
    assert.equal('w', game.grid[0][0]);
    assert.equal('e', game.grid[1][0]);
    assert.equal('e', game.grid[1][1]);
    assert.equal('b', game.turn);
  });

  test('freedom calculation', function(assert) {
    let controller = this.owner.lookup('controller:game');
    let grid = [['e','e', 'e'], ['e','b', 'e'], ['e','e', 'e']];
    let game = {'grid': grid, 'turn': 'b', 'score_white': 0, 'score_black': 0};
    controller.set('model', game);

    controller.freedom('w'); 
    controller.freedom('b'); 

    assert.equal('e', game.grid[0][0]);
    assert.equal('e', game.grid[0][1]);
    assert.equal('e', game.grid[0][2]);
    assert.equal('e', game.grid[1][0]);
    assert.equal('b', game.grid[1][1]);
    assert.equal('e', game.grid[1][2]);
    assert.equal('e', game.grid[2][0]);
    assert.equal('e', game.grid[2][1]);
    assert.equal('e', game.grid[2][2]);

    grid = [['e','w', 'e'], ['w','b', 'w'], ['e','w', 'e']];
    game = {'grid': grid, 'turn': 'b', 'score_white': 0, 'score_black': 0};
    controller.set('model', game);

    controller.freedom('w'); 

    assert.equal('e', game.grid[0][0]);
    assert.equal('w', game.grid[0][1]);
    assert.equal('e', game.grid[0][2]);
    assert.equal('w', game.grid[1][0]);
    assert.equal('e', game.grid[1][1]);
    assert.equal('w', game.grid[1][2]);
    assert.equal('e', game.grid[2][0]);
    assert.equal('w', game.grid[2][1]);
    assert.equal('e', game.grid[2][2]);
  });

  test('score calculation', function(assert) {
    let controller = this.owner.lookup('controller:game');
    let grid = [
      ['b', 'e', 'w', 'e', 'b'],
      ['e', 'w', 'b', 'w', 'e'],
      ['e', 'w', 'b', 'w', 'e'],
      ['e', 'e', 'w', 'b', 'e'],
      ['e', 'e', 'e', 'b', 'e'],
    ];
    let game = {'grid': grid, 'turn': 'b', 'score_white': 6, 'score_black': 6};
    controller.set('model', game);

    assert.equal(6, game.score_white);
    assert.equal(6, game.score_black);

    controller.freedom('w'); 
    controller.freedom('b'); 

    assert.equal(8, game.score_white);
    assert.equal(4, game.score_black);
  });

  test('updates with message arival',function(assert) {
    assert.expect(1);

    const connectionService = this.owner.lookup('service:connection');
    const send = connectionService.send;

    let controller = this.owner.lookup('controller:game');
    let grid = [['e','e', 'e'], ['e','b', 'e'], ['e','e', 'e']];
    let game = {'grid': grid, 'turn': 'b', 'score_white': 0, 'score_black': 0};
    controller.set('model', game);
    
    // Stub
    const _set_state = controller._set_state;
    controller._set_state = () => {
      assert.ok(true);
      controller._set_state = _set_state;
    };
    connectionService.send = () => {
      connectionService.send = send;
    };
    connectionService.update = controller._set_state;

    connectionService._onmessage(connectionService)('test');
  })

  test('show_config method willtransition to config on initial route', async function(assert) {
    assert.expect(1);

    await visit('/game/eeee_0_0_b');

    let controller = this.owner.lookup('controller:game');
    let grid = [['e','e'], ['e','e']];
    let game = {'grid': grid, 'turn': 'b', 'score_white': 0, 'score_black': 0};
    controller.set('model', game);

    controller.show_config();
    settled().then(function() {
      assert.equal('/', currentURL());
    });
  });
});
