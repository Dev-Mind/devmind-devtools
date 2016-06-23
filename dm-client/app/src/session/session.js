/**
 * This class is used to display the sessions
 */
export class SessionCtrl {

  constructor() {
    this.init();
  }

  /**
   * Call server to load sessions
   */
  init() {
    fetch('api/session').then(response => {
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
    let lines = '';

    if (this.data) {
      this.data.forEach(session => {
        // We want to display the speakers
        let speakers = '';
        session.speakers.forEach(speaker => {
          speakers += `${speaker.firstname} ${speaker.lastname} `;
        });

        lines += `<div class="dm_session__item">
          <a href="#session/${session.id}" onClick="app.go('session-detail', ${session.id})">${session.title}</a>
          <p class="dm_session__time">de ${session.start} à ${session.end}</p>
          <p>${session.summary}</p>
          <p class="dm_session__speaker">${speakers}</p>
      </div>`;
      });
    }

    window.document.getElementById('dmSessions').innerHTML = lines;
  }
}
