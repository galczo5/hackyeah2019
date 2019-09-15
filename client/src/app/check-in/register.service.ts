import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, zip } from 'rxjs';
import { SelectedAirportStore } from '../location/selected-airport.store';
import { SelectedActivitiesStore } from '../location/selected-activities-store.service';
import { ActiveTravelerStore } from '../traveler/active.traveler.store';
import { WaitingTimeStore } from './waiting-time-store.service';
import { switchMap, take, tap } from 'rxjs/operators';
import { NeedRequestIdStore } from './need-request-id.store';
import { NeedRequestId } from './need-request-id';
import { CookieService } from 'ngx-cookie-service';

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

  private readonly url = 'http://localhost:8080/api/needs/register';

  constructor(private httpClient: HttpClient,
              private waitingTimeStore: WaitingTimeStore,
              private selectedActivitiesStore: SelectedActivitiesStore,
              private activeTravelerStore: ActiveTravelerStore,
              private selectedAirportStore: SelectedAirportStore,
              private needRequestIdStore: NeedRequestIdStore) {
  }

  register(): void {

    zip(
      this.selectedActivitiesStore.select(),
      this.selectedAirportStore.select(),
      this.waitingTimeStore.select()
    )
      .pipe(
        switchMap((args) => {

          const activities = args[0],
            airport = args[1],
            time = args[2];

          let availableToDate = new Date();

          availableToDate.setHours(availableToDate.getHours() + time.hours);
          availableToDate.setMinutes(availableToDate.getMinutes() + time.minutes);

          const request: RegisterRequest = {

            needs: activities.map(a => a.name.toLocaleUpperCase()),

            airport: airport.id,

            availableFrom: new Date(),

            availableTo: availableToDate
          } as any;

          let headers = new HttpHeaders({
            'Content-Type': 'application/json',
          });

          return this.httpClient
                     .post(this.url,
                       request,
                       {
                         headers,
                         withCredentials: true
                       }
                     );

        }),
        take(1)
      )
      .subscribe((response: NeedRequestId) => {

        this.needRequestIdStore.set(response);

      });

  }

}
