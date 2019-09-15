import { Component, OnInit } from '@angular/core';
import { Traveler } from '../traveler/traveler';
import { UserInfo } from '../shared/profile/user-info';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';
import { Router } from '@angular/router';


@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private readonly loginUrl = 'http://localhost:8080/api/security/login/';

  constructor(private loginService: LoginService,
              private router: Router) {
  }

  ngOnInit() {
  }

  onSubmit(f: NgForm) {

    const username = f.value.username,
      password = f.value.password;

    this.loginService
        .login(username, password)
        .subscribe(() => {
          this.router.navigate(['/location']);
        });
  }

}
