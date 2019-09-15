import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Achievement } from '../achivement';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AirportAchievementService {

  private readonly base = 'http://localhost:8080/api/achievements';

  constructor(private readonly http: HttpClient) {
  }

  select(): Observable<Array<Achievement>> {
    return this.http.get(this.base).pipe(
      map((rawAchievements: any) => {
        return rawAchievements.airports.map(raw => new Achievement(raw.airport.code, raw.score));
      })
    );
  }

}
