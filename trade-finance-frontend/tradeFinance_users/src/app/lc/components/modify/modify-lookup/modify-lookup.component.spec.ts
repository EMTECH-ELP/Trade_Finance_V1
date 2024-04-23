import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyLookupComponent } from './modify-lookup.component';

describe('ModifyLookupComponent', () => {
  let component: ModifyLookupComponent;
  let fixture: ComponentFixture<ModifyLookupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyLookupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyLookupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
