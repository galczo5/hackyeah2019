import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { WaitingTimeStore } from '../waiting-time-store.service';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.scss']
})
export class CheckInComponent implements OnInit {

  constructor(private readonly waitingTimeStore: WaitingTimeStore,
              private readonly registerService: RegisterService,
              private readonly router: Router) {
  }

  ngOnInit() {
  }

  next(hours: HTMLInputElement, minutes: HTMLInputElement): void {
    this.waitingTimeStore.set({
      hours: parseInt(hours.value),
      minutes: parseInt(minutes.value)
    });

    this.registerService.register();

    this.router.navigate(['search']);
  }

}
