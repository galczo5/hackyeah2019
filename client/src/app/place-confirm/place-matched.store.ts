import { Injectable } from '@angular/core';

import { Store } from '../utils/Store';
import { MatchedAcceptResult } from '../matched/matched-accept-result';


@Injectable({
  providedIn: 'root'
})
export class PlaceMatchedStore extends Store<MatchedAcceptResult> {

  constructor() {
    super();
  }
}
