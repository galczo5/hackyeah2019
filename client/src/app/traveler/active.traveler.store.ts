import { Injectable } from '@angular/core';
import { Observable, ReplaySubject } from 'rxjs';
import { Traveler } from './traveler';

@Injectable()
export class ActiveTravelerStore {

  private traveler$ = new ReplaySubject<Traveler>(1);

  select(): Observable<Traveler> {
    return this.traveler$.asObservable();
  }

  set(traveler: Traveler): void {
    this.traveler$.next(traveler);
  }

}
