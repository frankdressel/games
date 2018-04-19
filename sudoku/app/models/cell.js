import DS from 'ember-data';

export default DS.Model.extend({
    generated: DS.attr('boolean'),
    symbol: DS.attr('string')
});
