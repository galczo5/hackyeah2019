import { Component, OnInit } from '@angular/core';
import { MatchedService } from '../matched.service';
import { interval } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-search-progress',
  templateUrl: './search-progress.component.html',
  styleUrls: ['./search-progress.component.scss']
})
export class SearchProgressComponent implements OnInit {

  constructor(private matchedService: MatchedService) {
  }

  ngOnInit() {

    interval(1000)
      .pipe(
        switchMap(() => {
          return this.matchedService.findMatched();
        })
      )
      .subscribe((a) => {
        console.log(a);
      });
  }

}
