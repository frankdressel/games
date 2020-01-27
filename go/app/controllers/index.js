import Controller from '@ember/controller';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';
import { tracked } from '@glimmer/tracking';

export default class IndexController extends Controller {
  @service('connection') connection;
  @tracked connected = false;

  @action
  new_game() {
    let state = '';
    for(let i = 0; i < 19*19; i++) {
      state = state + 'e';
    }
    this.load_game(state + '_b_0_0');
  }

  @action
  load_game(state) {
    this.transitionToRoute('/game/' + state);
  }

  @action
  config(host, gameid, password) {
    let connected = this.connection.set_host(host, gameid, password);
    let self = this;
    connected.then(r => {
      self.connected = true;
    });
  }
}
