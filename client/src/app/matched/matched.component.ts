import { Component, OnInit } from '@angular/core';
import { Traveler } from '../traveler/traveler';
import { UserInfo } from '../shared/profile/user-info';
import { MatchedTravelerStore } from './matched-traveler.store';
import { MatchedService } from './matched.service';


@Component({
  templateUrl: './matched.component.html',
  styleUrls: ['./matched.component.scss']
})
export class MatchedComponent implements OnInit {

  matched: UserInfo = new Traveler(6, 'Roman Borsuk', '', 'Polish guy', ['-']);

  constructor(private matchedStore: MatchedTravelerStore,
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
        .subscribe(() => {

        });
  }

}
