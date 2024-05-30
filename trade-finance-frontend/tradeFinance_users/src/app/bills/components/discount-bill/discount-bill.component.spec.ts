import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscountBillComponent } from './discount-bill.component';

describe('DiscountBillComponent', () => {
  let component: DiscountBillComponent;
  let fixture: ComponentFixture<DiscountBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscountBillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscountBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
