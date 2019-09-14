import {Component, OnInit} from '@angular/core';
import { interval } from 'rxjs'
import {GeolocationService} from "./geolocation/geolocation.service";
import {Location} from "./geolocation/Location";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  location: Location;
  title = 'client';

  constructor(private readonly geolocationService: GeolocationService) {}

  ngOnInit(): void {
    interval(1000)
      .subscribe(() => this.setLocation());
  }

  setLocation(): void {
    this.geolocationService.getLocation()
      .subscribe((currentLocation: Location) => {
        this.location = currentLocation;
      });
  }
}
