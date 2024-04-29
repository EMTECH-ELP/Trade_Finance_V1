import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecoveryBillComponent } from './recovery-bill.component';

describe('RecoveryBillComponent', () => {
  let component: RecoveryBillComponent;
  let fixture: ComponentFixture<RecoveryBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecoveryBillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecoveryBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
