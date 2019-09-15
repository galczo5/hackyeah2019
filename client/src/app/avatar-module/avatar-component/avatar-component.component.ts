import {Component, Input, OnInit} from '@angular/core';
import {DomSanitizer, SafeUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-avatar-component',
  templateUrl: './avatar-component.component.html',
  styleUrls: ['./avatar-component.component.scss']
})
export class AvatarComponentComponent implements OnInit {

  @Input()
  url: string;

  @Input()
  size: number;

  @Input()
  background: string = 'none';

  constructor(private readonly domSanitizer: DomSanitizer) { }

  ngOnInit() {
  }

  urlSanitized(): SafeUrl {
    return this.domSanitizer.bypassSecurityTrustStyle(this.getSrc());
  }

  getSrc(): string {
    return `url('data:image/svg+xml;utf8;base64,${this.url}')`;
  }

}
