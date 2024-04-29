import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RepaymentdetailsComponent } from './repaymentdetails.component';

describe('RepaymentdetailsComponent', () => {
  let component: RepaymentdetailsComponent;
  let fixture: ComponentFixture<RepaymentdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RepaymentdetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RepaymentdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
