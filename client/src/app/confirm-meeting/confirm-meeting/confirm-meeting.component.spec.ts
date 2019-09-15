import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmMeetingComponent } from './confirm-meeting.component';

describe('ConfirmMeetingComponent', () => {
  let component: ConfirmMeetingComponent;
  let fixture: ComponentFixture<ConfirmMeetingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfirmMeetingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmMeetingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
