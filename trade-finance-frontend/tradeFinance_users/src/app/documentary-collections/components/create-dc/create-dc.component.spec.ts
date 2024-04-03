import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDcComponent } from './create-dc.component';

describe('CreateDcComponent', () => {
  let component: CreateDcComponent;
  let fixture: ComponentFixture<CreateDcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateDcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateDcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
