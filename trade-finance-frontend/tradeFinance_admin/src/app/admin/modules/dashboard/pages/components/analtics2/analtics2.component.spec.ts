import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Analtics2Component } from './analtics2.component';

describe('Analtics2Component', () => {
  let component: Analtics2Component;
  let fixture: ComponentFixture<Analtics2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Analtics2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Analtics2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
