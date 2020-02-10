import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | tasks', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:tasks');
    assert.ok(route);
  });

  test('it contains 10 tasks', function(assert) {
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    assert.ok(model.results.length == 10);
  });

  test('correct flag is null', function(assert) {
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    for(let i = 0; i < model.results.length; i++) {
      assert.ok(model.results[i].correct == null);
    }
  });

  test('numbers are correct', function(assert) {
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    for(let i = 0; i < model.results.length; i++) {
      let result_i = model.results[i];
      switch(result_i.plusminus) {
        case '+':
          assert.equal(result_i.first + result_i.second, result_i.third);
          break;
        case '-':
          assert.equal(result_i.first - result_i.second, result_i.third);
          break;
        case '*':
          assert.equal(result_i.first * result_i.second, result_i.third);
          break;
        case '/':
          assert.equal(result_i.first / result_i.second, result_i.third);
          break;
      }
    }
  });
});
