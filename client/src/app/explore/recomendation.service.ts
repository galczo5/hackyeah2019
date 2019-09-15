import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { Recomendation } from './recomendation';
import { HttpClient } from '@angular/common/http';
import { SelectedAirportStore } from '../location/selected-airport.store';

@Injectable()
export class RecomendationService {

  private readonly base = 'http://localhost:8080/api/stories';

  constructor(private readonly http: HttpClient, private readonly airportStore: SelectedAirportStore) {
  }

  select(): Observable<Array<Recomendation>> {
    return this.airportStore.select()
               .pipe(switchMap(
                 airport => {
                   return this.http.get<Array<any>>(this.base + '/' + airport.id).pipe(
                     map((raw: Array<any>) => {
                       return raw.map(r => {
                         return new Recomendation(r.title, r.description, r.numberOfLikes, r.author.avatar);
                       });
                     })
                   );
                 }
               ));
  }

}
