import { Component, Input, OnInit } from '@angular/core';
import { AirportAchievementService } from './airport-achievement.service';
import { Achievement } from '../achivement';

@Component({
  selector: 'app-traveler-airports',
  template: `
	  <div class="ml-3 mr-3">
		  <app-ticket *ngFor="let airport of airports"
					  [airport]="airport"
					  class="mr-1">
		  </app-ticket>
	  </div>
  `,
  styleUrls: [
    './traveler-airports.component.scss'
  ]
})
export class TravelerAirportsComponent implements OnInit {

  airports: Array<Achievement> = [];

  constructor(private airportAchievementService: AirportAchievementService) {
  }

  ngOnInit(): void {
    this.airportAchievementService
        .select()
        .subscribe((airports: Array<Achievement>) => {
          this.airports = airports;
          console.log(airports);
        });
  }

}
