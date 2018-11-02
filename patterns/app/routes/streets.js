import Ember from 'ember';

export default Ember.Route.extend({
    actions: {
        fill(d){
            return d['street'] && 'black' || 'white';
        },
        stroke(d) {
            return 'red';
        }
    }
});
