import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMakersComponent } from './view-makers.component';

describe('ViewMakersComponent', () => {
  let component: ViewMakersComponent;
  let fixture: ComponentFixture<ViewMakersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMakersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMakersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
