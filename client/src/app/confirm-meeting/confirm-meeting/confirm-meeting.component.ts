import { Component, OnInit } from '@angular/core';
import {MatchedStore} from "../../matched/matched.store";
import {ActiveTravelerStore} from "../../traveler/active.traveler.store";
import {Traveler} from "../../traveler/traveler";
import {DomSanitizer, SafeUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-confirm-meeting',
  templateUrl: './confirm-meeting.component.html',
  styleUrls: ['./confirm-meeting.component.scss']
})
export class ConfirmMeetingComponent implements OnInit {

  activeTraveler: Traveler;
  matchedTraveler: Traveler;

  constructor(private readonly matchedStore: MatchedStore,
              private readonly travelerStore: ActiveTravelerStore,
              private readonly domSanitizer: DomSanitizer) { }

  ngOnInit() {
    this.matchedStore.select()
      .subscribe((traveler: Traveler) => {
        console.log(traveler)
        this.matchedTraveler = traveler;
      });

    this.travelerStore.select()
      .subscribe((traveler: Traveler) => {
        console.log(traveler)
        this.activeTraveler = traveler;
      });
  }

  sanitizeAvatar(url: string): SafeUrl {
    return this.domSanitizer.bypassSecurityTrustUrl(url);
  }

  getFirstName(name: string): string {
    return name.split(' ')[0];
  }
}
