import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyInvoiceComponent } from './modify-invoice.component';

describe('ModifyInvoiceComponent', () => {
  let component: ModifyInvoiceComponent;
  let fixture: ComponentFixture<ModifyInvoiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyInvoiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyInvoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
