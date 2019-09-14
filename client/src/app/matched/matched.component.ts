import { Component, OnInit } from '@angular/core';
import { Traveler } from '../traveler/traveler';
import { UserInfo } from '../shared/profile/user-info';


@Component({
  templateUrl: './matched.component.html',
  styleUrls: ['./matched.component.scss']
})
export class MatchedComponent implements OnInit {

  matched: UserInfo;

  constructor() {
  }

  ngOnInit() {
    this.matched = new Traveler(1, 'Roman Borsuk', '', 'Poland', ['Suahili', 'Hawaiian']);
  }

}
