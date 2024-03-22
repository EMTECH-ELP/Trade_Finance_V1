import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCheckersComponent } from './add-checkers.component';

describe('AddCheckersComponent', () => {
  let component: AddCheckersComponent;
  let fixture: ComponentFixture<AddCheckersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCheckersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCheckersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
