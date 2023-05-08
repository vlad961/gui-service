import { TestBed } from '@angular/core/testing';

import { FigmaReaderService } from './figma-reader.service';

describe('FigmaReaderService', () => {
  let service: FigmaReaderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FigmaReaderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
