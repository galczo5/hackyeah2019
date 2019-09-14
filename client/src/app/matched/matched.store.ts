import { Injectable } from '@angular/core';

import { Traveler } from '../traveler/traveler';

import { Store } from '../utils/Store';

@Injectable({
  providedIn: 'root'
})
export class MatchedStore extends Store<Traveler> {

  constructor() {
    super();
  }

}
