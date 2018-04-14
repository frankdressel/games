import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';

export default Route.extend({
    sudokuGenerator: service(),
    queryParams: {
        id: {
            refreshModel: true
        }
    },
    model(){
        let sudoku=this.get('sudokuGenerator').generate();
        return this.get('sudokuGenerator').puzzle(sudoku, 20);
    }
});
