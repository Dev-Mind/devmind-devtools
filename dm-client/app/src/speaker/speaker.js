export class SpeakerCtrl {
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
    let lines = '';

    if (this.data) {
      this.data.forEach(speaker => {
        // We want to display the speakers
        lines += `<div class="dm_list__item">
          <a class="dm_lead" href="#session/${speaker.id}" onClick="app.go('session-detail', ${speaker.id})">${speaker.firstname} ${speaker.lastname}</a>
          <p class="dm_list__summary">${speaker.shortDescription}</p>
      </div>`;
      });
    }

    window.document.getElementById('dmSpeakers').innerHTML = lines;
  }
}
