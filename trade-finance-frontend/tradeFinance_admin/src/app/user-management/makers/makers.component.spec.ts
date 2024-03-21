import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakersComponent } from './makers.component';

describe('MakersComponent', () => {
  let component: MakersComponent;
  let fixture: ComponentFixture<MakersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MakersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MakersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
