import { Component, Input } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';


@Component({
  selector: 'app-foreigner-achievement',
  template: `
	  <div class="achievement-wrapper"
		   [style.width]="size + 'px'"
		   [style.height]="size + 'px'">
        <span *ngIf="image"
			  [style.background-image]="urlSanitized()">
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

	  .achievement-wrapper span {
		  flex-grow: 1;
		  background-repeat: no-repeat;
		  display: block;
		  height: 100%;
		  width: 100%;
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
    console.log(this.image);

    return this.image ? this.domSanitizer.bypassSecurityTrustStyle(this.getSrc()) : 'none';
  }

  getSrc(): string {
    return `url('data:image/svg+xml;utf8;base64,${this.image}')`;
  }

}
