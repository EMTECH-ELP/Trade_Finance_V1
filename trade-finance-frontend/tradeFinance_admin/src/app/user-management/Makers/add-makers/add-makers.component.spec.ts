import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMakersComponent } from './add-makers.component';

describe('AddMakersComponent', () => {
  let component: AddMakersComponent;
  let fixture: ComponentFixture<AddMakersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMakersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMakersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
