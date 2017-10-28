import { moduleForComponent, test } from 'ember-qunit';
import hbs from 'htmlbars-inline-precompile';

moduleForComponent('tlstar345-canvas', 'Integration | Component | tlstar345 canvas', {
  integration: true
});

test('it renders', function(assert) {
  // Set any properties with this.set('myProperty', 'value');
  // Handle any actions with this.on('myAction', function(val) { ... });

  this.render(hbs`{{tlstar345-canvas}}`);

  assert.equal(this.$().text().trim(), '');

  // Template block usage:
  this.render(hbs`
    {{#tlstar345-canvas}}
      template block text
    {{/tlstar345-canvas}}
  `);

  assert.equal(this.$().text().trim(), 'template block text');
});
