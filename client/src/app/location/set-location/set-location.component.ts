import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription, timer } from 'rxjs';

import { AirportsService } from '../airports.service';
import { Airport } from '../airport';
import { SelectedActivitiesStore } from '../selected-activities-store.service';
import { Activity } from './Activity';

export enum LocationFetchStatus {
  SUCCESS,
  IN_PROGRES,
  FAIL
}

@Component({
  selector: 'app-set-location',
  templateUrl: './set-location.component.html',
  styleUrls: ['./set-location.component.scss']
})
export class SetLocationComponent implements OnInit {

  locations: Array<Airport> = [];

  fetchStatus: LocationFetchStatus = LocationFetchStatus.IN_PROGRES;

  activities: Array<Activity> = [
    { name: 'Eat', imageUrl: '' },
    { name: 'Drink', imageUrl: '' },
    { name: 'Chat', imageUrl: '' },
    { name: 'Explore', imageUrl: '' }
  ];

  selectedActivities: Array<Activity> = [];

  constructor(private readonly airportsService: AirportsService,
              private readonly activitiesStore: SelectedActivitiesStore,
              private readonly router: Router) {

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

  toggleActivity(activity: Activity): void {
    if (this.activityActive(activity)) {
      this.selectedActivities = this.selectedActivities.filter(a => a.name !== activity.name);
    } else {
      this.selectedActivities.push(activity);
    }
  }

  activityActive(activity: Activity): boolean {
    return !!this.selectedActivities.some(a => a.name === activity.name);
  }

  showProgress(): boolean {
    return this.fetchStatus === LocationFetchStatus.IN_PROGRES;
  }

  next(): void {
    this.activitiesStore.set(this.selectedActivities);
    this.router.navigate(['check-in']);
  }

}
