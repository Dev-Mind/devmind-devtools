/**
 * In this class we register the controllers used in our pages
 */
import {SessionCtrl} from './session/session.js';
import {SessionDetailCtrl} from './session/session-detail.js';
import {SpeakerCtrl} from './speaker/speaker.js';

/* eslint-env browser */
export class Application {

  constructor() {
    this.components = new Map();

    if (!self.fetch) {
      console.error('This app used the fetch API to load data, but your browser don\'t support this feature. Add a pollyfill');
    }
    this._initServiceWorkers();

    // Register all the components
    this._registerComponent('session', new SessionCtrl(), 'session/session.html');
    this._registerComponent('session-detail', new SessionDetailCtrl(), 'session/session-detail.html');
    this._registerComponent('speaker', new SpeakerCtrl(), 'speaker/speaker.html');

    // Session list is loaded by default
    this.go('session');
  }

  /**
   * Initialize service workers to be able to use cache for ressources
   * @private
   */
  _initServiceWorkers() {
    // Check to make sure service workers are supported in the current browser,
    // and that the current page is accessed from a secure origin. Using a
    // service worker from an insecure origin will trigger JS console errors. See
    // http://www.chromium.org/Home/chromium-security/prefer-secure-origins-for-powerful-new-features
    let isLocalhost = Boolean(window.location.hostname === 'localhost' ||
      // [::1] is the IPv6 localhost address.
      window.location.hostname === '[::1]' ||
      // 127.0.0.1/8 is considered localhost for IPv4.
      window.location.hostname.match(
        /^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/
      )
    );

    if ('serviceWorker' in navigator && (window.location.protocol === 'https:' || isLocalhost)) {
      navigator.serviceWorker.register('service-worker.js')
        .then(registration => {
          // updatefound is fired if service-worker.js changes.
          registration.onupdatefound = () => {
            // updatefound is also fired the very first time the SW is installed,
            // and there's no need to prompt for a reload at that point.
            // So check here to see if the page is already controlled,
            // i.e. whether there's an existing service worker.
            if (navigator.serviceWorker.controller) {
              // The updatefound event implies that registration.installing is set:
              // https://slightlyoff.github.io/ServiceWorker/spec/service_worker/index.html#service-worker-container-updatefound-event
              var installingWorker = registration.installing;

              installingWorker.onstatechange = () => {
                switch (installingWorker.state) {
                  case 'installed':
                    // At this point, the old content will have been purged and the
                    // fresh content will have been added to the cache.
                    // It's the perfect time to display a "New content is
                    // available; please refresh." message in the page's interface.
                    break;

                  case 'redundant':
                    throw new Error('The installing service worker became redundant.');

                  default:
                  // Ignore
                }
              };
            }
          };
        })
        .catch(e => console.error('Error during service worker registration:', e));
    }
  }

  /**
   * Register a new controller and a view to be able to load them later.
   * @param {string} name of the component
   * @param {Object} ctrl used by the component
   * @param {string} view path
   * @private
   */
  _registerComponent(name, ctrl, view) {
    this.components.set(name, {
      controller: ctrl,
      view: view
    });
  }

  /**
   * Load a template in the main page
   * @param {string} target component name
   */
  go(target, ...args) {
    let component = this.components.get(target);
    fetch(component.view).then(response => {
      response.text().then(html => window.document.getElementById('dmContent').innerHTML = html);
    });
    component.controller.init(args);
  }
}
