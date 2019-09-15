import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, zip } from 'rxjs';
import { switchMap } from 'rxjs/operators';

import { NeedRequestIdStore } from '../check-in/need-request-id.store';
import { MatchedRequestIdStore } from './matched.request-id.store';
import { MatchedAcceptResult } from './matched-accept-result';

export interface MatchedRequest {
  requestId: number;
  matchRequestId: number;
}

@Injectable()
export class MatchedService {

  private readonly url = 'http://localhost:8080/api/needs/match';

  constructor(private httpClient: HttpClient,
              private matchedRequestIdStore: MatchedRequestIdStore,
              private needRequestIdStore: NeedRequestIdStore) {
  }

  confirm(): Observable<MatchedAcceptResult> {
    return zip(
      this.matchedRequestIdStore.select(),
      this.needRequestIdStore.select()
    )
      .pipe(
        switchMap((arr: any) => {

          const requestId = arr[1],
            matchRequestId = arr[0];

          let request: MatchedRequest = {
            requestId,
            matchRequestId
          };

          return this.httpClient
                     .post(this.url, request) as Observable<MatchedAcceptResult>;
        })
      );

  }

}
