import { Component, OnInit } from '@angular/core';
import { timer } from 'rxjs'

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

  locations: Array<string> = [
    'WAW - Warsaw Chopin',
    'WMI - Warsaw Modlin',
    'LAX - Los Angeles',
    'DBL - Dublin'
  ];

  fetchStatus: LocationFetchStatus = LocationFetchStatus.IN_PROGRES;

  constructor() { }

  ngOnInit() {
    timer(2500)
      .subscribe(() => {
        this.fetchStatus = LocationFetchStatus.FAIL;
      });
  }

  showProgress(): boolean {
    return this.fetchStatus === LocationFetchStatus.IN_PROGRES;
  }

}
