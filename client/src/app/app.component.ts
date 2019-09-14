import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';

import { ActiveTravelerStore } from './traveler/active.traveler.store';
import { Traveler } from './traveler/traveler';
import { Location } from './geolocation/Location';
import { GeolocationService } from './geolocation/geolocation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  location: Location;
  title = 'client';

  constructor(private activeTravelerStore: ActiveTravelerStore) {
  }

  ngOnInit() {
    const loggedInTraveler = new Traveler('Roman Borsuk', '', 'Poland', ['Suahili']);
    this.activeTravelerStore.set(loggedInTraveler);
  }
}
