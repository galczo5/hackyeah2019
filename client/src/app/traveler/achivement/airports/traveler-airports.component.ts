import {Component, Input, OnInit} from '@angular/core';
import { AirportAchievementService } from './airport-achievement.service';

@Component({
  selector: 'app-traveler-airports',
  template: `
    <div class="ml-3 mr-3">
        <app-ticket *ngFor="let airport of airports" [code]="airport" class="mr-1"></app-ticket>
    </div>
  `,
  styleUrls: [
    './traveler-airports.component.scss'
  ]
})
export class TravelerAirportsComponent implements OnInit {

  @Input()
  airports: Array<string> = [];

  constructor(private airportAchievementService: AirportAchievementService) {
  }

  ngOnInit(): void {
  }

}
