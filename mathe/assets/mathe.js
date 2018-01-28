"use strict";

/* jshint ignore:start */



/* jshint ignore:end */

define('mathe/app', ['exports', 'ember', 'mathe/resolver', 'ember-load-initializers', 'mathe/config/environment'], function (exports, _ember, _matheResolver, _emberLoadInitializers, _matheConfigEnvironment) {

  var App = undefined;

  _ember['default'].MODEL_FACTORY_INJECTIONS = true;

  App = _ember['default'].Application.extend({
    modulePrefix: _matheConfigEnvironment['default'].modulePrefix,
    podModulePrefix: _matheConfigEnvironment['default'].podModulePrefix,
    Resolver: _matheResolver['default']
  });

  (0, _emberLoadInitializers['default'])(App, _matheConfigEnvironment['default'].modulePrefix);

  exports['default'] = App;
});
define('mathe/components/plusminus-component', ['exports', 'ember'], function (exports, _ember) {
    exports['default'] = _ember['default'].Component.extend({
        actions: {
            berechnet: function berechnet() {
                this.sendAction('berechnet');
            },
            korrigiert: function korrigiert() {
                this.get('model').get('results')[this.get('model').get('counter')].result = parseInt(this.get('value31') + '' + this.get('value32') + '' + this.get('value33'));
                this.sendAction('korrigiert');
                this.set('clearon', this.get('clearon') + 1);
            },
            numberEntered: function numberEntered(name, value) {
                this.set(name, value);
            }
        },
        init: function init() {
            this._super.apply(this, arguments);
            this.set('clearon', 0);
        },
        didUpdateAttrs: function didUpdateAttrs() {
            if (arguments[0].newAttrs['startState'].value) {
                this.update();
            }
        },
        didReceiveAttrs: function didReceiveAttrs() {
            if (arguments[0].newAttrs['startState'].value) {
                this.update();
            }
        },
        update: function update() {
            if (this.get('model').get('done')) {
                return;
            }
            this.set('plusminus', this.get('model').get('results')[this.get('model').get('counter')].plusminus);

            var firstString = "" + this.get('model').get('results')[this.get('model').get('counter')].first;
            var secondString = "" + this.get('model').get('results')[this.get('model').get('counter')].second;
            var thirdString = "" + this.get('model').get('results')[this.get('model').get('counter')].third;

            for (var i = 1; i <= 3; i++) {
                for (var j = 1; j <= 3; j++) {
                    this.set('value' + i + j, '');
                }
            }
            for (var i = 1; i < Math.min(4, firstString.length + 1); i++) {
                this.set('value1' + (i + 3 - firstString.length), firstString.substr(i - 1, 1));
            }
            for (var i = 1; i < Math.min(4, secondString.length + 1); i++) {
                this.set('value2' + (i + 3 - secondString.length), secondString.substr(i - 1, 1));
            }
        }
    });
});
define('mathe/components/singlenumber-input', ['exports', 'ember'], function (exports, _ember) {
    exports['default'] = _ember['default'].Component.extend({
        actions: {
            eingabe: function eingabe(evt) {
                if (isNaN(parseInt(evt.originalEvent.key))) {
                    if (evt.originalEvent.key != 'Backspace') {
                        evt.originalEvent.preventDefault();
                        return false;
                    }
                } else {
                    if (!isNaN(parseInt(this.get('val'))) && evt.originalEvent.key != 'Backspace') {
                        evt.originalEvent.preventDefault();
                        return false;
                    } else {
                        this.sendAction('numberEntered', this.get('name'), parseInt(evt.originalEvent.key));
                    }
                }
            }
        },
        didUpdateAttrs: function didUpdateAttrs() {
            this.set('val', '');
        }
    });
});
define('mathe/components/welcome-page', ['exports', 'ember-welcome-page/components/welcome-page'], function (exports, _emberWelcomePageComponentsWelcomePage) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberWelcomePageComponentsWelcomePage['default'];
    }
  });
});
define('mathe/controllers/tasks', ['exports', 'ember'], function (exports, _ember) {
    exports['default'] = _ember['default'].Controller.extend({
        actions: {
            berechnet: function berechnet() {
                this.get('model').set('startState', false);
                this.get('model').set('berechnetState', true);
            },
            korrigiert: function korrigiert() {

                var results = this.get('model').get('results').map(function (e) {
                    return e;
                });
                var counter = results.reduce(function (p, c) {
                    return p + (c.result ? 1 : 0);
                }, 0);
                if (results[counter - 1].result == results[counter - 1].third) {
                    results[counter - 1].correct = true;
                } else {
                    results[counter - 1].correct = false;
                }

                var modelresults = this.get('model').get('results');
                modelresults.clear();
                results.forEach(function (e) {
                    modelresults.pushObject(_ember['default'].copy(e));
                });
                this.get('model').set('counter', counter);
                if (counter == this.get('model').get('results').length) {
                    this.get('model').set('done', true);
                }

                this.get('model').set('startState', true);
                this.get('model').set('berechnetState', false);
            },
            lernen: function lernen() {
                window.location.replace('https://klexikon.zum.de/wiki/Spezial:Zuf%C3%A4llige_Seite');
            }
        },
        initialise: function initialise(model) {
            function getRandomInt(min, max) {
                min = Math.ceil(min);
                max = Math.floor(max);
                return Math.floor(Math.random() * (max - min)) + min;
            }

            model.set('counter', 0);
            for (var i = 0; i < 10; i++) {
                var first = 0;
                var second = 0;
                var third = 0;
                var plusminus = '+';
                while (true) {
                    first = getRandomInt(0, 1000);
                    second = getRandomInt(0, 1000);
                    plusminus = getRandomInt(0, 2) == 0 ? '-' : '+';
                    if (plusminus === '+' && first + second <= 1000) {
                        third = first + second;
                        break;
                    }
                    if (plusminus === '-' && first - second >= 0) {
                        third = first - second;
                        break;
                    }
                }
                model.get('results').pushObject({
                    first: first,
                    second: second,
                    third: third,
                    result: 0,
                    plusminus: plusminus
                });
            }
        }
    });
});
define('mathe/helpers/and', ['exports', 'ember-truth-helpers/helpers/and'], function (exports, _emberTruthHelpersHelpersAnd) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersAnd['default'];
    }
  });
  Object.defineProperty(exports, 'and', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersAnd.and;
    }
  });
});
define('mathe/helpers/app-version', ['exports', 'ember', 'mathe/config/environment', 'ember-cli-app-version/utils/regexp'], function (exports, _ember, _matheConfigEnvironment, _emberCliAppVersionUtilsRegexp) {
  exports.appVersion = appVersion;
  var version = _matheConfigEnvironment['default'].APP.version;

  function appVersion(_) {
    var hash = arguments.length <= 1 || arguments[1] === undefined ? {} : arguments[1];

    if (hash.hideSha) {
      return version.match(_emberCliAppVersionUtilsRegexp.versionRegExp)[0];
    }

    if (hash.hideVersion) {
      return version.match(_emberCliAppVersionUtilsRegexp.shaRegExp)[0];
    }

    return version;
  }

  exports['default'] = _ember['default'].Helper.helper(appVersion);
});
define('mathe/helpers/eq', ['exports', 'ember-truth-helpers/helpers/equal'], function (exports, _emberTruthHelpersHelpersEqual) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersEqual['default'];
    }
  });
  Object.defineProperty(exports, 'equal', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersEqual.equal;
    }
  });
});
define('mathe/helpers/gt', ['exports', 'ember-truth-helpers/helpers/gt'], function (exports, _emberTruthHelpersHelpersGt) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersGt['default'];
    }
  });
  Object.defineProperty(exports, 'gt', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersGt.gt;
    }
  });
});
define('mathe/helpers/gte', ['exports', 'ember-truth-helpers/helpers/gte'], function (exports, _emberTruthHelpersHelpersGte) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersGte['default'];
    }
  });
  Object.defineProperty(exports, 'gte', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersGte.gte;
    }
  });
});
define('mathe/helpers/is-array', ['exports', 'ember-truth-helpers/helpers/is-array'], function (exports, _emberTruthHelpersHelpersIsArray) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersIsArray['default'];
    }
  });
  Object.defineProperty(exports, 'isArray', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersIsArray.isArray;
    }
  });
});
define('mathe/helpers/is-equal', ['exports', 'ember-truth-helpers/helpers/is-equal'], function (exports, _emberTruthHelpersHelpersIsEqual) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersIsEqual['default'];
    }
  });
  Object.defineProperty(exports, 'isEqual', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersIsEqual.isEqual;
    }
  });
});
define('mathe/helpers/lt', ['exports', 'ember-truth-helpers/helpers/lt'], function (exports, _emberTruthHelpersHelpersLt) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersLt['default'];
    }
  });
  Object.defineProperty(exports, 'lt', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersLt.lt;
    }
  });
});
define('mathe/helpers/lte', ['exports', 'ember-truth-helpers/helpers/lte'], function (exports, _emberTruthHelpersHelpersLte) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersLte['default'];
    }
  });
  Object.defineProperty(exports, 'lte', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersLte.lte;
    }
  });
});
define('mathe/helpers/not-eq', ['exports', 'ember-truth-helpers/helpers/not-equal'], function (exports, _emberTruthHelpersHelpersNotEqual) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersNotEqual['default'];
    }
  });
  Object.defineProperty(exports, 'notEq', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersNotEqual.notEq;
    }
  });
});
define('mathe/helpers/not', ['exports', 'ember-truth-helpers/helpers/not'], function (exports, _emberTruthHelpersHelpersNot) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersNot['default'];
    }
  });
  Object.defineProperty(exports, 'not', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersNot.not;
    }
  });
});
define('mathe/helpers/or', ['exports', 'ember-truth-helpers/helpers/or'], function (exports, _emberTruthHelpersHelpersOr) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersOr['default'];
    }
  });
  Object.defineProperty(exports, 'or', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersOr.or;
    }
  });
});
define('mathe/helpers/pluralize', ['exports', 'ember-inflector/lib/helpers/pluralize'], function (exports, _emberInflectorLibHelpersPluralize) {
  exports['default'] = _emberInflectorLibHelpersPluralize['default'];
});
define('mathe/helpers/singularize', ['exports', 'ember-inflector/lib/helpers/singularize'], function (exports, _emberInflectorLibHelpersSingularize) {
  exports['default'] = _emberInflectorLibHelpersSingularize['default'];
});
define('mathe/helpers/xor', ['exports', 'ember-truth-helpers/helpers/xor'], function (exports, _emberTruthHelpersHelpersXor) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersXor['default'];
    }
  });
  Object.defineProperty(exports, 'xor', {
    enumerable: true,
    get: function get() {
      return _emberTruthHelpersHelpersXor.xor;
    }
  });
});
define('mathe/initializers/app-version', ['exports', 'ember-cli-app-version/initializer-factory', 'mathe/config/environment'], function (exports, _emberCliAppVersionInitializerFactory, _matheConfigEnvironment) {
  var _config$APP = _matheConfigEnvironment['default'].APP;
  var name = _config$APP.name;
  var version = _config$APP.version;
  exports['default'] = {
    name: 'App Version',
    initialize: (0, _emberCliAppVersionInitializerFactory['default'])(name, version)
  };
});
define('mathe/initializers/container-debug-adapter', ['exports', 'ember-resolver/container-debug-adapter'], function (exports, _emberResolverContainerDebugAdapter) {
  exports['default'] = {
    name: 'container-debug-adapter',

    initialize: function initialize() {
      var app = arguments[1] || arguments[0];

      app.register('container-debug-adapter:main', _emberResolverContainerDebugAdapter['default']);
      app.inject('container-debug-adapter:main', 'namespace', 'application:main');
    }
  };
});
define('mathe/initializers/data-adapter', ['exports'], function (exports) {
  /*
    This initializer is here to keep backwards compatibility with code depending
    on the `data-adapter` initializer (before Ember Data was an addon).
  
    Should be removed for Ember Data 3.x
  */

  exports['default'] = {
    name: 'data-adapter',
    before: 'store',
    initialize: function initialize() {}
  };
});
define('mathe/initializers/ember-data', ['exports', 'ember-data/setup-container', 'ember-data'], function (exports, _emberDataSetupContainer, _emberData) {

  /*
  
    This code initializes Ember-Data onto an Ember application.
  
    If an Ember.js developer defines a subclass of DS.Store on their application,
    as `App.StoreService` (or via a module system that resolves to `service:store`)
    this code will automatically instantiate it and make it available on the
    router.
  
    Additionally, after an application's controllers have been injected, they will
    each have the store made available to them.
  
    For example, imagine an Ember.js application with the following classes:
  
    ```app/services/store.js
    import DS from 'ember-data';
  
    export default DS.Store.extend({
      adapter: 'custom'
    });
    ```
  
    ```app/controllers/posts.js
    import { Controller } from '@ember/controller';
  
    export default Controller.extend({
      // ...
    });
  
    When the application is initialized, `ApplicationStore` will automatically be
    instantiated, and the instance of `PostsController` will have its `store`
    property set to that instance.
  
    Note that this code will only be run if the `ember-application` package is
    loaded. If Ember Data is being used in an environment other than a
    typical application (e.g., node.js where only `ember-runtime` is available),
    this code will be ignored.
  */

  exports['default'] = {
    name: 'ember-data',
    initialize: _emberDataSetupContainer['default']
  };
});
define('mathe/initializers/export-application-global', ['exports', 'ember', 'mathe/config/environment'], function (exports, _ember, _matheConfigEnvironment) {
  exports.initialize = initialize;

  function initialize() {
    var application = arguments[1] || arguments[0];
    if (_matheConfigEnvironment['default'].exportApplicationGlobal !== false) {
      var theGlobal;
      if (typeof window !== 'undefined') {
        theGlobal = window;
      } else if (typeof global !== 'undefined') {
        theGlobal = global;
      } else if (typeof self !== 'undefined') {
        theGlobal = self;
      } else {
        // no reasonable global, just bail
        return;
      }

      var value = _matheConfigEnvironment['default'].exportApplicationGlobal;
      var globalName;

      if (typeof value === 'string') {
        globalName = value;
      } else {
        globalName = _ember['default'].String.classify(_matheConfigEnvironment['default'].modulePrefix);
      }

      if (!theGlobal[globalName]) {
        theGlobal[globalName] = application;

        application.reopen({
          willDestroy: function willDestroy() {
            this._super.apply(this, arguments);
            delete theGlobal[globalName];
          }
        });
      }
    }
  }

  exports['default'] = {
    name: 'export-application-global',

    initialize: initialize
  };
});
define('mathe/initializers/injectStore', ['exports'], function (exports) {
  /*
    This initializer is here to keep backwards compatibility with code depending
    on the `injectStore` initializer (before Ember Data was an addon).
  
    Should be removed for Ember Data 3.x
  */

  exports['default'] = {
    name: 'injectStore',
    before: 'store',
    initialize: function initialize() {}
  };
});
define('mathe/initializers/store', ['exports'], function (exports) {
  /*
    This initializer is here to keep backwards compatibility with code depending
    on the `store` initializer (before Ember Data was an addon).
  
    Should be removed for Ember Data 3.x
  */

  exports['default'] = {
    name: 'store',
    after: 'ember-data',
    initialize: function initialize() {}
  };
});
define('mathe/initializers/transforms', ['exports'], function (exports) {
  /*
    This initializer is here to keep backwards compatibility with code depending
    on the `transforms` initializer (before Ember Data was an addon).
  
    Should be removed for Ember Data 3.x
  */

  exports['default'] = {
    name: 'transforms',
    before: 'store',
    initialize: function initialize() {}
  };
});
define("mathe/instance-initializers/ember-data", ["exports", "ember-data/initialize-store-service"], function (exports, _emberDataInitializeStoreService) {
  exports["default"] = {
    name: "ember-data",
    initialize: _emberDataInitializeStoreService["default"]
  };
});
define('mathe/models/Task', ['exports', 'ember-data'], function (exports, _emberData) {

    var Task = _emberData['default'].Model.extend({
        value11: _emberData['default'].attr(),
        value12: _emberData['default'].attr(),
        value13: _emberData['default'].attr(),
        value21: _emberData['default'].attr(),
        value22: _emberData['default'].attr(),
        value23: _emberData['default'].attr(),
        plusminus: _emberData['default'].attr(),
        result: _emberData['default'].attr(),
        startState: _emberData['default'].attr(),
        berechnetState: _emberData['default'].attr()
    });
});
define('mathe/resolver', ['exports', 'ember-resolver'], function (exports, _emberResolver) {
  exports['default'] = _emberResolver['default'];
});
define('mathe/router', ['exports', 'ember', 'mathe/config/environment'], function (exports, _ember, _matheConfigEnvironment) {

  var Router = _ember['default'].Router.extend({
    location: _matheConfigEnvironment['default'].locationType,
    rootURL: _matheConfigEnvironment['default'].rootURL
  });

  Router.map(function () {
    this.route('tasks');
  });

  exports['default'] = Router;
});
define('mathe/routes/tasks', ['exports', 'ember'], function (exports, _ember) {
    var Task = _ember['default'].Object.extend({});

    exports['default'] = _ember['default'].Route.extend({
        model: function model() {
            return Task.create({
                results: [],
                startState: true,
                berechnetState: false
            });
        },
        setupController: function setupController(controller, model) {
            controller.set('model', model);
            controller.initialise(model);
        }
    });
});
define('mathe/services/ajax', ['exports', 'ember-ajax/services/ajax'], function (exports, _emberAjaxServicesAjax) {
  Object.defineProperty(exports, 'default', {
    enumerable: true,
    get: function get() {
      return _emberAjaxServicesAjax['default'];
    }
  });
});
define("mathe/templates/application", ["exports"], function (exports) {
  exports["default"] = Ember.HTMLBars.template({ "id": "wyKMpNZD", "block": "{\"statements\":[[\"append\",[\"unknown\",[\"outlet\"]],false],[\"text\",\"\\n\"]],\"locals\":[],\"named\":[],\"yields\":[],\"blocks\":[],\"hasPartials\":false}", "meta": { "moduleName": "mathe/templates/application.hbs" } });
});
define("mathe/templates/components/plusminus-component", ["exports"], function (exports) {
  exports["default"] = Ember.HTMLBars.template({ "id": "BQ9HV2Dq", "block": "{\"statements\":[[\"open-element\",\"div\",[]],[\"static-attr\",\"style\",\"display: flex\"],[\"flush-element\"],[\"text\",\"\\n\"],[\"block\",[\"each\"],[[\"get\",[\"results\"]]],null,11],[\"close-element\"],[\"text\",\"\\n\"],[\"block\",[\"unless\"],[[\"get\",[\"model\",\"done\"]]],null,6],[\"block\",[\"if\"],[[\"get\",[\"model\",\"done\"]]],null,0]],\"locals\":[],\"named\":[],\"yields\":[],\"blocks\":[{\"statements\":[[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"container-fluid\"],[\"flush-element\"],[\"text\",\"\\n    \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"row justify-content-md-center\"],[\"flush-element\"],[\"text\",\"\\n        \"],[\"open-element\",\"p\",[]],[\"static-attr\",\"class\",\"col-md-4\"],[\"flush-element\"],[\"text\",\"Super. Du has 10 Aufgaben gerechnet!\"],[\"close-element\"],[\"text\",\"\\n    \"],[\"close-element\"],[\"text\",\"\\n\"],[\"close-element\"],[\"text\",\"\\n\"]],\"locals\":[]},{\"statements\":[[\"text\",\"        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"row justify-content-md-center\"],[\"flush-element\"],[\"text\",\"\\n            \"],[\"open-element\",\"button\",[]],[\"static-attr\",\"type\",\"button\"],[\"static-attr\",\"class\",\"btn btn-success col-md-4\"],[\"modifier\",[\"action\"],[[\"get\",[null]],\"korrigiert\"]],[\"flush-element\"],[\"text\",\"Ich habe es fertig überprüft\"],[\"close-element\"],[\"text\",\"\\n        \"],[\"close-element\"],[\"text\",\"\\n\"]],\"locals\":[]},{\"statements\":[[\"text\",\"        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"row justify-content-md-center\"],[\"flush-element\"],[\"text\",\"\\n            \"],[\"open-element\",\"button\",[]],[\"static-attr\",\"type\",\"button\"],[\"static-attr\",\"class\",\"btn btn-success col-md-4\"],[\"modifier\",[\"action\"],[[\"get\",[null]],\"berechnet\"]],[\"flush-element\"],[\"text\",\"Ich habe es fertig gerechnet\"],[\"close-element\"],[\"text\",\"\\n        \"],[\"close-element\"],[\"text\",\"\\n\"]],\"locals\":[]},{\"statements\":[],\"locals\":[]},{\"statements\":[],\"locals\":[]},{\"statements\":[],\"locals\":[]},{\"statements\":[[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"container-fluid\"],[\"flush-element\"],[\"text\",\"\\n    \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"row justify-content-md-center\"],[\"flush-element\"],[\"text\",\"\\n        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"type\",\"text\"],[\"static-attr\",\"class\",\"col-md-1 offset-md-1\"],[\"static-attr\",\"disabled\",\"\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"value11\"]],false],[\"close-element\"],[\"text\",\"\\n        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"type\",\"text\"],[\"static-attr\",\"class\",\"col-md-1\"],[\"static-attr\",\"disabled\",\"\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"value12\"]],false],[\"close-element\"],[\"text\",\"\\n        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"type\",\"text\"],[\"static-attr\",\"class\",\"col-md-1\"],[\"static-attr\",\"disabled\",\"\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"value13\"]],false],[\"close-element\"],[\"text\",\"\\n    \"],[\"close-element\"],[\"text\",\"\\n    \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"row justify-content-md-center\"],[\"flush-element\"],[\"text\",\"\\n        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"col-md-1\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"plusminus\"]],false],[\"close-element\"],[\"text\",\"\\n        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"type\",\"text\"],[\"static-attr\",\"class\",\"col-md-1\"],[\"static-attr\",\"disabled\",\"\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"value21\"]],false],[\"close-element\"],[\"text\",\"\\n        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"type\",\"text\"],[\"static-attr\",\"class\",\"col-md-1\"],[\"static-attr\",\"disabled\",\"\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"value22\"]],false],[\"close-element\"],[\"text\",\"\\n        \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"type\",\"text\"],[\"static-attr\",\"class\",\"col-md-1\"],[\"static-attr\",\"disabled\",\"\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"value23\"]],false],[\"close-element\"],[\"text\",\"\\n    \"],[\"close-element\"],[\"text\",\"\\n    \"],[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"row justify-content-md-center\"],[\"flush-element\"],[\"text\",\"\\n        \"],[\"block\",[\"singlenumber-input\"],null,[[\"name\",\"numberEntered\",\"clearon\",\"class\"],[\"value31\",\"numberEntered\",[\"get\",[\"clearon\"]],\"col-md-1 offset-md-1\"]],5],[\"text\",\"\\n        \"],[\"block\",[\"singlenumber-input\"],null,[[\"name\",\"numberEntered\",\"clearon\",\"class\"],[\"value32\",\"numberEntered\",[\"get\",[\"clearon\"]],\"col-md-1\"]],4],[\"text\",\"\\n        \"],[\"block\",[\"singlenumber-input\"],null,[[\"name\",\"numberEntered\",\"clearon\",\"class\"],[\"value33\",\"numberEntered\",[\"get\",[\"clearon\"]],\"col-md-1\"]],3],[\"text\",\"\\n    \"],[\"close-element\"],[\"text\",\"\\n\"],[\"block\",[\"if\"],[[\"get\",[\"startState\"]]],null,2],[\"block\",[\"if\"],[[\"get\",[\"berechnetState\"]]],null,1],[\"close-element\"],[\"text\",\"\\n\"]],\"locals\":[]},{\"statements\":[[\"text\",\"            \"],[\"open-element\",\"button\",[]],[\"static-attr\",\"type\",\"button\"],[\"static-attr\",\"style\",\"flex-grow: 1\"],[\"static-attr\",\"class\",\"btn btn-primary\"],[\"flush-element\"],[\"append\",[\"get\",[\"index\"]],false],[\"close-element\"],[\"text\",\"\\n        \"]],\"locals\":[]},{\"statements\":[[\"text\",\"            \"],[\"open-element\",\"button\",[]],[\"static-attr\",\"type\",\"button\"],[\"static-attr\",\"style\",\"flex-grow: 1\"],[\"static-attr\",\"class\",\"btn btn-danger\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"result\",\"first\"]],false],[\"open-element\",\"br\",[]],[\"flush-element\"],[\"close-element\"],[\"append\",[\"unknown\",[\"result\",\"plusminus\"]],false],[\"open-element\",\"br\",[]],[\"flush-element\"],[\"close-element\"],[\"append\",[\"unknown\",[\"result\",\"second\"]],false],[\"close-element\"],[\"text\",\"\\n\"]],\"locals\":[]},{\"statements\":[[\"block\",[\"if\"],[[\"helper\",[\"eq\"],[[\"get\",[\"result\",\"correct\"]],false],null]],null,8,7]],\"locals\":[]},{\"statements\":[[\"text\",\"            \"],[\"open-element\",\"button\",[]],[\"static-attr\",\"type\",\"button\"],[\"static-attr\",\"style\",\"flex-grow: 1\"],[\"static-attr\",\"class\",\"btn btn-success\"],[\"flush-element\"],[\"append\",[\"unknown\",[\"result\",\"first\"]],false],[\"open-element\",\"br\",[]],[\"flush-element\"],[\"close-element\"],[\"append\",[\"unknown\",[\"result\",\"plusminus\"]],false],[\"open-element\",\"br\",[]],[\"flush-element\"],[\"close-element\"],[\"append\",[\"unknown\",[\"result\",\"second\"]],false],[\"close-element\"],[\"text\",\"\\n\"]],\"locals\":[]},{\"statements\":[[\"block\",[\"if\"],[[\"helper\",[\"eq\"],[[\"get\",[\"result\",\"correct\"]],true],null]],null,10,9]],\"locals\":[\"result\",\"index\"]}],\"hasPartials\":false}", "meta": { "moduleName": "mathe/templates/components/plusminus-component.hbs" } });
});
define("mathe/templates/components/singlenumber-input", ["exports"], function (exports) {
  exports["default"] = Ember.HTMLBars.template({ "id": "tYP9LqrM", "block": "{\"statements\":[[\"open-element\",\"div\",[]],[\"static-attr\",\"class\",\"row\"],[\"flush-element\"],[\"text\",\"\\n\"],[\"append\",[\"helper\",[\"input\"],null,[[\"value\",\"type\",\"keyPress\",\"class\",\"max\"],[[\"get\",[\"val\"]],\"number\",[\"helper\",[\"action\"],[[\"get\",[null]],\"eingabe\"],null],\"col-md-12 no-spinners\",\"9\"]]],false],[\"text\",\"\\n\"],[\"close-element\"],[\"text\",\"\\n\"]],\"locals\":[],\"named\":[],\"yields\":[],\"blocks\":[],\"hasPartials\":false}", "meta": { "moduleName": "mathe/templates/components/singlenumber-input.hbs" } });
});
define("mathe/templates/tasks", ["exports"], function (exports) {
  exports["default"] = Ember.HTMLBars.template({ "id": "yKXrIKCc", "block": "{\"statements\":[[\"append\",[\"helper\",[\"plusminus-component\"],null,[[\"model\",\"results\",\"startState\",\"berechnetState\",\"berechnet\",\"korrigiert\",\"counter\"],[[\"get\",[\"model\"]],[\"get\",[\"model\",\"results\"]],[\"get\",[\"model\",\"startState\"]],[\"get\",[\"model\",\"berechnetState\"]],\"berechnet\",\"korrigiert\",[\"get\",[\"model\",\"counter\"]]]]],false],[\"text\",\"\\n\"]],\"locals\":[],\"named\":[],\"yields\":[],\"blocks\":[],\"hasPartials\":false}", "meta": { "moduleName": "mathe/templates/tasks.hbs" } });
});
/* jshint ignore:start */



/* jshint ignore:end */

/* jshint ignore:start */

define('mathe/config/environment', ['ember'], function(Ember) {
  var prefix = 'mathe';
/* jshint ignore:start */

try {
  var metaName = prefix + '/config/environment';
  var rawConfig = document.querySelector('meta[name="' + metaName + '"]').getAttribute('content');
  var config = JSON.parse(unescape(rawConfig));

  var exports = { 'default': config };

  Object.defineProperty(exports, '__esModule', { value: true });

  return exports;
}
catch(err) {
  throw new Error('Could not read config from meta tag with name "' + metaName + '".');
}

/* jshint ignore:end */

});

/* jshint ignore:end */

/* jshint ignore:start */

if (!runningTests) {
  require("mathe/app")["default"].create({"name":"mathe","version":"0.0.0+886f100f"});
}

/* jshint ignore:end */
//# sourceMappingURL=mathe.map
