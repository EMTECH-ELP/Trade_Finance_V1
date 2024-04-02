import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDcComponent } from './view-dc.component';

describe('ViewDcComponent', () => {
  let component: ViewDcComponent;
  let fixture: ComponentFixture<ViewDcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewDcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
