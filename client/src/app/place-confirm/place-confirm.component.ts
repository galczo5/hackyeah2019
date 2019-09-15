import { Component, OnInit } from '@angular/core';
import { Traveler } from '../traveler/traveler';
import { UserInfo } from '../shared/profile/user-info';
import { PlaceStore } from './place.store';
import { Router } from '@angular/router';


@Component({
  templateUrl: './place-confirm.component.html',
  styleUrls: ['./place-confirm.component.scss']
})
export class PlaceConfirmComponent implements OnInit {

  matched: UserInfo = new Traveler(6, 'Roman Borsuk', '', 'Polish guy', ['-']);

  constructor(private matchedStore: PlaceStore,
              private router: Router) {
  }

  ngOnInit() {

    this.matchedStore
        .select()
        .subscribe((traveler: Traveler) => {
          this.matched = traveler;
        });
  }

  go() {
    this.router.navigate(['/confirm']);
  }

}
