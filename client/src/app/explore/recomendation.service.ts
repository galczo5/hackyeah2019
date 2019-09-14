import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Recomendation } from './recomendation';

@Injectable()
export class RecomendationService {

  select(): Observable<Array<Recomendation>> {

    const recos = [];

    for (let i = 0; i < 10; i += 1) {
      recos.push(new Recomendation('Great Recomendartion', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 20, ''));
    }

    return of(recos);
  }

}
