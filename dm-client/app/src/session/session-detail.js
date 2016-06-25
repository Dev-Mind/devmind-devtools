/**
 * This class is used to display the sessions
 */
export class SessionDetailCtrl {

  /**
   * Call server to load a session
   * @param {string} idSession session id
   */
  init(idSession) {
    fetch('api/session/' + idSession).then(response => {
      response.json().then(json => {
        this.session = json;
        this._refreshScreen();
      });
    });
  }

  /**
   * Display a session
   * @private
   */
  _refreshScreen() {
    let lines = '';
    let speakers = '';

    if (this.session) {
      this.session.speakers.forEach(speaker => {
        speakers += `<li>${speaker.firstname} ${speaker.lastname} </li>`;
      });

      lines += `
          <h2>${this.session.title}</h2>
          <p>de ${this.session.start} à ${this.session.end}</p>
          <p>${this.session.summary}</p>
          <p>${this.session.description}</p>
          <h2>Speakers</h2>
          <ul>${speakers}</ul>
      `;
    }

    window.document.getElementById('dmSession').innerHTML = lines;
  }
}
