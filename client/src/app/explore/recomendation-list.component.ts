import { Component, OnInit } from '@angular/core';
import { RecomendationService } from './recomendation.service';

@Component({
  selector: 'recomendation-list',
  styleUrls: [
    './recomendation-list.component.scss'
  ],
  templateUrl: './recomendation-list.component.html',
  host: {
    '[class.p3]': 'true'
  }
})
export class RecomendationListComponent implements OnInit {

  recos = [];

  constructor(private recomendationService: RecomendationService) {
  }

  ngOnInit(): void {
    this.recomendationService
        .select()
        .subscribe(r => this.recos = r);
  }
}
