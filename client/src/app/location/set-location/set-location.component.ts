import { Component, OnInit } from '@angular/core';
import {Subscription, timer} from 'rxjs'
import {AirportsService} from "../airports.service";
import {Airport} from "../airport";
import {filter} from "rxjs/operators";

export enum LocationFetchStatus {
  SUCCESS,
  IN_PROGRES,
  FAIL
};

@Component({
  selector: 'app-set-location',
  templateUrl: './set-location.component.html',
  styleUrls: ['./set-location.component.scss']
})
export class SetLocationComponent implements OnInit {

  locations: Array<Airport> = [];

  fetchStatus: LocationFetchStatus = LocationFetchStatus.IN_PROGRES;

  constructor(private readonly airportsService: AirportsService) {

  }

  ngOnInit() {
    let subscription: Subscription = this.airportsService.getAirports()
      .subscribe(airports => {
        this.locations = airports;
        this.fetchStatus = LocationFetchStatus.SUCCESS;
      });

    timer(5000)
      .subscribe(() => {
        if (this.fetchStatus === LocationFetchStatus.IN_PROGRES) {
          subscription.unsubscribe();
          this.fetchStatus = LocationFetchStatus.FAIL;
        }
      });
  }

  showProgress(): boolean {
    return this.fetchStatus === LocationFetchStatus.IN_PROGRES;
  }

}
