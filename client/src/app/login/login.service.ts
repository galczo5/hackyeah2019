import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { CookieService } from 'ngx-cookie-service';

import { Traveler } from '../traveler/traveler';
import { ActiveTravelerStore } from '../traveler/active.traveler.store';


export interface LoginRequest {
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly url = 'http://localhost:8080/profiles/1';

  private readonly loginUrl = 'http://localhost:8080/api/security/login/';

  constructor(private httpClient: HttpClient,
              private cookieService: CookieService,
              private activeTravelerStore: ActiveTravelerStore) {
  }

  login(username: string, password: string): Observable<void> {

    const request: LoginRequest = {
      username,
      password
    };

    return this.httpClient
               .post(this.loginUrl, request)
               .pipe(
                 map((jid: string) => {
                   this.cookieService.set('JSESSIONID', jid)
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
