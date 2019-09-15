import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';

import { Airport } from '../airport';
import { SelectedAirportStore } from '../selected-airport.store';

@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.scss']
})
export class AirportListComponent implements OnInit, OnChanges {

  @Input()
  airports: Array<Airport> = [];

  selectedAirport: Airport;

  constructor(private selectedAirportStore: SelectedAirportStore) {
  }

  ngOnInit() {
    this.selectedAirportStore.select()
      .subscribe((airport: Airport) => {
        this.setSelectedAirport(airport.id);
      })
  }

  ngOnChanges(changes: SimpleChanges): void {

    if (changes.airports && this.selectedAirport) {
      this.setSelectedAirport(this.selectedAirport.id);
    }

  }

  selectAirport(airport: Airport): void {
    this.selectedAirport = airport;
    this.selectedAirportStore.set(airport);
  }

  setSelectedAirport(id: number): void {
    let airport = this.airports.find(a => a.id === id);
    this.selectedAirport = airport;
  }

}
