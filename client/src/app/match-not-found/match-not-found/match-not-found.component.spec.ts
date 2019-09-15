import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchNotFoundComponent } from './match-not-found.component';

describe('MatchNotFoundComponent', () => {
  let component: MatchNotFoundComponent;
  let fixture: ComponentFixture<MatchNotFoundComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatchNotFoundComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchNotFoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
