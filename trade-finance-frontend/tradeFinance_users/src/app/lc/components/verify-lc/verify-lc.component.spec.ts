import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerifyLcComponent } from './verify-lc.component';

describe('VerifyLcComponent', () => {
  let component: VerifyLcComponent;
  let fixture: ComponentFixture<VerifyLcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerifyLcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VerifyLcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
