import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Achievement } from '../achivement';

@Injectable()
export class ForeignersAchievementService {

  select(): Observable<Array<Achievement>> {

    const foreigners = [];

    for (let i = 0; i < 25; i += 1) {
      foreigners.push(new Achievement('', !!(Math.random() * 2)));
    }

    return of(foreigners);
  }

}
