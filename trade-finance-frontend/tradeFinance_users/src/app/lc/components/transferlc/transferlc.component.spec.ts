import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferlcComponent } from './transferlc.component';

describe('TransferlcComponent', () => {
  let component: TransferlcComponent;
  let fixture: ComponentFixture<TransferlcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransferlcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransferlcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
