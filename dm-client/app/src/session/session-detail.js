/**
 * This class is used to display the sessions
 */
export class SessionDetailCtrl {

  constructor() {
    this.init();
  }

  /**
   * Call server to load a session
   */
  init(idSession) {
    console.log('display' + idSession)
     // fetch('api/session').then(response => {
    //   response.json().then(json => {
    //     this.data = json;
    //     this._refreshScreen();
    //   });
    // });
  }

  /**
   * Display a session
   * @private
   */
  _refreshScreen() {
    
  }
}
