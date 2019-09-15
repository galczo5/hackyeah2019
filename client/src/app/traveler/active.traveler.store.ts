import { Injectable } from '@angular/core';

import { Traveler } from './traveler';
import { Store } from '../utils/Store';

const KEY = 'active-traveler';

@Injectable()
export class ActiveTravelerStore extends Store<Traveler> {
  constructor() {
    super();
    let item = localStorage.getItem(KEY);
    if (item) {
      super.set(JSON.parse(item));
    }
  }


  set(newValue: Traveler): void {
    localStorage.setItem(KEY, JSON.stringify(newValue));
    super.set(newValue);
  }
}
