import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-set-location',
  templateUrl: './set-location.component.html',
  styleUrls: ['./set-location.component.scss']
})
export class SetLocationComponent implements OnInit {

  locations: Array<string> = [
    'WAW - Warsaw Chopin',
    'WMI - Warsaw Modlin',
    'LAX - Los Angeles',
    'DBL - Dublin'
  ];

  constructor() { }

  ngOnInit() {
  }

}
