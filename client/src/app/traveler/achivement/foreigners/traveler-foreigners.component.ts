import { Component, OnInit } from '@angular/core';
import { AirportAchievementService } from '../airports/airport-achievement.service';
import { ForeignersAchievementService } from './foreigners-achievement.service';

@Component({
  selector: 'app-traveler-foreigners',
  template: `

	  <ul class="m-1 p-0">
		  <li *ngFor="let foreigner of foreigners" class="profile-achivement m-1"></li>
	  </ul>
  `,
  styleUrls: [
    './traveler-foreigners.component.scss'
  ]
})
export class TravelerForeignersComponent implements OnInit {

  private foreigners = [];

  constructor(private foreignersAchievementService: ForeignersAchievementService) {
  }

  ngOnInit(): void {
    this.foreignersAchievementService
        .select()
        .subscribe((foreigners) => {
          this.foreigners = foreigners;
        });
  }

}
