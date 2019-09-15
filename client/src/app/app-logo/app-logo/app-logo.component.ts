import { Component, OnInit } from '@angular/core';
import {timer} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-app-logo',
  templateUrl: './app-logo.component.html',
  styleUrls: ['./app-logo.component.scss']
})
export class AppLogoComponent implements OnInit {

  constructor(private readonly router : Router) { }

  ngOnInit() {
    timer(1500)
      .subscribe(() => {
        this.router.navigateByUrl('/login')
      });
  }

}
