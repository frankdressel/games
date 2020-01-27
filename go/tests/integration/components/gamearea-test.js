import { module, test } from 'qunit';
import { setupRenderingTest } from 'ember-qunit';
import { click, doubleClick, find, render, triggerEvent } from '@ember/test-helpers';
import { hbs } from 'ember-cli-htmlbars';

module('Integration | Component | gamearea', function(hooks) {
  setupRenderingTest(hooks);

  test('it renders', async function(assert) {
    this.set('_click', function() {
    });
    this.set('_show_config', function() {
    });

    await render(hbs`<Gamearea @click={{action _click}} @show_config={{action _show_config}}/>`);

    assert.ok(find('#game'));
    
    // Template block usage:
    await render(hbs`
      <Gamearea @click={{action _click}} @show_config={{action _show_config}}>
      </Gamearea>
    `);

    assert.ok(find('#game'));
  });

  test('click calls external click function', async function(assert) {
    assert.expect(2);

    this.set('_click', function() {
      assert.ok(true);
    });
    this.set('_show_config', function() {
      assert.ok(true);
    });

    // Template block usage:
    await render(hbs`
      <Gamearea @click={{action _click}} @show_config={{action _show_config}}>
      </Gamearea>
    `);

    let bb = document.getElementById('click_bb').getBoundingClientRect();

    var ev = new MouseEvent('click', {
        'view': window,
        'bubbles': true,
        'cancelable': true,
        'clientX': 60 + bb.left,
        'clientY': 60 + bb.top
    });

    document.getElementById('click_bb').dispatchEvent(ev);

    await doubleClick('#partysign');
  });
});
