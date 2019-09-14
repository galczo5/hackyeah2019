import { Component, Input, OnInit } from '@angular/core';
import { UserInfo } from './user-info';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  @Input()
  userInfo: UserInfo;

  @Input()
  topBar: boolean = false;

  constructor() {
  }

  ngOnInit() {
  }

}
