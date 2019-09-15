import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { switchMap } from 'rxjs/operators';

import { MatchedRequestIdStore } from '../../matched/matched.request-id.store';
import { NeedRequestId } from '../../check-in/need-request-id';

export interface MatchPasswordRequest {
  password: string;
  match: number;
}

@Injectable()
export class ConfirmMeetingService {

  private readonly url = 'http://localhost:8080/api/needs/match';

  constructor(private httpClient: HttpClient,
              private matchedRequestIdStore: MatchedRequestIdStore) {
  }

  confirm(password: string) {

    return this.matchedRequestIdStore
               .select()
               .pipe(
                 switchMap((id: NeedRequestId) => {

                   let request = {
                     password,
                     match: id.id
                   } as MatchPasswordRequest;

                   return this.httpClient.put(this.url, request);
                 })
               );


  }

}
