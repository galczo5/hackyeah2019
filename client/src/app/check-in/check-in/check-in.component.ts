import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.scss']
})
export class CheckInComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  next(hours: HTMLInputElement, minutes: HTMLInputElement): void {
    console.log(hours.value, minutes.value);
  }

}
