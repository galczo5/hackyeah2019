import { Injectable } from '@angular/core';

import { Store } from '../utils/Store';
import { Airport } from './airport';

@Injectable({
  providedIn: 'root'
})
export class SelectedAirportStore extends Store<Airport> {

  constructor() {
    super();
  }
}
