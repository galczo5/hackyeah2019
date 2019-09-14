import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Airport } from './airport';

@Injectable({
  providedIn: 'root'
})
export class AirportsService {

  private readonly base = 'http://localhost:8080/api/airport';

  constructor(private readonly http: HttpClient) {
  }

  getAirports(): Observable<Array<Airport>> {
    return this.http.get<Array<Airport>>(this.base);
  }
}
