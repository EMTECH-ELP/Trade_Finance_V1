import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvoiceLookupComponent } from './invoice-lookup.component';

describe('InvoiceLookupComponent', () => {
  let component: InvoiceLookupComponent;
  let fixture: ComponentFixture<InvoiceLookupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvoiceLookupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvoiceLookupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
