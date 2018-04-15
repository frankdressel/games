import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import RSVP from 'rsvp';

export default Route.extend({
    sudokuGenerator: service(),
    queryParams: {
        id: {
            refreshModel: true
        }
    },
    model(){
        let that=this;
        return new RSVP.Promise(function(resolve) {
            Ember.run.later(function() {
                let sudoku=that.get('sudokuGenerator').generate();
                let puzzle=that.get('sudokuGenerator').puzzle(sudoku, 60);
                resolve({puzzle});
            });
        });
    }
});
