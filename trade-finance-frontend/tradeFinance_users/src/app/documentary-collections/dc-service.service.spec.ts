import { TestBed } from '@angular/core/testing';

import { DcServiceService } from './dc-service.service';

describe('DcServiceService', () => {
  let service: DcServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DcServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
