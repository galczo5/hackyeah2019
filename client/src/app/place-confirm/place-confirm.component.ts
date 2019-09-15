import { Component, OnInit } from '@angular/core';
import { Traveler } from '../traveler/traveler';
import { UserInfo } from '../shared/profile/user-info';
import { PlaceStore } from './place.store';
import { Router } from '@angular/router';
import { PlaceMatchedStore } from './place-matched.store';
import { MatchedAcceptResult } from '../matched/matched-accept-result';


@Component({
  templateUrl: './place-confirm.component.html',
  styleUrls: ['./place-confirm.component.scss']
})
export class PlaceConfirmComponent implements OnInit {

  matched: UserInfo = new Traveler(6, 'Roman Borsuk', '', 'Polish guy', ['-']);

  meetingPoint;

  constructor(private matchedStore: PlaceStore,
              private placeMatchedStore: PlaceMatchedStore,
              private router: Router) {
  }

  ngOnInit() {

    this.matchedStore
        .select()
        .subscribe((traveler: Traveler) => {
          this.matched = traveler;
        });

    this.placeMatchedStore
        .select()
        .subscribe((matchedAcceptResult: MatchedAcceptResult) => {
          this.meetingPoint = matchedAcceptResult.meetingPoint;
        });
  }

  go() {
    this.router.navigate(['/confirm']);
  }

}
