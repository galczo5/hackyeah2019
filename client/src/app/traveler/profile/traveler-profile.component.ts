import { Component, OnInit } from '@angular/core';
import { ActiveTravelerStore } from '../active.traveler.store';
import { Traveler } from '../traveler';

@Component({
  templateUrl: './traveler-profile.component.html',
  styleUrls: ['./traveler-profile.component.scss']
})
export class TravelerProfileComponent implements OnInit {

  traveler: Traveler;

  constructor(private activeTravelerStore: ActiveTravelerStore) {
  }

  ngOnInit() {
    this.activeTravelerStore
        .select()
        .subscribe((traveler: Traveler) => {
          this.traveler = traveler;
        });
  }

}
