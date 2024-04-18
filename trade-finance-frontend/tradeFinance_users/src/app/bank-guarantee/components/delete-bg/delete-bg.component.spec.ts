import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteBgComponent } from './delete-bg.component';

describe('DeleteBgComponent', () => {
  let component: DeleteBgComponent;
  let fixture: ComponentFixture<DeleteBgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteBgComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteBgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
