import Model, { attr } from '@ember-data/model';

const Task = Model.extend({
    value11: attr(),
    value12: attr(),
    value13: attr(),
    value21: attr(),
    value22: attr(),
    value23: attr(),
    plusminus: attr(),
    result: attr(),
    startState: attr(),
    berechnetState: attr()
});
