import { TestBed } from '@angular/core/testing';

import { InvDiscountingService } from './inv-discounting.service';

describe('InvDiscountingService', () => {
  let service: InvDiscountingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InvDiscountingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
