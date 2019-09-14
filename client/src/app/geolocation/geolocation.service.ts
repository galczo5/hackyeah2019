import {Inject, Injectable, InjectionToken, Optional} from '@angular/core';
import {Observable, of, Subject} from 'rxjs'
import { Location } from "./Location";

export const FAKE_LOCATION: InjectionToken<boolean> = new InjectionToken<boolean>('fake location');

@Injectable({
  providedIn: 'root'
})
export class GeolocationService {

  constructor(@Optional() @Inject(FAKE_LOCATION) private readonly fakeLocation: boolean) {}

  getLocation(): Observable<Location> {
    const location$: Subject<Location> = new Subject<Location>();

    if (this.fakeLocation) {
      return of(new Location(20.967898, 52.167449)); // Warsaw Airport
    }

    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position: Position) => {
        let coords = position.coords;
        location$.next(new Location(coords.longitude, coords.latitude));
        location$.complete();
      });
      return location$.asObservable();
    }

    throw new Error('Geolocation is not supported by this browser');
  }

  fetchPlace(): void {
    // TODO: Fetch Airport from api
  }
}
