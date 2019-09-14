import { Injectable } from '@angular/core';
import {Store} from "../utils/Store";
import {Activity} from "./set-location/Activity";

@Injectable({
  providedIn: 'root'
})
export class SelectedActivitiesStore extends Store<Array<Activity>> {

  constructor() {
    super();
  }
}
