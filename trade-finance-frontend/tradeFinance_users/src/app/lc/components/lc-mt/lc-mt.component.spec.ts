import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LcMtComponent } from './lc-mt.component';

describe('LcMtComponent', () => {
  let component: LcMtComponent;
  let fixture: ComponentFixture<LcMtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LcMtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LcMtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
