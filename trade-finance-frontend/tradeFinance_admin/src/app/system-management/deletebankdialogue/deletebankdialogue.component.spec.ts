import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletebankdialogueComponent } from './deletebankdialogue.component';

describe('DeletebankdialogueComponent', () => {
  let component: DeletebankdialogueComponent;
  let fixture: ComponentFixture<DeletebankdialogueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletebankdialogueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletebankdialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
