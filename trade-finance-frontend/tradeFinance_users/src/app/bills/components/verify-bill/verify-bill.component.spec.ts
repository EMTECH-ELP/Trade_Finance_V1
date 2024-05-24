import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerifyBillComponent } from './verify-bill.component';

describe('VerifyBillComponent', () => {
  let component: VerifyBillComponent;
  let fixture: ComponentFixture<VerifyBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerifyBillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VerifyBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
