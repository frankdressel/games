import DS from 'ember-data';

const Task = DS.Model.extend({
    value11: DS.attr(),
    value12: DS.attr(),
    value13: DS.attr(),
    value21: DS.attr(),
    value22: DS.attr(),
    value23: DS.attr(),
    plusminus: DS.attr(),
    result: DS.attr(),
    startState: DS.attr(),
    berechnetState: DS.attr()
});
