import Route from '@ember/routing/route';

export default Route.extend({
    actions: {
        easy(){
            this.transitionTo('easy', { queryParams: { id: new Date().getTime() }});
        },
        medium(){
            this.transitionTo('medium', { queryParams: { id: new Date().getTime() }});
        },
        difficult(){
            this.transitionTo('difficult', { queryParams: { id: new Date().getTime() }});
        },
    }
});
