'use strict';



;define("mathe/adapters/-json-api", ["exports", "@ember-data/adapter/json-api"], function (_exports, _jsonApi) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _jsonApi.default;
    }
  });
});
;define("mathe/app", ["exports", "ember-resolver", "ember-load-initializers", "mathe/config/environment"], function (_exports, _emberResolver, _emberLoadInitializers, _environment) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;

  function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

  class App extends Ember.Application {
    constructor(...args) {
      super(...args);

      _defineProperty(this, "modulePrefix", _environment.default.modulePrefix);

      _defineProperty(this, "podModulePrefix", _environment.default.podModulePrefix);

      _defineProperty(this, "Resolver", _emberResolver.default);
    }

  }

  _exports.default = App;
  (0, _emberLoadInitializers.default)(App, _environment.default.modulePrefix);
});
;define("mathe/component-managers/glimmer", ["exports", "@glimmer/component/-private/ember-component-manager"], function (_exports, _emberComponentManager) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _emberComponentManager.default;
    }
  });
});
;define("mathe/components/plusminus-component", ["exports", "@glimmer/component"], function (_exports, _component) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;

  var _class, _descriptor, _descriptor2, _descriptor3, _descriptor4, _temp;

  function _initializerDefineProperty(target, property, descriptor, context) { if (!descriptor) return; Object.defineProperty(target, property, { enumerable: descriptor.enumerable, configurable: descriptor.configurable, writable: descriptor.writable, value: descriptor.initializer ? descriptor.initializer.call(context) : void 0 }); }

  function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

  function _applyDecoratedDescriptor(target, property, decorators, descriptor, context) { var desc = {}; Object.keys(descriptor).forEach(function (key) { desc[key] = descriptor[key]; }); desc.enumerable = !!desc.enumerable; desc.configurable = !!desc.configurable; if ('value' in desc || desc.initializer) { desc.writable = true; } desc = decorators.slice().reverse().reduce(function (desc, decorator) { return decorator(target, property, desc) || desc; }, desc); if (context && desc.initializer !== void 0) { desc.value = desc.initializer ? desc.initializer.call(context) : void 0; desc.initializer = undefined; } if (desc.initializer === void 0) { Object.defineProperty(target, property, desc); desc = null; } return desc; }

  function _initializerWarningHelper(descriptor, context) { throw new Error('Decorating class property failed. Please ensure that ' + 'proposal-class-properties is enabled and runs after the decorators transform.'); }

  const __COLOCATED_TEMPLATE__ = Ember.HTMLBars.template(
  /*
    <div style="display: flex">
      {{#each @model.results as |result index|}}
          {{#if (eq result.correct true)}}
              <button type="button" style="flex-grow: 1" class='success-marker btn btn-success'>{{result.first}}<br>{{result.plusminus}}<br>{{result.second}}</button>
          {{else if (eq result.correct false)}}
              <button type="button" style="flex-grow: 1" class='success-marker btn btn-danger'>{{result.first}}<br>{{result.plusminus}}<br>{{result.second}}</button>
          {{else}}
              <button type="button" style="flex-grow: 1" class='success-marker btn btn-primary'>{{index}}</button>
          {{/if}}
      {{/each}}
  </div>
  {{#unless @model.done}}
  <div class="container-fluid" {{did-update this.update @model.counter}}>
      <div class="row">
          <div type="text" class="col-3"></div>
          {{#each firstnumbers as |fns|}}
              <div type="text" class="first col-1 d-flex justify-content-center" disabled>{{fns}}</div>
          {{/each}}
      </div>
      <div class="row">
          <div class="col-2"></div>
          <div class="col-1">{{plusminus}}</div>
          {{#each secondnumbers as |sns|}}
              <div type="text" class="second col-1 d-flex justify-content-center" disabled>{{sns}}</div>
          {{/each}}
      </div>
      <div class="row">
          <div class="col-3"></div>
          {{#each this.thirdnumbers as |tns index|}}
            <input {{on "change" (fn this.numberEntered index )}} class="third col-1" type="text" value={{ tns }}/>
          {{/each}}
      </div>
      {{#if @model.startState}}
          <div class="row justify-content-md-center">
              <button type="button" class="ready btn btn-success col-md-4" {{action "berechnet"}}>Ich habe es fertig gerechnet</button>
          </div>
      {{/if}}
      {{#if @model.berechnetState}}
          <div class="row justify-content-md-center">
              <button type="button" class="ready btn btn-success col-md-4" {{action "korrigiert"}}>Ich habe es fertig überprüft</button>
          </div>
      {{/if}}
  </div>
  {{/unless}}
  {{#if @model.done}}
  <div class="container-fluid">
      <div class="row justify-content-md-center" style="text-align: center">
          <p class="col-md-4">Super. Du has 10 Aufgaben gerechnet!</p>
      </div>
    <a class="btn btn-primary" href="https://klexikon.zum.de/wiki/Spezial:Zuf%C3%A4llige_Seite" target="_blank">Möchtest Du etwas lernen?</a>
  </div>
  {{/if}}
  
  */
  {
    id: "DiBcrEvX",
    block: "{\"symbols\":[\"tns\",\"index\",\"sns\",\"fns\",\"result\",\"index\",\"@model\"],\"statements\":[[7,\"div\",true],[10,\"style\",\"display: flex\"],[8],[0,\"\\n\"],[4,\"each\",[[23,7,[\"results\"]]],null,{\"statements\":[[4,\"if\",[[28,\"eq\",[[23,5,[\"correct\"]],true],null]],null,{\"statements\":[[0,\"            \"],[7,\"button\",true],[10,\"style\",\"flex-grow: 1\"],[10,\"class\",\"success-marker btn btn-success\"],[10,\"type\",\"button\"],[8],[1,[23,5,[\"first\"]],false],[7,\"br\",true],[8],[9],[1,[23,5,[\"plusminus\"]],false],[7,\"br\",true],[8],[9],[1,[23,5,[\"second\"]],false],[9],[0,\"\\n\"]],\"parameters\":[]},{\"statements\":[[4,\"if\",[[28,\"eq\",[[23,5,[\"correct\"]],false],null]],null,{\"statements\":[[0,\"            \"],[7,\"button\",true],[10,\"style\",\"flex-grow: 1\"],[10,\"class\",\"success-marker btn btn-danger\"],[10,\"type\",\"button\"],[8],[1,[23,5,[\"first\"]],false],[7,\"br\",true],[8],[9],[1,[23,5,[\"plusminus\"]],false],[7,\"br\",true],[8],[9],[1,[23,5,[\"second\"]],false],[9],[0,\"\\n\"]],\"parameters\":[]},{\"statements\":[[0,\"            \"],[7,\"button\",true],[10,\"style\",\"flex-grow: 1\"],[10,\"class\",\"success-marker btn btn-primary\"],[10,\"type\",\"button\"],[8],[1,[23,6,[]],false],[9],[0,\"\\n        \"]],\"parameters\":[]}]],\"parameters\":[]}]],\"parameters\":[5,6]},null],[9],[0,\"\\n\"],[4,\"unless\",[[23,7,[\"done\"]]],null,{\"statements\":[[7,\"div\",false],[12,\"class\",\"container-fluid\"],[3,\"did-update\",[[23,0,[\"update\"]],[23,7,[\"counter\"]]]],[8],[0,\"\\n    \"],[7,\"div\",true],[10,\"class\",\"row\"],[8],[0,\"\\n        \"],[7,\"div\",true],[10,\"class\",\"col-3\"],[10,\"type\",\"text\"],[8],[9],[0,\"\\n\"],[4,\"each\",[[24,[\"firstnumbers\"]]],null,{\"statements\":[[0,\"            \"],[7,\"div\",true],[10,\"class\",\"first col-1 d-flex justify-content-center\"],[10,\"disabled\",\"\"],[10,\"type\",\"text\"],[8],[1,[23,4,[]],false],[9],[0,\"\\n\"]],\"parameters\":[4]},null],[0,\"    \"],[9],[0,\"\\n    \"],[7,\"div\",true],[10,\"class\",\"row\"],[8],[0,\"\\n        \"],[7,\"div\",true],[10,\"class\",\"col-2\"],[8],[9],[0,\"\\n        \"],[7,\"div\",true],[10,\"class\",\"col-1\"],[8],[1,[22,\"plusminus\"],false],[9],[0,\"\\n\"],[4,\"each\",[[24,[\"secondnumbers\"]]],null,{\"statements\":[[0,\"            \"],[7,\"div\",true],[10,\"class\",\"second col-1 d-flex justify-content-center\"],[10,\"disabled\",\"\"],[10,\"type\",\"text\"],[8],[1,[23,3,[]],false],[9],[0,\"\\n\"]],\"parameters\":[3]},null],[0,\"    \"],[9],[0,\"\\n    \"],[7,\"div\",true],[10,\"class\",\"row\"],[8],[0,\"\\n        \"],[7,\"div\",true],[10,\"class\",\"col-3\"],[8],[9],[0,\"\\n\"],[4,\"each\",[[23,0,[\"thirdnumbers\"]]],null,{\"statements\":[[0,\"          \"],[7,\"input\",false],[12,\"class\",\"third col-1\"],[12,\"value\",[23,1,[]]],[12,\"type\",\"text\"],[3,\"on\",[\"change\",[28,\"fn\",[[23,0,[\"numberEntered\"]],[23,2,[]]],null]]],[8],[9],[0,\"\\n\"]],\"parameters\":[1,2]},null],[0,\"    \"],[9],[0,\"\\n\"],[4,\"if\",[[23,7,[\"startState\"]]],null,{\"statements\":[[0,\"        \"],[7,\"div\",true],[10,\"class\",\"row justify-content-md-center\"],[8],[0,\"\\n            \"],[7,\"button\",false],[12,\"class\",\"ready btn btn-success col-md-4\"],[12,\"type\",\"button\"],[3,\"action\",[[23,0,[]],\"berechnet\"]],[8],[0,\"Ich habe es fertig gerechnet\"],[9],[0,\"\\n        \"],[9],[0,\"\\n\"]],\"parameters\":[]},null],[4,\"if\",[[23,7,[\"berechnetState\"]]],null,{\"statements\":[[0,\"        \"],[7,\"div\",true],[10,\"class\",\"row justify-content-md-center\"],[8],[0,\"\\n            \"],[7,\"button\",false],[12,\"class\",\"ready btn btn-success col-md-4\"],[12,\"type\",\"button\"],[3,\"action\",[[23,0,[]],\"korrigiert\"]],[8],[0,\"Ich habe es fertig \xFCberpr\xFCft\"],[9],[0,\"\\n        \"],[9],[0,\"\\n\"]],\"parameters\":[]},null],[9],[0,\"\\n\"]],\"parameters\":[]},null],[4,\"if\",[[23,7,[\"done\"]]],null,{\"statements\":[[7,\"div\",true],[10,\"class\",\"container-fluid\"],[8],[0,\"\\n    \"],[7,\"div\",true],[10,\"class\",\"row justify-content-md-center\"],[10,\"style\",\"text-align: center\"],[8],[0,\"\\n        \"],[7,\"p\",true],[10,\"class\",\"col-md-4\"],[8],[0,\"Super. Du has 10 Aufgaben gerechnet!\"],[9],[0,\"\\n    \"],[9],[0,\"\\n  \"],[7,\"a\",true],[10,\"class\",\"btn btn-primary\"],[10,\"href\",\"https://klexikon.zum.de/wiki/Spezial:Zuf%C3%A4llige_Seite\"],[10,\"target\",\"_blank\"],[8],[0,\"M\xF6chtest Du etwas lernen?\"],[9],[0,\"\\n\"],[9],[0,\"\\n\"]],\"parameters\":[]},null]],\"hasEval\":false}",
    meta: {
      moduleName: "mathe/components/plusminus-component.hbs"
    }
  });

  let PlusminusComponentComponent = (_class = (_temp = class PlusminusComponentComponent extends _component.default {
    constructor() {
      super(...arguments);

      _initializerDefineProperty(this, "plusminus", _descriptor, this);

      _initializerDefineProperty(this, "firstnumbers", _descriptor2, this);

      _initializerDefineProperty(this, "secondnumbers", _descriptor3, this);

      _initializerDefineProperty(this, "thirdnumbers", _descriptor4, this);

      this.clearon = 0;
      this.update();
    }

    berechnet() {
      this.args.berechnet();
    }

    korrigiert() {
      this.args.model.results[this.args.model.counter].result = parseInt(this.thirdnumbers.reduce((p, c) => p + '' + c));
      this.args.korrigiert();
      this.clearon = this.clearon + 1;
      this.thirdnumbers = this.thirdnumbers;
    }

    numberEntered(index, evt) {
      this.thirdnumbers[index] = evt.currentTarget.value.trim();
    }

    update() {
      if (this.args.model.done) {
        return;
      }

      this.plusminus = this.args.model.results[this.args.model.counter].plusminus;
      let firstString = "" + this.args.model.results[this.args.model.counter].first;
      let secondString = "" + this.args.model.results[this.args.model.counter].second;
      let thirdString = "0";
      this.firstnumbers = firstString.padStart(6, ' ').split('');
      this.secondnumbers = secondString.padStart(6, ' ').split('');
      this.thirdnumbers = thirdString.padStart(6, ' ').split('');
    }

  }, _temp), (_descriptor = _applyDecoratedDescriptor(_class.prototype, "plusminus", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: null
  }), _descriptor2 = _applyDecoratedDescriptor(_class.prototype, "firstnumbers", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: null
  }), _descriptor3 = _applyDecoratedDescriptor(_class.prototype, "secondnumbers", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: null
  }), _descriptor4 = _applyDecoratedDescriptor(_class.prototype, "thirdnumbers", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: null
  }), _applyDecoratedDescriptor(_class.prototype, "berechnet", [Ember._action], Object.getOwnPropertyDescriptor(_class.prototype, "berechnet"), _class.prototype), _applyDecoratedDescriptor(_class.prototype, "korrigiert", [Ember._action], Object.getOwnPropertyDescriptor(_class.prototype, "korrigiert"), _class.prototype), _applyDecoratedDescriptor(_class.prototype, "numberEntered", [Ember._action], Object.getOwnPropertyDescriptor(_class.prototype, "numberEntered"), _class.prototype), _applyDecoratedDescriptor(_class.prototype, "update", [Ember._action], Object.getOwnPropertyDescriptor(_class.prototype, "update"), _class.prototype)), _class);
  _exports.default = PlusminusComponentComponent;

  Ember._setComponentTemplate(__COLOCATED_TEMPLATE__, PlusminusComponentComponent);
});
;define("mathe/components/welcome-page", ["exports", "ember-welcome-page/components/welcome-page"], function (_exports, _welcomePage) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _welcomePage.default;
    }
  });
});
;define("mathe/controllers/tasks", ["exports"], function (_exports) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;

  var _class;

  function _applyDecoratedDescriptor(target, property, decorators, descriptor, context) { var desc = {}; Object.keys(descriptor).forEach(function (key) { desc[key] = descriptor[key]; }); desc.enumerable = !!desc.enumerable; desc.configurable = !!desc.configurable; if ('value' in desc || desc.initializer) { desc.writable = true; } desc = decorators.slice().reverse().reduce(function (desc, decorator) { return decorator(target, property, desc) || desc; }, desc); if (context && desc.initializer !== void 0) { desc.value = desc.initializer ? desc.initializer.call(context) : void 0; desc.initializer = undefined; } if (desc.initializer === void 0) { Object.defineProperty(target, property, desc); desc = null; } return desc; }

  let TasksController = (_class = class TasksController extends Ember.Controller {
    constructor() {
      super(...arguments);
      this.counter = 0;
    }

    berechnet() {
      this.model.startState = false;
      this.model.berechnetState = true;
    }

    korrigiert() {
      let results = this.model.results.map(function (e) {
        return e;
      });

      if (results[this.counter].result == results[this.counter].third) {
        results[this.counter].correct = true;
      } else {
        results[this.counter].correct = false;
      }

      this.counter = this.counter + 1;
      this.model.counter = this.counter;

      if (this.counter == this.model.results.length) {
        this.model.done = true;
      }

      this.model.startState = true;
      this.model.berechnetState = false;
    }

  }, (_applyDecoratedDescriptor(_class.prototype, "berechnet", [Ember._action], Object.getOwnPropertyDescriptor(_class.prototype, "berechnet"), _class.prototype), _applyDecoratedDescriptor(_class.prototype, "korrigiert", [Ember._action], Object.getOwnPropertyDescriptor(_class.prototype, "korrigiert"), _class.prototype)), _class);
  _exports.default = TasksController;
});
;define("mathe/data-adapter", ["exports", "@ember-data/debug"], function (_exports, _debug) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _debug.default;
    }
  });
});
;define("mathe/helpers/and", ["exports", "ember-truth-helpers/helpers/and"], function (_exports, _and) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _and.default;
    }
  });
  Object.defineProperty(_exports, "and", {
    enumerable: true,
    get: function () {
      return _and.and;
    }
  });
});
;define("mathe/helpers/app-version", ["exports", "mathe/config/environment", "ember-cli-app-version/utils/regexp"], function (_exports, _environment, _regexp) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.appVersion = appVersion;
  _exports.default = void 0;

  function appVersion(_, hash = {}) {
    const version = _environment.default.APP.version; // e.g. 1.0.0-alpha.1+4jds75hf
    // Allow use of 'hideSha' and 'hideVersion' For backwards compatibility

    let versionOnly = hash.versionOnly || hash.hideSha;
    let shaOnly = hash.shaOnly || hash.hideVersion;
    let match = null;

    if (versionOnly) {
      if (hash.showExtended) {
        match = version.match(_regexp.versionExtendedRegExp); // 1.0.0-alpha.1
      } // Fallback to just version


      if (!match) {
        match = version.match(_regexp.versionRegExp); // 1.0.0
      }
    }

    if (shaOnly) {
      match = version.match(_regexp.shaRegExp); // 4jds75hf
    }

    return match ? match[0] : version;
  }

  var _default = Ember.Helper.helper(appVersion);

  _exports.default = _default;
});
;define("mathe/helpers/eq", ["exports", "ember-truth-helpers/helpers/equal"], function (_exports, _equal) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _equal.default;
    }
  });
  Object.defineProperty(_exports, "equal", {
    enumerable: true,
    get: function () {
      return _equal.equal;
    }
  });
});
;define("mathe/helpers/gt", ["exports", "ember-truth-helpers/helpers/gt"], function (_exports, _gt) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _gt.default;
    }
  });
  Object.defineProperty(_exports, "gt", {
    enumerable: true,
    get: function () {
      return _gt.gt;
    }
  });
});
;define("mathe/helpers/gte", ["exports", "ember-truth-helpers/helpers/gte"], function (_exports, _gte) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _gte.default;
    }
  });
  Object.defineProperty(_exports, "gte", {
    enumerable: true,
    get: function () {
      return _gte.gte;
    }
  });
});
;define("mathe/helpers/is-array", ["exports", "ember-truth-helpers/helpers/is-array"], function (_exports, _isArray) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _isArray.default;
    }
  });
  Object.defineProperty(_exports, "isArray", {
    enumerable: true,
    get: function () {
      return _isArray.isArray;
    }
  });
});
;define("mathe/helpers/is-empty", ["exports", "ember-truth-helpers/helpers/is-empty"], function (_exports, _isEmpty) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _isEmpty.default;
    }
  });
});
;define("mathe/helpers/is-equal", ["exports", "ember-truth-helpers/helpers/is-equal"], function (_exports, _isEqual) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _isEqual.default;
    }
  });
  Object.defineProperty(_exports, "isEqual", {
    enumerable: true,
    get: function () {
      return _isEqual.isEqual;
    }
  });
});
;define("mathe/helpers/lt", ["exports", "ember-truth-helpers/helpers/lt"], function (_exports, _lt) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _lt.default;
    }
  });
  Object.defineProperty(_exports, "lt", {
    enumerable: true,
    get: function () {
      return _lt.lt;
    }
  });
});
;define("mathe/helpers/lte", ["exports", "ember-truth-helpers/helpers/lte"], function (_exports, _lte) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _lte.default;
    }
  });
  Object.defineProperty(_exports, "lte", {
    enumerable: true,
    get: function () {
      return _lte.lte;
    }
  });
});
;define("mathe/helpers/not-eq", ["exports", "ember-truth-helpers/helpers/not-equal"], function (_exports, _notEqual) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _notEqual.default;
    }
  });
  Object.defineProperty(_exports, "notEq", {
    enumerable: true,
    get: function () {
      return _notEqual.notEq;
    }
  });
});
;define("mathe/helpers/not", ["exports", "ember-truth-helpers/helpers/not"], function (_exports, _not) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _not.default;
    }
  });
  Object.defineProperty(_exports, "not", {
    enumerable: true,
    get: function () {
      return _not.not;
    }
  });
});
;define("mathe/helpers/or", ["exports", "ember-truth-helpers/helpers/or"], function (_exports, _or) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _or.default;
    }
  });
  Object.defineProperty(_exports, "or", {
    enumerable: true,
    get: function () {
      return _or.or;
    }
  });
});
;define("mathe/helpers/pluralize", ["exports", "ember-inflector/lib/helpers/pluralize"], function (_exports, _pluralize) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;
  var _default = _pluralize.default;
  _exports.default = _default;
});
;define("mathe/helpers/singularize", ["exports", "ember-inflector/lib/helpers/singularize"], function (_exports, _singularize) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;
  var _default = _singularize.default;
  _exports.default = _default;
});
;define("mathe/helpers/xor", ["exports", "ember-truth-helpers/helpers/xor"], function (_exports, _xor) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _xor.default;
    }
  });
  Object.defineProperty(_exports, "xor", {
    enumerable: true,
    get: function () {
      return _xor.xor;
    }
  });
});
;define("mathe/initializers/app-version", ["exports", "ember-cli-app-version/initializer-factory", "mathe/config/environment"], function (_exports, _initializerFactory, _environment) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;
  let name, version;

  if (_environment.default.APP) {
    name = _environment.default.APP.name;
    version = _environment.default.APP.version;
  }

  var _default = {
    name: 'App Version',
    initialize: (0, _initializerFactory.default)(name, version)
  };
  _exports.default = _default;
});
;define("mathe/initializers/container-debug-adapter", ["exports", "ember-resolver/resolvers/classic/container-debug-adapter"], function (_exports, _containerDebugAdapter) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;
  var _default = {
    name: 'container-debug-adapter',

    initialize() {
      let app = arguments[1] || arguments[0];
      app.register('container-debug-adapter:main', _containerDebugAdapter.default);
      app.inject('container-debug-adapter:main', 'namespace', 'application:main');
    }

  };
  _exports.default = _default;
});
;define("mathe/initializers/ember-data-data-adapter", ["exports", "@ember-data/debug/setup"], function (_exports, _setup) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _setup.default;
    }
  });
});
;define("mathe/initializers/ember-data", ["exports", "ember-data/setup-container", "ember-data"], function (_exports, _setupContainer, _emberData) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;

  /*
    This code initializes EmberData in an Ember application.
  
    It ensures that the `store` service is automatically injected
    as the `store` property on all routes and controllers.
  */
  var _default = {
    name: 'ember-data',
    initialize: _setupContainer.default
  };
  _exports.default = _default;
});
;define("mathe/initializers/export-application-global", ["exports", "mathe/config/environment"], function (_exports, _environment) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.initialize = initialize;
  _exports.default = void 0;

  function initialize() {
    var application = arguments[1] || arguments[0];

    if (_environment.default.exportApplicationGlobal !== false) {
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

      var value = _environment.default.exportApplicationGlobal;
      var globalName;

      if (typeof value === 'string') {
        globalName = value;
      } else {
        globalName = Ember.String.classify(_environment.default.modulePrefix);
      }

      if (!theGlobal[globalName]) {
        theGlobal[globalName] = application;
        application.reopen({
          willDestroy: function () {
            this._super.apply(this, arguments);

            delete theGlobal[globalName];
          }
        });
      }
    }
  }

  var _default = {
    name: 'export-application-global',
    initialize: initialize
  };
  _exports.default = _default;
});
;define("mathe/instance-initializers/ember-data", ["exports", "ember-data/initialize-store-service"], function (_exports, _initializeStoreService) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;
  var _default = {
    name: 'ember-data',
    initialize: _initializeStoreService.default
  };
  _exports.default = _default;
});
;define("mathe/modifiers/did-insert", ["exports", "@ember/render-modifiers/modifiers/did-insert"], function (_exports, _didInsert) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _didInsert.default;
    }
  });
});
;define("mathe/modifiers/did-update", ["exports", "@ember/render-modifiers/modifiers/did-update"], function (_exports, _didUpdate) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _didUpdate.default;
    }
  });
});
;define("mathe/modifiers/will-destroy", ["exports", "@ember/render-modifiers/modifiers/will-destroy"], function (_exports, _willDestroy) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _willDestroy.default;
    }
  });
});
;define("mathe/router", ["exports", "mathe/config/environment"], function (_exports, _environment) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;

  function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

  class Router extends Ember.Router {
    constructor(...args) {
      super(...args);

      _defineProperty(this, "location", _environment.default.locationType);

      _defineProperty(this, "rootURL", _environment.default.rootURL);
    }

  }

  _exports.default = Router;
  Router.map(function () {
    this.route('tasks');
  });
});
;define("mathe/routes/tasks", ["exports"], function (_exports) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;

  var _class, _descriptor, _descriptor2, _descriptor3, _descriptor4, _descriptor5, _temp;

  function _initializerDefineProperty(target, property, descriptor, context) { if (!descriptor) return; Object.defineProperty(target, property, { enumerable: descriptor.enumerable, configurable: descriptor.configurable, writable: descriptor.writable, value: descriptor.initializer ? descriptor.initializer.call(context) : void 0 }); }

  function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

  function _applyDecoratedDescriptor(target, property, decorators, descriptor, context) { var desc = {}; Object.keys(descriptor).forEach(function (key) { desc[key] = descriptor[key]; }); desc.enumerable = !!desc.enumerable; desc.configurable = !!desc.configurable; if ('value' in desc || desc.initializer) { desc.writable = true; } desc = decorators.slice().reverse().reduce(function (desc, decorator) { return decorator(target, property, desc) || desc; }, desc); if (context && desc.initializer !== void 0) { desc.value = desc.initializer ? desc.initializer.call(context) : void 0; desc.initializer = undefined; } if (desc.initializer === void 0) { Object.defineProperty(target, property, desc); desc = null; } return desc; }

  function _initializerWarningHelper(descriptor, context) { throw new Error('Decorating class property failed. Please ensure that ' + 'proposal-class-properties is enabled and runs after the decorators transform.'); }

  let Task = (_class = (_temp = class Task {
    constructor() {
      _initializerDefineProperty(this, "results", _descriptor, this);

      _initializerDefineProperty(this, "startState", _descriptor2, this);

      _initializerDefineProperty(this, "berechnetState", _descriptor3, this);

      _initializerDefineProperty(this, "counter", _descriptor4, this);

      _initializerDefineProperty(this, "done", _descriptor5, this);
    }

  }, _temp), (_descriptor = _applyDecoratedDescriptor(_class.prototype, "results", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: function () {
      return [];
    }
  }), _descriptor2 = _applyDecoratedDescriptor(_class.prototype, "startState", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: function () {
      return true;
    }
  }), _descriptor3 = _applyDecoratedDescriptor(_class.prototype, "berechnetState", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: function () {
      return false;
    }
  }), _descriptor4 = _applyDecoratedDescriptor(_class.prototype, "counter", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: function () {
      return 0;
    }
  }), _descriptor5 = _applyDecoratedDescriptor(_class.prototype, "done", [Ember._tracked], {
    configurable: true,
    enumerable: true,
    writable: true,
    initializer: function () {
      return false;
    }
  })), _class);

  class TasksRoute extends Ember.Route {
    model() {
      let model = new Task();

      function getRandomInt(min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min)) + min;
      }

      for (let i = 0; i < 10; i++) {
        var _obj, _init;

        let first = 0;
        let second = 0;
        let third = 0;
        let plusminus = '+';
        first = getRandomInt(1, 100000);
        let r = getRandomInt(0, 4);

        if (r == 0) {
          plusminus = '+';
          second = getRandomInt(1, 100001 - first);
          third = first + second;
        }

        if (r == 1) {
          plusminus = '-';
          second = getRandomInt(1, first);
          third = first - second;
        }

        if (r == 2) {
          plusminus = '*';
          second = getRandomInt(1, Math.min(100, 100000 / first));
          third = first * second;
        }

        if (r == 3) {
          plusminus = '/';
          first = getRandomInt(1, 10000);
          second = getRandomInt(1, Math.min(100, 100000 / first));
          third = first;
          first = first * second;
        }

        model.results.pushObject((_obj = {
          first: first,
          second: second,
          third: third,
          plusminus: plusminus,
          correct: null
        }, (_applyDecoratedDescriptor(_obj, "correct", [Ember._tracked], (_init = Object.getOwnPropertyDescriptor(_obj, "correct"), _init = _init ? _init.value : undefined, {
          enumerable: true,
          configurable: true,
          writable: true,
          initializer: function () {
            return _init;
          }
        }), _obj)), _obj));
      }

      return model;
    }

  }

  _exports.default = TasksRoute;
});
;define("mathe/serializers/-default", ["exports", "@ember-data/serializer/json"], function (_exports, _json) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _json.default;
    }
  });
});
;define("mathe/serializers/-json-api", ["exports", "@ember-data/serializer/json-api"], function (_exports, _jsonApi) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _jsonApi.default;
    }
  });
});
;define("mathe/serializers/-rest", ["exports", "@ember-data/serializer/rest"], function (_exports, _rest) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _rest.default;
    }
  });
});
;define("mathe/services/store", ["exports", "ember-data/store"], function (_exports, _store) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _store.default;
    }
  });
});
;define("mathe/templates/application", ["exports"], function (_exports) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;

  var _default = Ember.HTMLBars.template({
    "id": "gDT0mGH7",
    "block": "{\"symbols\":[],\"statements\":[[1,[22,\"outlet\"],false],[0,\"\\n\"]],\"hasEval\":false}",
    "meta": {
      "moduleName": "mathe/templates/application.hbs"
    }
  });

  _exports.default = _default;
});
;define("mathe/templates/tasks", ["exports"], function (_exports) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  _exports.default = void 0;

  var _default = Ember.HTMLBars.template({
    "id": "Sv0Amhsk",
    "block": "{\"symbols\":[\"@model\"],\"statements\":[[5,\"plusminus-component\",[],[[\"@model\",\"@startState\",\"@berechnetState\",\"@berechnet\",\"@korrigiert\",\"@counter\",\"@lernen\"],[[23,1,[]],[23,1,[\"startState\"]],[23,1,[\"berechnetState\"]],[23,0,[\"berechnet\"]],[23,0,[\"korrigiert\"]],[23,1,[\"counter\"]],[23,0,[\"lernen\"]]]]],[0,\"\\n\"]],\"hasEval\":false}",
    "meta": {
      "moduleName": "mathe/templates/tasks.hbs"
    }
  });

  _exports.default = _default;
});
;define("mathe/transforms/boolean", ["exports", "@ember-data/serializer/-private"], function (_exports, _private) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _private.BooleanTransform;
    }
  });
});
;define("mathe/transforms/date", ["exports", "@ember-data/serializer/-private"], function (_exports, _private) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _private.DateTransform;
    }
  });
});
;define("mathe/transforms/number", ["exports", "@ember-data/serializer/-private"], function (_exports, _private) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _private.NumberTransform;
    }
  });
});
;define("mathe/transforms/string", ["exports", "@ember-data/serializer/-private"], function (_exports, _private) {
  "use strict";

  Object.defineProperty(_exports, "__esModule", {
    value: true
  });
  Object.defineProperty(_exports, "default", {
    enumerable: true,
    get: function () {
      return _private.StringTransform;
    }
  });
});
;

;define('mathe/config/environment', [], function() {
  var prefix = 'mathe';
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

;
          if (!runningTests) {
            require("mathe/app")["default"].create({"name":"mathe","version":"0.0.0+e51afb14"});
          }
        
//# sourceMappingURL=mathe.map
