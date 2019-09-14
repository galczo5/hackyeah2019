import { Component, Input, OnInit } from '@angular/core';

import { Recomendation } from '../recomendation';

@Component({
  selector: 'recomendation-card',
  styleUrls: [
    `./recomendation-card.component.scss`
  ],
  templateUrl: `./recomendation-card.component.html`
})
export class RecomendationCardComponent implements OnInit {

  @Input()
  recomendation: Recomendation;

  opened = false;

  ngOnInit(): void {
  }

  toggle(): void {
    this.opened = !this.opened;
  }

}
