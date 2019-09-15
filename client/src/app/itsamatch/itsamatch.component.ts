import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { timer } from 'rxjs';

@Component({
  templateUrl: './itsamatch.component.html',
  styleUrls: ['./itsamatch.component.scss']
})
export class ItsamatchComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    timer(5000)
      .subscribe(() => {
        // this.router.navigate(['profile']);
      });
  }

}
