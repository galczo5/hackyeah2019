import {Component, OnInit} from '@angular/core';
import {Event, NavigationEnd, Router} from "@angular/router";
import {filter, map} from "rxjs/operators";

@Component({
  selector: 'navigation',
  templateUrl: './navigation.component.html',
  styleUrls: [
    './navigation.component.scss'
  ]
})
export class NavigationComponent implements OnInit {

  url: string;

  constructor(private readonly router: Router) {

  }

  ngOnInit(): void {
    this.router.events
      .pipe(
        filter(e => e instanceof NavigationEnd),
        map(e => e as NavigationEnd)
      )
      .subscribe((e: NavigationEnd) => {
        this.url = e.url;
      })
  }
}
