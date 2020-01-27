import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | game', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:game');
    assert.ok(route);
  });

  test('model creation from game_id', function(assert) {
    let route = this.owner.lookup('route:game');
    let game_id = 'eewb_b_0_0';
    let model = route.model({'game_id': game_id});

    assert.deepEqual([['e', 'e'], ['w', 'b']], model.grid);
    assert.deepEqual('b', model.turn);
    assert.deepEqual(2, model.size);
  });
});
