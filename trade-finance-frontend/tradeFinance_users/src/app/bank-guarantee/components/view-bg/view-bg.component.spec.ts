import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewBgComponent } from './view-bg.component';

describe('ViewBgComponent', () => {
  let component: ViewBgComponent;
  let fixture: ComponentFixture<ViewBgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewBgComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewBgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
