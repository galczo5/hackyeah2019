import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'colored-button',
  template: `    
      <ng-content></ng-content>
  `,
  host: {
    '[class.colored-button]': 'false'
  }
  // styleUrls: [``]
})
export class ColoredButtonComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

}
