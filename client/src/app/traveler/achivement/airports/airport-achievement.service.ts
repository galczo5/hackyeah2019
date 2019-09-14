import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Achievement } from '../achivement';

@Injectable()
export class AirportAchievementService {

  select(): Observable<Array<Achievement>> {

    const airports = [];

    for (let i = 0; i < 50; i += 1) {
      airports.push(new Achievement('', !!(Math.random() * 2)));
    }

    return of(airports);
  }

}
