import { Injectable } from '@angular/core';
import { Observable, ReplaySubject } from 'rxjs';
import { Traveler } from './traveler';
import {Store} from "../utils/Store";

@Injectable()
export class ActiveTravelerStore extends Store<Traveler> {
  constructor() {
    super();
  }
}
