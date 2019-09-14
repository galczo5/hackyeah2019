import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelerFriendsComponent } from './traveler-friends.component';

describe('TravelerFriendsComponent', () => {
  let component: TravelerFriendsComponent;
  let fixture: ComponentFixture<TravelerFriendsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelerFriendsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelerFriendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
