import { Injectable } from '@angular/core';
import { Store } from '../utils/Store';
import { NeedRequestId } from './need-request-id';

@Injectable({
  providedIn: 'root'
})
export class NeedRequestIdStore extends Store<NeedRequestId> {

  constructor() {
    super();
  }
}
