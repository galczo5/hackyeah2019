import { Injectable } from '@angular/core';

import { Store } from '../utils/Store';
import { WaitingTime } from './WaitingTime';

@Injectable({
  providedIn: 'root'
})
export class WaitingTimeStore extends Store<WaitingTime> {

  constructor() {
    super();
  }
}
