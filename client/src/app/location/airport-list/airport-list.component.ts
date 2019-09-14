import { Component, Input, OnInit } from '@angular/core';

import { Airport } from '../airport';
import { SelectedAirportStore } from '../selected-airport.store';

@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.scss']
})
export class AirportListComponent implements OnInit {

  @Input()
  airports: Array<Airport> = [];

  selectedAirport: Airport;

  constructor(private selectedAirportStore: SelectedAirportStore) {
  }

  ngOnInit() {
  }

  selectAirport(airport: Airport): void {
    this.selectedAirport = airport;
    this.selectedAirportStore.set(airport);
  }

}
