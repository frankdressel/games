import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Controller | tasks', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let controller = this.owner.lookup('controller:tasks');
    assert.ok(controller);
  });

  test('berechnet sets state', function(assert) {
    let controller = this.owner.lookup('controller:tasks');
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    controller.set('model', model);

    assert.equal(model.startState, true);
    assert.equal(model.berechnetState, false);
    controller.berechnet();
    assert.equal(model.startState, false);
    assert.equal(model.berechnetState, true);
  });

  test('korrigiert sets state and correct flag', function(assert) {
    let controller = this.owner.lookup('controller:tasks');
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    controller.set('model', model);

    for(let i = 0; i < model.results.length; i++) {
      assert.equal(model.counter, i);

      // First half of results is wrong, last half set to correct values.
      model.results[i].result = i < model.results.length / 2 ? model.results[i].third- 1 : model.results[i].third;
      model.startState = false;
      model.berechnetState = true;

      assert.equal(model.startState, false);
      assert.equal(model.berechnetState, true);
      controller.korrigiert();
      assert.equal(model.startState, true);
      assert.equal(model.berechnetState, false);
      assert.equal(model.results[i].correct, i < model.results.length / 2 ? false : true);
    }
  });
});
