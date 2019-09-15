import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { interval, Subject } from 'rxjs';
import { delay, switchMap, takeUntil, takeWhile, tap } from 'rxjs/operators';

import { MatchedService } from '../matched.service';
import { MatchedStore } from '../../matched/matched.store';
import { Traveler } from '../../traveler/traveler';

@Component({
  selector: 'app-search-progress',
  templateUrl: './search-progress.component.html',
  styleUrls: ['./search-progress.component.scss']
})
export class SearchProgressComponent implements OnInit, OnDestroy {

  gotMatched = false;

  private readonly destroy$ = new Subject();

  constructor(private matchedService: MatchedService,
              private router: Router,
              private matchedStore: MatchedStore) {
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

        }),
        delay(3000),
        takeUntil(this.destroy$)
      )
      .subscribe((travelers: Array<Traveler>) => {

        this.matchedStore.set(travelers[0]);
        this.router.navigate(['/matched']);
      });
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

}
