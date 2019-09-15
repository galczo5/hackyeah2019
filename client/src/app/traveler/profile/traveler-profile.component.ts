import { Component, OnInit } from '@angular/core';

import { ActiveTravelerStore } from '../active.traveler.store';
import { Traveler } from '../traveler';
import { LoginService } from '../../login/login.service';

@Component({
  templateUrl: './traveler-profile.component.html',
  styleUrls: ['./traveler-profile.component.scss']
})
export class TravelerProfileComponent implements OnInit {

  traveler: Traveler;

  airports: Array<string> = [
    'WAW',
    'WMI',
    'LAX',
    'LON'
  ];

  constructor(private activeTravelerStore: ActiveTravelerStore,
              private loginService: LoginService) {

  }

  ngOnInit() {

    this.loginService.selectCurrentUser();

    this.activeTravelerStore
        .select()
        .subscribe((traveler: Traveler) => {
          this.traveler = traveler;
        });
  }

}
