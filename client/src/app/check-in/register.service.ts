import { Injectable } from '@angular/core';
import { Store } from '../utils/Store';
import { WaitingTime } from './WaitingTime';
import { HttpClient } from '@angular/common/http';
import { Observable, zip } from 'rxjs';
import { SelectedAirportStore } from '../location/selected-airport.store';
import { SelectedActivitiesStore } from '../location/selected-activities-store.service';
import { ActiveTravelerStore } from '../traveler/active.traveler.store';
import { WaitingTimeStore } from './waiting-time-store.service';
import { switchMap } from 'rxjs/operators';

export interface RegisterRequest {

  traveler: number;

  needs: Array<string>;

  airport: number;

  availableFrom: string;

  availableTo: string;
}

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private readonly url = 'http://localhost:8080/needs/register';

  constructor(private httpClient: HttpClient,
              private waitingTimeStore: WaitingTimeStore,
              private selectedActivitiesStore: SelectedActivitiesStore,
              private activeTravelerStore: ActiveTravelerStore,
              private selectedAirportStore: SelectedAirportStore) {
  }

  register(): void {

    zip(
      this.selectedActivitiesStore.select(),
      this.activeTravelerStore.select(),
      this.selectedAirportStore.select(),
      this.waitingTimeStore.select()
    )
      .pipe(
        switchMap((args) => {
          console.log(args);

          const activities = args[0],
            traveler = args[1],
            airport = args[2],
            time = args[3];

          console.log(traveler)

          const request: RegisterRequest = {

            traveler: traveler.id,

            needs: activities.map(a => a.name.toLocaleUpperCase()),

            airport: airport.id,

            availableFrom: new Date(),

            availableTo: new Date()
          } as any;

          return this.httpClient
                     .post(this.url,
                       request
                     );

        })
      )
      .subscribe((response) => {

        console.log(response)

      })

  }

}
