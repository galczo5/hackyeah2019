import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';

import { ActiveTravelerStore } from './traveler/active.traveler.store';
import { Traveler } from './traveler/traveler';
import { Location } from './geolocation/Location';
import { GeolocationService } from './geolocation/geolocation.service';
import {RouterOutlet} from "@angular/router";
import {routerAnimation} from "./routerAnimations";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  animations: [
    routerAnimation()
    // animation triggers go here
  ]
})
export class AppComponent implements OnInit {

  location: Location;
  title = 'client';
  i = 0;

  constructor() {
  }

  ngOnInit() {

  }

  getRouteAnimation(outlet: RouterOutlet) {
    const res =
      outlet.activatedRouteData.num === undefined
        ? -1
        : outlet.activatedRouteData.num;

    return res;
  }
}
