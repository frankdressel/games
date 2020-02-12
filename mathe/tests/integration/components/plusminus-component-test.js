import { module, test } from 'qunit';
import { setupRenderingTest } from 'ember-qunit';
import { click, find, findAll, render } from '@ember/test-helpers';
import { hbs } from 'ember-cli-htmlbars';

module('Integration | Component | plusminus-component', function(hooks) {
  setupRenderingTest(hooks);

  test('it renders', async function(assert) {
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    this.set('model', model);

    await render(hbs`<PlusminusComponent @model={{model}}/>`);

    // Template block usage:
    await render(hbs`
      <PlusminusComponent @model={{model}}>
      </PlusminusComponent>
    `);

    assert.ok(true);
  });

  test('it show success markers', async function(assert) {
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    this.set('model', model);

    await render(hbs`<PlusminusComponent @model={{model}}/>`);

    assert.equal(findAll('.success-marker').length, model.results.length);
  });

  test('it shows 6 digit number fields with input', async function(assert) {
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    this.set('model', model);

    await render(hbs`<PlusminusComponent @model={{model}}/>`);

    assert.equal(findAll('.first').length, 6);
    assert.equal(findAll('.second').length, 6);
    assert.equal(findAll('.third').length, 6);

    for(let e of findAll('.third')) {
      assert.equal(e.nodeName, 'INPUT');
      assert.ok(!e.disabled);
    }
  });

  test('it shows an button to submit the result', async function(assert) {
    assert.expect(3);

    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    this.set('model', model);

    this.set('korrigiert', function() {
      assert.ok(true);
    });
    this.set('berechnet', function() {
      assert.ok(true);
    });

    await render(hbs`<PlusminusComponent @model={{model}} @berechnet={{action berechnet}} @korrigiert={{action korrigiert}}/>`);

    let button = find('.ready');
    assert.ok(button);
    click(button);
    click(button);
  });

  test('input is set at least at second button click', async function(assert) {
    assert.expect(3);

    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    this.set('model', model);

    this.set('korrigiert', function() {
      assert.equal(model.results[model.counter].third, 123456);
    });
    this.set('berechnet', function() {
      assert.ok(true);
    });

    await render(hbs`<PlusminusComponent @model={{model}} @berechnet={{action berechnet}} @korrigiert={{action korrigiert}}/>`);

    let num_input = findAll('.third');
    for(let i = 0; i < num_input.lenth; i++) {
      num_input[i].value = '' + (i+1);
    }

    let button = find('.ready');
    assert.ok(button);
    click(button);
    click(button);
  });

  test('success-marker shows task after submit', async function(assert) {
    let route = this.owner.lookup('route:tasks');
    let model = route.model();
    this.set('model', model);

    for(let i = 0; i < model.results.length; i++) {
      await render(hbs`<PlusminusComponent @model={{model}}/>`);
      let exp = '' +i;
      assert.equal(findAll('.success-marker')[i].textContent, exp);

      model.results[i].correct = true;
      await render(hbs`<PlusminusComponent @model={{model}}/>`);
      exp = model.results[i].first + model.results[i].plusminus + model.results[i].second;
      assert.equal(findAll('.success-marker')[i].textContent, exp);

      model.results[i].correct = false;
      await render(hbs`<PlusminusComponent @model={{model}}/>`);
      exp = model.results[i].first + model.results[i].plusminus + model.results[i].second;
      assert.equal(findAll('.success-marker')[i].textContent, exp);
    }
  });
});
