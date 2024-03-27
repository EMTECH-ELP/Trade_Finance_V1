import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteDcComponent } from './delete-dc.component';

describe('DeleteDcComponent', () => {
  let component: DeleteDcComponent;
  let fixture: ComponentFixture<DeleteDcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteDcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteDcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
