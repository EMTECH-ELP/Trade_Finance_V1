import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCheckersComponent } from './view-checkers.component';

describe('ViewCheckersComponent', () => {
  let component: ViewCheckersComponent;
  let fixture: ComponentFixture<ViewCheckersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCheckersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCheckersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
