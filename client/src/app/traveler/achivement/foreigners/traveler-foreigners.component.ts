import { Component, OnInit } from '@angular/core';
import { AirportAchievementService } from '../airports/airport-achievement.service';
import { ForeignersAchievementService } from './foreigners-achievement.service';

@Component({
  selector: 'app-traveler-foreigners',
  template: `
    <div class="ml-3 mr-3">
        <app-foreigner-achievement class="mr-1 mb-1" [size]="75" text="PL"></app-foreigner-achievement>
        <app-foreigner-achievement class="mr-1 mb-1" [size]="75" text="PL"></app-foreigner-achievement>
        <app-foreigner-achievement class="mr-1 mb-1" [size]="75" text="PL"></app-foreigner-achievement>
        <app-foreigner-achievement class="mr-1 mb-1" [size]="75" text="PL"></app-foreigner-achievement>
    </div>
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
