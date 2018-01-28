'use strict';

define('mathe/tests/app.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | app.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'app.js should pass jshint.');
  });
});
define('mathe/tests/components/plusminus-component.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | components/plusminus-component.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(false, 'components/plusminus-component.js should pass jshint.\ncomponents/plusminus-component.js: line 36, col 108, Missing semicolon.\ncomponents/plusminus-component.js: line 40, col 13, \'thirdString\' is defined but never used.\n\n2 errors');
  });
});
define('mathe/tests/components/singlenumber-input.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | components/singlenumber-input.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(false, 'components/singlenumber-input.js should pass jshint.\ncomponents/singlenumber-input.js: line 7, col 43, Expected \'!==\' and instead saw \'!=\'.\ncomponents/singlenumber-input.js: line 13, col 80, Expected \'!==\' and instead saw \'!=\'.\n\n2 errors');
  });
});
define('mathe/tests/controllers/tasks.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | controllers/tasks.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(false, 'controllers/tasks.js should pass jshint.\ncontrollers/tasks.js: line 12, col 78, Missing semicolon.\ncontrollers/tasks.js: line 13, col 43, Expected \'===\' and instead saw \'==\'.\ncontrollers/tasks.js: line 24, col 25, Expected \'===\' and instead saw \'==\'.\ncontrollers/tasks.js: line 51, col 47, Expected \'===\' and instead saw \'==\'.\n\n4 errors');
  });
});
define('mathe/tests/helpers/destroy-app', ['exports', 'ember'], function (exports, _ember) {
  exports['default'] = destroyApp;

  function destroyApp(application) {
    _ember['default'].run(application, 'destroy');
  }
});
define('mathe/tests/helpers/destroy-app.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | helpers/destroy-app.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/destroy-app.js should pass jshint.');
  });
});
define('mathe/tests/helpers/module-for-acceptance', ['exports', 'qunit', 'ember', 'mathe/tests/helpers/start-app', 'mathe/tests/helpers/destroy-app'], function (exports, _qunit, _ember, _matheTestsHelpersStartApp, _matheTestsHelpersDestroyApp) {
  var Promise = _ember['default'].RSVP.Promise;

  exports['default'] = function (name) {
    var options = arguments.length <= 1 || arguments[1] === undefined ? {} : arguments[1];

    (0, _qunit.module)(name, {
      beforeEach: function beforeEach() {
        this.application = (0, _matheTestsHelpersStartApp['default'])();

        if (options.beforeEach) {
          return options.beforeEach.apply(this, arguments);
        }
      },

      afterEach: function afterEach() {
        var _this = this;

        var afterEach = options.afterEach && options.afterEach.apply(this, arguments);
        return Promise.resolve(afterEach).then(function () {
          return (0, _matheTestsHelpersDestroyApp['default'])(_this.application);
        });
      }
    });
  };
});
define('mathe/tests/helpers/module-for-acceptance.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | helpers/module-for-acceptance.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/module-for-acceptance.js should pass jshint.');
  });
});
define('mathe/tests/helpers/resolver', ['exports', 'mathe/resolver', 'mathe/config/environment'], function (exports, _matheResolver, _matheConfigEnvironment) {

  var resolver = _matheResolver['default'].create();

  resolver.namespace = {
    modulePrefix: _matheConfigEnvironment['default'].modulePrefix,
    podModulePrefix: _matheConfigEnvironment['default'].podModulePrefix
  };

  exports['default'] = resolver;
});
define('mathe/tests/helpers/resolver.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | helpers/resolver.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/resolver.js should pass jshint.');
  });
});
define('mathe/tests/helpers/start-app', ['exports', 'ember', 'mathe/app', 'mathe/config/environment'], function (exports, _ember, _matheApp, _matheConfigEnvironment) {
  exports['default'] = startApp;

  function startApp(attrs) {
    var application = undefined;

    var attributes = _ember['default'].merge({}, _matheConfigEnvironment['default'].APP);
    attributes = _ember['default'].merge(attributes, attrs); // use defaults, but you can override;

    _ember['default'].run(function () {
      application = _matheApp['default'].create(attributes);
      application.setupForTesting();
      application.injectTestHelpers();
    });

    return application;
  }
});
define('mathe/tests/helpers/start-app.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | helpers/start-app.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/start-app.js should pass jshint.');
  });
});
define('mathe/tests/integration/components/plusminus-component-test', ['exports', 'ember-qunit'], function (exports, _emberQunit) {

  (0, _emberQunit.moduleForComponent)('plusminus-component', 'Integration | Component | plusminus component', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {

    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      'id': '5hgsUsdZ',
      'block': '{"statements":[["append",["unknown",["plusminus-component"]],false]],"locals":[],"named":[],"yields":[],"blocks":[],"hasPartials":false}',
      'meta': {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      'id': 'bnl/tjmY',
      'block': '{"statements":[["text","\\n"],["block",["plusminus-component"],null,null,0],["text","  "]],"locals":[],"named":[],"yields":[],"blocks":[{"statements":[["text","      template block text\\n"]],"locals":[]}],"hasPartials":false}',
      'meta': {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('mathe/tests/integration/components/plusminus-component-test.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | integration/components/plusminus-component-test.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/plusminus-component-test.js should pass jshint.');
  });
});
define('mathe/tests/integration/components/singlenumber-input-test', ['exports', 'ember-qunit'], function (exports, _emberQunit) {

  (0, _emberQunit.moduleForComponent)('singlenumber-input', 'Integration | Component | singlenumber input', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {

    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      'id': 'fv2Cca2/',
      'block': '{"statements":[["append",["unknown",["singlenumber-input"]],false]],"locals":[],"named":[],"yields":[],"blocks":[],"hasPartials":false}',
      'meta': {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      'id': 'xWOQaOMM',
      'block': '{"statements":[["text","\\n"],["block",["singlenumber-input"],null,null,0],["text","  "]],"locals":[],"named":[],"yields":[],"blocks":[{"statements":[["text","      template block text\\n"]],"locals":[]}],"hasPartials":false}',
      'meta': {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('mathe/tests/integration/components/singlenumber-input-test.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | integration/components/singlenumber-input-test.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/singlenumber-input-test.js should pass jshint.');
  });
});
define('mathe/tests/models/Task.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | models/Task.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(false, 'models/Task.js should pass jshint.\nmodels/Task.js: line 3, col 7, \'Task\' is defined but never used.\n\n1 error');
  });
});
define('mathe/tests/resolver.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | resolver.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'resolver.js should pass jshint.');
  });
});
define('mathe/tests/router.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | router.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'router.js should pass jshint.');
  });
});
define('mathe/tests/routes/tasks.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | routes/tasks.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/tasks.js should pass jshint.\nroutes/tasks.js: line 2, col 37, Missing semicolon.\n\n1 error');
  });
});
define('mathe/tests/test-helper', ['exports', 'mathe/tests/helpers/resolver', 'ember-qunit'], function (exports, _matheTestsHelpersResolver, _emberQunit) {

  (0, _emberQunit.setResolver)(_matheTestsHelpersResolver['default']);
});
define('mathe/tests/test-helper.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | test-helper.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'test-helper.js should pass jshint.');
  });
});
define('mathe/tests/unit/controllers/tasks-test', ['exports', 'ember-qunit'], function (exports, _emberQunit) {

  (0, _emberQunit.moduleFor)('controller:tasks', 'Unit | Controller | tasks', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('mathe/tests/unit/controllers/tasks-test.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | unit/controllers/tasks-test.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/tasks-test.js should pass jshint.');
  });
});
define('mathe/tests/unit/routes/tasks-test', ['exports', 'ember-qunit'], function (exports, _emberQunit) {

  (0, _emberQunit.moduleFor)('route:tasks', 'Unit | Route | tasks', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('mathe/tests/unit/routes/tasks-test.jshint.lint-test', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | unit/routes/tasks-test.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/tasks-test.js should pass jshint.');
  });
});
/* jshint ignore:start */

require('mathe/tests/test-helper');
EmberENV.TESTS_FILE_LOADED = true;

/* jshint ignore:end */
//# sourceMappingURL=tests.map
