import { Component, OnInit } from '@angular/core';
import { MatchedService } from '../matched.service';
import { interval } from 'rxjs';
import { map, switchMap, takeWhile, tap } from 'rxjs/operators';

@Component({
  selector: 'app-search-progress',
  templateUrl: './search-progress.component.html',
  styleUrls: ['./search-progress.component.scss']
})
export class SearchProgressComponent implements OnInit {

  gotMatched = false;

  constructor(private matchedService: MatchedService) {
  }

  ngOnInit() {

    interval(1000)
      .pipe(
        takeWhile(() => !this.gotMatched),
        switchMap(() => {
          return this.matchedService.findMatched();
        }),
        tap((matchedPpl: Array<any>) => {

          if (matchedPpl.length > 0) {
            this.gotMatched = true;
          }

        })
      )
      .subscribe((matchedPpl) => {
        console.log(matchedPpl);
      });
  }

}
