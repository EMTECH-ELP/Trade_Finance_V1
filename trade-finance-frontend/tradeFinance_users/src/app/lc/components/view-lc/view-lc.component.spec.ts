import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewLcComponent } from './view-lc.component';

describe('ViewLcComponent', () => {
  let component: ViewLcComponent;
  let fixture: ComponentFixture<ViewLcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewLcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewLcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
