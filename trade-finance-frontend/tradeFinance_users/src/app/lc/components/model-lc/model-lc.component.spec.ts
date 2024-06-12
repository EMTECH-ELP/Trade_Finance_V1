import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelLcComponent } from './model-lc.component';

describe('ModelLcComponent', () => {
  let component: ModelLcComponent;
  let fixture: ComponentFixture<ModelLcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModelLcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModelLcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
