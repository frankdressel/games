import { module, test } from 'qunit';
import { setupRenderingTest } from 'ember-qunit';
import { findAll, render } from '@ember/test-helpers';
import { hbs } from 'ember-cli-htmlbars';

module('Integration | Component | plusminus-component', function(hooks) {
  setupRenderingTest(hooks);

  test('it renders', async function(assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.set('myAction', function(val) { ... });

    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    this.set('model', model);

    await render(hbs`<PlusminusComponent @model={{model}}/>`);

    // Template block usage:
    await render(hbs`
      <PlusminusComponent @model={{model}}>
      </PlusminusComponent>
    `);

    assert.equal(findAll('.success-marker').length, model.results.length);
  });
});
