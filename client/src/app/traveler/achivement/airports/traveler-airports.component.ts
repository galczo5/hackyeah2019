import { Component, OnInit } from '@angular/core';
import { AirportAchievementService } from './airport-achievement.service';

@Component({
  selector: 'app-traveler-airports',
  template: `

	  <ul class="m-1 p-0">
		  <li *ngFor="let airport of airports" class="profile-achivement m-1"></li>
	  </ul>
  `,
  styleUrls: [
    './traveler-airports.component.scss'
  ]
})
export class TravelerAirportsComponent implements OnInit {

  private airports = [];

  constructor(private airportAchievementService: AirportAchievementService) {
  }

  ngOnInit(): void {
    this.airportAchievementService
        .select()
        .subscribe((airports) => {
          this.airports = airports;
        });
  }

}
