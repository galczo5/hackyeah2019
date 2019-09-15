import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

import { ActiveTravelerStore } from '../../traveler/active.traveler.store';
import { Traveler } from '../../traveler/traveler';
import { MatchedTravelerStore } from '../../matched/matched-traveler.store';
import { ConfirmMeetingService } from './confirm-meeting.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-confirm-meeting',
  templateUrl: './confirm-meeting.component.html',
  styleUrls: ['./confirm-meeting.component.scss']
})
export class ConfirmMeetingComponent implements OnInit {

  activeTraveler: Traveler;
  matchedTraveler: Traveler;

  constructor(private readonly matchedStore: MatchedTravelerStore,
              private readonly travelerStore: ActiveTravelerStore,
              private readonly router: Router,
              private readonly confirmMeetingService: ConfirmMeetingService,
              private readonly domSanitizer: DomSanitizer) {
  }

  ngOnInit() {
    this.matchedStore.select()
        .subscribe((traveler: Traveler) => {
          console.log(traveler);
          this.matchedTraveler = traveler;
        });

    this.travelerStore.select()
        .subscribe((traveler: Traveler) => {
          console.log(traveler);
          this.activeTraveler = traveler;
        });
  }

  sanitizeAvatar(url: string): SafeUrl {
    return this.domSanitizer.bypassSecurityTrustUrl(url);
  }

  getFirstName(name: string): string {
    return name.split(' ')[0];
  }

  confirm(form: any) {

    if (!form) {
      return;
    }

    this.confirmMeetingService
        .confirm(form.value.password)
        .subscribe(() => {
          this.router.navigate(['/itsamatch']);
        });
  }
}
