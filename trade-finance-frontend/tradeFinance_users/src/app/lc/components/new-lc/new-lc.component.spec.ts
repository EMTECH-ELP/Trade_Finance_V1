import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewLcComponent } from './new-lc.component';

describe('NewLcComponent', () => {
  let component: NewLcComponent;
  let fixture: ComponentFixture<NewLcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewLcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewLcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
