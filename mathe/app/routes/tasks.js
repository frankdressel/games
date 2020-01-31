import Route from '@ember/routing/route';
import EmberObject from '@ember/object';
const Task = EmberObject.extend({})

export default Route.extend({
    model() {
        return Task.create({
            results: [],
            startState: true,
            berechnetState: false
            });
    },
    setupController(controller, model){
        controller.set('model', model);
        controller.initialise(model);
    }
});
