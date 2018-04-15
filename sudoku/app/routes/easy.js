import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
    queryParams: {
        id: {
            refreshModel: true
        }
    },
    model(){
        return new RSVP.Promise(function(resolve) {
            var worker = new Worker('sudokugenerator.js');
            worker.addEventListener('message', function(e) {
                resolve(e.data);
            }, false);
            worker.postMessage({'diffscore': 20});
        });
    }
});
