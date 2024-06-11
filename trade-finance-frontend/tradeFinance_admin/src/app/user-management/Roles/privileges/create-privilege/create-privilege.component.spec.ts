import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePrivilegeComponent } from './create-privilege.component';

describe('CreatePrivilegeComponent', () => {
  let component: CreatePrivilegeComponent;
  let fixture: ComponentFixture<CreatePrivilegeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatePrivilegeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatePrivilegeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
