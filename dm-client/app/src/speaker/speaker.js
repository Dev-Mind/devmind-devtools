export class SpeakerCtrl {
  constructor(){
    this.init();
  }

  /**
   * Call server to load speakers
   */
  init() {
    fetch('api/speaker').then(response => {
      response.json().then(json => {
        this.data = json;
        this._refreshScreen();
      });
    });
  }

  /**
   * Display the list of the sessions
   * @private
   */
  _refreshScreen() {

  }
}
