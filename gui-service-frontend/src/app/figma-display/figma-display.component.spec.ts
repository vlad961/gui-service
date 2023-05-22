import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FigmaDisplayComponent } from './figma-display.component';

describe('FigmaDisplayComponent', () => {
  let component: FigmaDisplayComponent;
  let fixture: ComponentFixture<FigmaDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FigmaDisplayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FigmaDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
