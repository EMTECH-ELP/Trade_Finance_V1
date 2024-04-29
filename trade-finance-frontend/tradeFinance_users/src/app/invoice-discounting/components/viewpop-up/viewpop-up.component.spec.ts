import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewpopUpComponent } from './viewpop-up.component';

describe('ViewpopUpComponent', () => {
  let component: ViewpopUpComponent;
  let fixture: ComponentFixture<ViewpopUpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewpopUpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewpopUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
