import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Traveler } from '../traveler/traveler';
import { UserInfo } from '../shared/profile/user-info';
import { MatchedTravelerStore } from './matched-traveler.store';
import { MatchedService } from './matched.service';
import { PlaceMatchedStore } from '../place-confirm/place-matched.store';
import { MatchedAcceptResult } from './matched-accept-result';


@Component({
  templateUrl: './matched.component.html',
  styleUrls: ['./matched.component.scss']
})
export class MatchedComponent implements OnInit {

  matched: UserInfo = new Traveler(6, 'Roman Borsuk', '', 'Polish guy', ['-']);

  constructor(private matchedStore: MatchedTravelerStore,
              private router: Router,
              private placeMatchedStore: PlaceMatchedStore,
              private matchedService: MatchedService) {
  }

  ngOnInit() {

    this.matchedStore
        .select()
        .subscribe((traveler: Traveler) => {
          this.matched = traveler;
        });
  }

  confirmMatched(): void {
    this.matchedService
        .confirm()
        .subscribe((result: MatchedAcceptResult) => {

          this.placeMatchedStore.set(result);

          this.router.navigate(['/place-confirm']);
        });
  }

}
