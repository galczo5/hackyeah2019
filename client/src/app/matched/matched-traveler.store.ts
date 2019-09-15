import { Injectable } from '@angular/core';

import { Traveler } from '../traveler/traveler';

import { Store } from '../utils/Store';

@Injectable({
  providedIn: 'root'
})
export class MatchedTravelerStore extends Store<Traveler> {

  constructor() {
    super();
  }

}
