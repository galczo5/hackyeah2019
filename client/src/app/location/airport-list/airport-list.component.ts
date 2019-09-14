import {Component, Input, OnInit} from '@angular/core';
import {Airport} from "../airport";

@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.scss']
})
export class AirportListComponent implements OnInit {

  @Input()
  airports: Array<Airport> = [];

  constructor() { }

  ngOnInit() {
  }

}
