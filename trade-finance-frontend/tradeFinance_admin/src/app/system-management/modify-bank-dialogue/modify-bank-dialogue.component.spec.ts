import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyBankDialogueComponent } from './modify-bank-dialogue.component';

describe('ModifyBankDialogueComponent', () => {
  let component: ModifyBankDialogueComponent;
  let fixture: ComponentFixture<ModifyBankDialogueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyBankDialogueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyBankDialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
