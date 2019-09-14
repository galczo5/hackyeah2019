import { Component, OnInit } from '@angular/core';
import {WaitingTimeStore} from "../waiting-time-store.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.scss']
})
export class CheckInComponent implements OnInit {

  constructor(private readonly waitingTimeStore: WaitingTimeStore,
              private readonly router: Router) {

  }

  ngOnInit() {
  }

  next(hours: HTMLInputElement, minutes: HTMLInputElement): void {
    this.waitingTimeStore.set({
      hours: parseInt(hours.value),
      minutes: parseInt(minutes.value)
    });

    this.router.navigate(['search'])
  }

}
