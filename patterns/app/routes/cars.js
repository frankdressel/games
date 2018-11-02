import Ember from 'ember';

export default Ember.Route.extend({
    actions: {
        fill(d){
            return d3.interpolateOranges(d['cars'].length > 0);
        },
        stroke(d) {
            return (d['street'] && 'black') || 'red';
        }
    }
});
