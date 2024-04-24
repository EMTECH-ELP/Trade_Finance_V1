import { TestBed } from '@angular/core/testing';

import { AutoLogoutService } from './auto-logout-service.service';

describe('AutoLogoutServiceService', () => {
  let service: AutoLogoutService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AutoLogoutService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
