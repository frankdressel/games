'use strict';

define("mathe2/tests/integration/components/plusminus-component-test", ["qunit", "ember-qunit", "@ember/test-helpers"], function (_qunit, _emberQunit, _testHelpers) {
  "use strict";

  (0, _qunit.module)('Integration | Component | plusminus-component', function (hooks) {
    (0, _emberQunit.setupRenderingTest)(hooks);
    (0, _qunit.test)('it renders', async function (assert) {
      let route = this.owner.lookup('route:tasks');
      let model = route.model();
      this.set('model', model);
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <PlusminusComponent @model={{model}}/>
      */
      {
        id: "e96+mVyq",
        block: "{\"symbols\":[],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\"],[[22,\"model\"]]]]],\"hasEval\":false}",
        meta: {}
      })); // Template block usage:

      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        
            <PlusminusComponent @model={{model}}>
            </PlusminusComponent>
          
      */
      {
        id: "6O8PoV/9",
        block: "{\"symbols\":[],\"statements\":[[0,\"\\n      \"],[5,\"plusminus-component\",[],[[\"@model\"],[[22,\"model\"]]],{\"statements\":[[0,\"\\n      \"]],\"parameters\":[]}],[0,\"\\n    \"]],\"hasEval\":false}",
        meta: {}
      }));
      assert.ok(true);
    });
    (0, _qunit.test)('it show success markers', async function (assert) {
      let route = this.owner.lookup('route:tasks');
      let model = route.model();
      this.set('model', model);
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <PlusminusComponent @model={{model}}/>
      */
      {
        id: "e96+mVyq",
        block: "{\"symbols\":[],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\"],[[22,\"model\"]]]]],\"hasEval\":false}",
        meta: {}
      }));
      assert.equal((0, _testHelpers.findAll)('.success-marker').length, model.results.length);
    });
    (0, _qunit.test)('it shows 6 digit number fields with input', async function (assert) {
      let route = this.owner.lookup('route:tasks');
      let model = route.model();
      this.set('model', model);
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <PlusminusComponent @model={{model}}/>
      */
      {
        id: "e96+mVyq",
        block: "{\"symbols\":[],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\"],[[22,\"model\"]]]]],\"hasEval\":false}",
        meta: {}
      }));
      assert.equal((0, _testHelpers.findAll)('.first').length, 6);
      assert.equal((0, _testHelpers.findAll)('.second').length, 6);
      assert.equal((0, _testHelpers.findAll)('.third').length, 6);

      for (let e of (0, _testHelpers.findAll)('.third')) {
        assert.equal(e.nodeName, 'INPUT');
        assert.ok(!e.disabled);
      }
    });
    (0, _qunit.test)('it shows an button to submit the result', async function (assert) {
      assert.expect(3);
      let route = this.owner.lookup('route:tasks');
      let model = route.model();
      this.set('model', model);
      this.set('korrigiert', function () {
        assert.ok(true);
      });
      this.set('berechnet', function () {
        assert.ok(true);
      });
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <PlusminusComponent @model={{model}} @berechnet={{action berechnet}} @korrigiert={{action korrigiert}}/>
      */
      {
        id: "tyjcJ6rp",
        block: "{\"symbols\":[],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\",\"@berechnet\",\"@korrigiert\"],[[22,\"model\"],[28,\"action\",[[23,0,[]],[24,[\"berechnet\"]]],null],[28,\"action\",[[23,0,[]],[24,[\"korrigiert\"]]],null]]]]],\"hasEval\":false}",
        meta: {}
      }));
      let button = (0, _testHelpers.find)('.ready');
      assert.ok(button);
      (0, _testHelpers.click)(button);
      (0, _testHelpers.click)(button);
    });
    (0, _qunit.test)('input is set at least at second button click', async function (assert) {
      assert.expect(3);
      let route = this.owner.lookup('route:tasks');
      let model = route.model();
      this.set('model', model);
      this.set('korrigiert', function () {
        assert.equal(model.results[model.counter].third, 123456);
      });
      this.set('berechnet', function () {
        assert.ok(true);
      });
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <PlusminusComponent @model={{model}} @berechnet={{action berechnet}} @korrigiert={{action korrigiert}}/>
      */
      {
        id: "tyjcJ6rp",
        block: "{\"symbols\":[],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\",\"@berechnet\",\"@korrigiert\"],[[22,\"model\"],[28,\"action\",[[23,0,[]],[24,[\"berechnet\"]]],null],[28,\"action\",[[23,0,[]],[24,[\"korrigiert\"]]],null]]]]],\"hasEval\":false}",
        meta: {}
      }));
      let num_input = (0, _testHelpers.findAll)('.third');

      for (let i = 0; i < num_input.lenth; i++) {
        num_input[i].value = '' + (i + 1);
      }

      let button = (0, _testHelpers.find)('.ready');
      assert.ok(button);
      (0, _testHelpers.click)(button);
      (0, _testHelpers.click)(button);
    });
    (0, _qunit.test)('success-marker shows task after submit', async function (assert) {
      let route = this.owner.lookup('route:tasks');
      let model = route.model();
      this.set('model', model);

      for (let i = 0; i < model.results.length; i++) {
        await (0, _testHelpers.render)(Ember.HTMLBars.template(
        /*
          <PlusminusComponent @model={{model}}/>
        */
        {
          id: "e96+mVyq",
          block: "{\"symbols\":[],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\"],[[22,\"model\"]]]]],\"hasEval\":false}",
          meta: {}
        }));
        let exp = '' + i;
        assert.equal((0, _testHelpers.findAll)('.success-marker')[i].textContent, exp);
        model.results[i].correct = true;
        await (0, _testHelpers.render)(Ember.HTMLBars.template(
        /*
          <PlusminusComponent @model={{model}}/>
        */
        {
          id: "e96+mVyq",
          block: "{\"symbols\":[],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\"],[[22,\"model\"]]]]],\"hasEval\":false}",
          meta: {}
        }));
        exp = model.results[i].first + model.results[i].plusminus + model.results[i].second;
        assert.equal((0, _testHelpers.findAll)('.success-marker')[i].textContent, exp);
        model.results[i].correct = false;
        await (0, _testHelpers.render)(Ember.HTMLBars.template(
        /*
          <PlusminusComponent @model={{model}}/>
        */
        {
          id: "e96+mVyq",
          block: "{\"symbols\":[],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\"],[[22,\"model\"]]]]],\"hasEval\":false}",
          meta: {}
        }));
        exp = model.results[i].first + model.results[i].plusminus + model.results[i].second;
        assert.equal((0, _testHelpers.findAll)('.success-marker')[i].textContent, exp);
      }
    });
  });
});
define("mathe2/tests/lint/app.lint-test", [], function () {
  "use strict";

  QUnit.module('ESLint | app');
  QUnit.test('app.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'app.js should pass ESLint\n\n');
  });
  QUnit.test('components/plusminus-component.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/plusminus-component.js should pass ESLint\n\n');
  });
  QUnit.test('controllers/tasks.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/tasks.js should pass ESLint\n\n');
  });
  QUnit.test('router.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'router.js should pass ESLint\n\n');
  });
  QUnit.test('routes/tasks.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/tasks.js should pass ESLint\n\n');
  });
});
define("mathe2/tests/lint/templates.template.lint-test", [], function () {
  "use strict";

  QUnit.module('TemplateLint');
  QUnit.test('mathe2/templates/application.hbs', function (assert) {
    assert.expect(1);
    assert.ok(true, 'mathe2/templates/application.hbs should pass TemplateLint.\n\n');
  });
  QUnit.test('mathe2/templates/tasks.hbs', function (assert) {
    assert.expect(1);
    assert.ok(true, 'mathe2/templates/tasks.hbs should pass TemplateLint.\n\n');
  });
});
define("mathe2/tests/lint/tests.lint-test", [], function () {
  "use strict";

  QUnit.module('ESLint | tests');
  QUnit.test('integration/components/plusminus-component-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/plusminus-component-test.js should pass ESLint\n\n');
  });
  QUnit.test('test-helper.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'test-helper.js should pass ESLint\n\n');
  });
  QUnit.test('unit/controllers/tasks-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/tasks-test.js should pass ESLint\n\n');
  });
  QUnit.test('unit/routes/tasks-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/tasks-test.js should pass ESLint\n\n');
  });
});
define("mathe2/tests/test-helper", ["mathe2/app", "mathe2/config/environment", "@ember/test-helpers", "ember-qunit"], function (_app, _environment, _testHelpers, _emberQunit) {
  "use strict";

  (0, _testHelpers.setApplication)(_app.default.create(_environment.default.APP));
  (0, _emberQunit.start)();
});
define("mathe2/tests/unit/controllers/tasks-test", ["qunit", "ember-qunit"], function (_qunit, _emberQunit) {
  "use strict";

  (0, _qunit.module)('Unit | Controller | tasks', function (hooks) {
    (0, _emberQunit.setupTest)(hooks);
    (0, _qunit.test)('it exists', function (assert) {
      let controller = this.owner.lookup('controller:tasks');
      assert.ok(controller);
    });
    (0, _qunit.test)('berechnet sets state', function (assert) {
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
    (0, _qunit.test)('korrigiert sets state and correct flag', function (assert) {
      let controller = this.owner.lookup('controller:tasks');
      let route = this.owner.lookup('route:tasks');
      let model = route.model();
      controller.set('model', model);

      for (let i = 0; i < model.results.length; i++) {
        assert.equal(model.counter, i); // First half of results is wrong, last half set to correct values.

        model.results[i].result = i < model.results.length / 2 ? model.results[i].third - 1 : model.results[i].third;
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
});
define("mathe2/tests/unit/routes/tasks-test", ["qunit", "ember-qunit"], function (_qunit, _emberQunit) {
  "use strict";

  (0, _qunit.module)('Unit | Route | tasks', function (hooks) {
    (0, _emberQunit.setupTest)(hooks);
    (0, _qunit.test)('it exists', function (assert) {
      let route = this.owner.lookup('route:tasks');
      assert.ok(route);
    });
    (0, _qunit.test)('it contains 10 tasks', function (assert) {
      let route = this.owner.lookup('route:tasks');
      let model = route.model();
      assert.ok(model.results.length == 10);
    });
    (0, _qunit.test)('correct flag is null', function (assert) {
      let route = this.owner.lookup('route:tasks');
      let model = route.model();

      for (let i = 0; i < model.results.length; i++) {
        assert.ok(model.results[i].correct == null);
      }
    });
    (0, _qunit.test)('numbers are correct', function (assert) {
      let route = this.owner.lookup('route:tasks');
      let model = route.model();

      for (let i = 0; i < model.results.length; i++) {
        let result_i = model.results[i];

        switch (result_i.plusminus) {
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
});
define('mathe2/config/environment', [], function() {
  var prefix = 'mathe2';
try {
  var metaName = prefix + '/config/environment';
  var rawConfig = document.querySelector('meta[name="' + metaName + '"]').getAttribute('content');
  var config = JSON.parse(decodeURIComponent(rawConfig));

  var exports = { 'default': config };

  Object.defineProperty(exports, '__esModule', { value: true });

  return exports;
}
catch(err) {
  throw new Error('Could not read config from meta tag with name "' + metaName + '".');
}

});

require('mathe2/tests/test-helper');
EmberENV.TESTS_FILE_LOADED = true;
//# sourceMappingURL=tests.map
