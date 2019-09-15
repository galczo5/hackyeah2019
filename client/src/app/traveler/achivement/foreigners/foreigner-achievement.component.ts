import {Component, Input} from "@angular/core";
import {DomSanitizer, SafeUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-foreigner-achievement',
  template: `
    <div class="achievement-wrapper"
         [style.width]="size + 'px'"
         [style.height]="size + 'px'"
         [style.background-image]="urlSanitized()">
        <span *ngIf="!image">
            {{text}}
        </span>
    </div>
  `,
  styles: [`
    .achievement-wrapper {
        background: #F3F6F7;
        display: inline-flex;
        align-items: center;
        justify-content: center;
        border-radius: 50%;
        color: #C4C1C1;
        font-weight: 500;
        font-size: 16px;
    }
  `]
})
export class ForeignerAchievementComponent {

  @Input()
  text: string;

  @Input()
  image: string;

  @Input()
  size: number;

  constructor(private readonly domSanitizer: DomSanitizer) {

  }

  urlSanitized(): SafeUrl {
    return  this.image ? this.domSanitizer.bypassSecurityTrustStyle(this.getSrc()) : 'none';
  }

  getSrc(): string {
    return `url('data:image/svg+xml;utf8;base64,${this.image}')`
  }

}
