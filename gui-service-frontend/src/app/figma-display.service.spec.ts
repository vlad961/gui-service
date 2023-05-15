import { TestBed } from '@angular/core/testing';

import { FigmaDisplayService } from './figma-display.service';

describe('FigmaDisplayService', () => {
  let service: FigmaDisplayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FigmaDisplayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
