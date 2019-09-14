import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';

import { ActiveTravelerStore } from './traveler/active.traveler.store';
import { Traveler } from './traveler/traveler';
import { Location } from './geolocation/Location';

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

    interval(1000)
      .subscribe(() => this.setLocation());

    let loggedInTraveler = new Traveler('Roman Borsuk', '', 'Poland', ['Suahili']);

    this.activeTravelerStore.set(loggedInTraveler);
  }

  setLocation(): void {
    this.geolocationService.getLocation()
        .subscribe((currentLocation: Location) => {
          this.location = currentLocation;
        });
  }

}
