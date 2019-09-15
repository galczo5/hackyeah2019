import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { switchMap } from 'rxjs/operators';

import { MatchedRequestIdStore } from '../../matched/matched.request-id.store';
import { NeedRequestId } from '../../check-in/need-request-id';
import { PostMatchIdStore } from '../../matched/post-match-id.store';

export interface MatchPasswordRequest {
  password: string;
  match: number;
}

@Injectable()
export class ConfirmMeetingService {

  private readonly url = 'http://localhost:8080/api/needs/match';

  constructor(private httpClient: HttpClient,
              private postMatchIdStore: PostMatchIdStore) {
  }

  confirm(password: string) {

    return this.postMatchIdStore
               .select()
               .pipe(
                 switchMap((id: any) => {

                   let request = {
                     password,
                     match: id.id
                   } as MatchPasswordRequest;

                   return this.httpClient.put(this.url, request);
                 })
               );


  }

}
