import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ConfirmMeetingService {

  private readonly url = 'http://localhost:8080/api/needs/match';

  constructor(private httpClient: HttpClient) {}

  confirm() {
    this.httpClient.put(this.url, {});
  }

}
