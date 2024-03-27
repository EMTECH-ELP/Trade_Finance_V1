import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteLcComponent } from './delete-lc.component';

describe('DeleteLcComponent', () => {
  let component: DeleteLcComponent;
  let fixture: ComponentFixture<DeleteLcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteLcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteLcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});


