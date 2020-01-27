import { module, test } from 'qunit';
import { currentURL, settled, visit } from '@ember/test-helpers';
import { setupTest } from 'ember-qunit';

module('Unit | Controller | index', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let controller = this.owner.lookup('controller:index');
    assert.ok(controller);
  });

  test('new game will transition to new game route', async function(assert) {
    assert.expect(1);

    await visit('/');

    let controller = this.owner.lookup('controller:index');
    controller.set('model', {});
    controller.new_game();
    settled().then(function() {
      assert.equal('/game/', currentURL().substr(0, 6));
    });
  });
});
