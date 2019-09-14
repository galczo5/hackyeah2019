import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Traveler } from '../traveler/traveler';
import { ActiveTravelerStore } from '../traveler/active.traveler.store';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly url = 'http://localhost:8080/profiles/1';

  constructor(private httpClient: HttpClient,
              private activeTravelerStore: ActiveTravelerStore) {
  }

  selectCurrentUser(): void {
    this.httpClient
        .get(this.url)
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
