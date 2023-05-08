import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FigmaReaderComponent } from './figma-reader.component';

describe('FigmaReaderComponent', () => {
  let component: FigmaReaderComponent;
  let fixture: ComponentFixture<FigmaReaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FigmaReaderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FigmaReaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
