import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchProgressComponent } from './search-progress.component';

describe('SearchProgressComponent', () => {
  let component: SearchProgressComponent;
  let fixture: ComponentFixture<SearchProgressComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchProgressComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchProgressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
