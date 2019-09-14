import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'colored-button',
  template: `

	  <button mat-raised-button >
        <ng-content></ng-content>
	  </button>
    
  `,
  host: {
    '[class.colored-button]': 'true'
  }
  // styleUrls: [``]
})
export class ColoredButtonComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

}
