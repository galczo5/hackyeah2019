import { ChangeDetectorRef, Component, OnInit } from '@angular/core';

import { ForeignersAchievementService } from './foreigners-achievement.service';
import { Achievement } from '../achivement';

@Component({
  selector: 'app-traveler-foreigners',
  template: `
    <div class="ml-3 mr-3">
        <app-foreigner-achievement
                *ngFor="let fore of foreigners"
                class="mr-1 mb-1"
                [size]="75"
                text="PL">
        </app-foreigner-achievement>
    </div>
  `,
  styleUrls: [
    './traveler-foreigners.component.scss'
  ]
})
export class TravelerForeignersComponent implements OnInit {

  private foreigners = [];

  constructor(private cd: ChangeDetectorRef,
              private foreignersAchievementService: ForeignersAchievementService) {
  }

  ngOnInit(): void {
    this.foreignersAchievementService
        .select()
        .subscribe((foreigners: Array<Achievement>) => {
          this.foreigners = foreigners;
          console.log(foreigners)
          this.cd.detectChanges();
        });
  }

}
