import { Injectable } from '@angular/core';

import { Store } from '../utils/Store';
import { PostMatchId } from './post-match-id';

@Injectable({
  providedIn: 'root'
})
export class PostMatchIdStore extends Store<number> {

  constructor() {
    super();
  }

}
