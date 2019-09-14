import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { WaitingTimeStore } from '../check-in/waiting-time-store.service';
import { SelectedActivitiesStore } from '../location/selected-activities-store.service';
import { ActiveTravelerStore } from '../traveler/active.traveler.store';
import { SelectedAirportStore } from '../location/selected-airport.store';
import { NeedRequestIdStore } from '../check-in/need-request-id.store';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { NeedRequestId } from '../check-in/need-request-id';
import { Traveler } from '../traveler/traveler';

@Injectable({
  providedIn: 'root'
})
export class MatchedService {

  private readonly url = 'http://localhost:8080/api/needs/match';

  constructor(private httpClient: HttpClient,
              private needRequestIdStore: NeedRequestIdStore) {
  }

  findMatched(): Observable<Array<Traveler>> {

    return this.needRequestIdStore
               .select()
               .pipe(
                 switchMap((requestId: NeedRequestId) => {

                   return this.httpClient
                              .get(this.url + '/' + requestId.id);
                 }),
                 map((rawMatched: Array<any>) => {

                   return rawMatched.map((rawTraveler) => {

                     return new Traveler(
                       rawTraveler.profile.travelerId,
                       rawTraveler.profile.nickname,
                       '',
                       rawTraveler.profile.nationality,
                       rawTraveler.profile.languages
                     );
                   });
                 })
               );


  }

}
