import { TestBed } from '@angular/core/testing';

import { AutoLogoutServiceService } from './auto-logout-service.service';

describe('AutoLogoutServiceService', () => {
  let service: AutoLogoutServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AutoLogoutServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
