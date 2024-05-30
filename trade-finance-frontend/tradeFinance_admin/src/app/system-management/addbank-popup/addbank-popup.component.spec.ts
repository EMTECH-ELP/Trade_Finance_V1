import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddbankPopupComponent } from './addbank-popup.component';

describe('AddbankPopupComponent', () => {
  let component: AddbankPopupComponent;
  let fixture: ComponentFixture<AddbankPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddbankPopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddbankPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
