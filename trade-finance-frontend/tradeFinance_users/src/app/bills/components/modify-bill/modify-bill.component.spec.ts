import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyBillComponent } from './modify-bill.component';

describe('ModifyBillComponent', () => {
  let component: ModifyBillComponent;
  let fixture: ComponentFixture<ModifyBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyBillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
