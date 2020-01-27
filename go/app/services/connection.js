import Service from '@ember/service';

export default class ConnectionService extends Service {

  constructor() {
    super(...arguments);
  }

  set_host(url, gameid, password) {
    let self = this;
    let promise = new Promise(function(resolve) {
      let client = new WebSocket(url + '/go/' + gameid);

      client.onmessage = self._onmessage(this);
      client.onerror = (error) => console.log(error);
      client.onopen = () => {
        self.client = client;
        self.client.send('password'+ password);

        resolve();
      }
     
      self.gameid = gameid;
    });

    return promise;
  }

  send(state) {
    if(this.client) {
      this.client.send(state);
    }
  }

  _onmessage(self) {
    function onmessageWithClient(message) {
      if(self.update) {
        self.update(message.data);
      }
    }

    return onmessageWithClient;
  }
}
