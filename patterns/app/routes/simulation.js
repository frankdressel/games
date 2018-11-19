import Ember from 'ember';

export default Ember.Route.extend({
    actions: {
        fill(d){
            return d3.interpolateOranges(d['state'] / 3);
            //return d['state'] && 'black' || 'white';
        },
        stroke(d) {
            return (d['street'] && 'black') || 'red';
        }
    }
});
