import { TestBed } from '@angular/core/testing';

import { BankGuaranteeService } from './bank-guarantee.service';

describe('BankGuaranteeService', () => {
  let service: BankGuaranteeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BankGuaranteeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
