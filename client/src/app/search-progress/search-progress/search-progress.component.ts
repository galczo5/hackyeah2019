import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { interval, Subject } from 'rxjs';
import { delay, filter, switchMap, takeUntil, takeWhile, tap } from 'rxjs/operators';

import { MatchedDto, MatchedService } from '../matched.service';
import { Traveler } from '../../traveler/traveler';
import { MatchedTravelerStore } from '../../matched/matched-traveler.store';
import { MatchedRequestIdStore } from '../../matched/matched.request-id.store';

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
              private matchedRequestIdStore: MatchedRequestIdStore,
              private matchedStore: MatchedTravelerStore) {
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
        delay(0),
        filter((matchedDtos: Array<MatchedDto>) => {
          return matchedDtos.length > 0;
        }),
        takeUntil(this.destroy$)
      )
      .subscribe((matchedDtos: Array<MatchedDto>) => {

        this.matchedRequestIdStore.set(matchedDtos[0].matchRequestId);

        this.matchedStore.set(matchedDtos[0].traveler);
        this.router.navigate(['/matched']);
      });
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

}
