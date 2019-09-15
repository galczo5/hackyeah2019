import { Injectable } from '@angular/core';

import { Store } from '../utils/Store';
import { NeedRequestId } from '../check-in/need-request-id';

@Injectable({
  providedIn: 'root'
})
export class MatchedRequestIdStore extends Store<NeedRequestId> {

  constructor() {
    super();
  }

}
