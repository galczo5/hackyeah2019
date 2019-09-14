import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Traveler } from '../traveler/traveler';
import { ActiveTravelerStore } from '../traveler/active.traveler.store';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly url = 'http://localhost:8080/profiles/1';

  private readonly loginUrl = 'http://localhost:8080/login/';

  constructor(private httpClient: HttpClient,
              private activeTravelerStore: ActiveTravelerStore) {
  }

  loginByTravelerId(id: string): Observable<void> {
    return this.httpClient
               .get(this.loginUrl + id)
               .pipe(
                 map(() => {
                   return null;
                 })
               );
  }

  selectCurrentUser(): void {
    this.httpClient
        .get(this.loginUrl)
        .subscribe((rawTraveler: any) => {

          const traveler = new Traveler(
            rawTraveler.travelerId,
            rawTraveler.nickname,
            '',
            rawTraveler.nationality,
            rawTraveler.languages
          );

          this.activeTravelerStore.set(traveler);
        });
  }

}
