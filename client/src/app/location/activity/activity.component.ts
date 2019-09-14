import {Component, Input, OnInit} from '@angular/core';
import {DomSanitizer, SafeUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.scss']
})
export class ActivityComponent implements OnInit {

  @Input()
  name: string;

  @Input()
  active: boolean = false;

  @Input()
  imageUrl: string;

  constructor(private readonly domSanitizer: DomSanitizer) { }

  ngOnInit() {
  }

  sanitizedUrl(): SafeUrl {
    return this.domSanitizer.bypassSecurityTrustUrl(this.imageUrl);
  }

}
