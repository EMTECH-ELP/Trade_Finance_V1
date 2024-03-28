import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBgComponent } from './create-bg.component';

describe('CreateBgComponent', () => {
  let component: CreateBgComponent;
  let fixture: ComponentFixture<CreateBgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateBgComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
