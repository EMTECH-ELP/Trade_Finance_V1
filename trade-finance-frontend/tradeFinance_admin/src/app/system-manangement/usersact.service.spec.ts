import { TestBed } from '@angular/core/testing';

import { UsersactService } from './usersact.service';

describe('UsersactService', () => {
  let service: UsersactService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsersactService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
