import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Achievement } from '../achivement';


@Injectable()
export class ForeignersAchievementService {

  private readonly base = 'http://localhost:8080/api/achievements';

  constructor(private readonly http: HttpClient) {
  }

  select(): Observable<Array<Achievement>> {
    return this.http
               .get(this.base)
               .pipe(
                 map((rawAchievements: any) => {
                   return rawAchievements.countries.map(raw => new Achievement(raw.avatar, raw.score));
                 })
               );
  }

}
