import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatedformComponent } from './createdform.component';

describe('CreatedformComponent', () => {
  let component: CreatedformComponent;
  let fixture: ComponentFixture<CreatedformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatedformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatedformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
