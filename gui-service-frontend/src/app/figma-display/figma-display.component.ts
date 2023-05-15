import { FigmaComponent } from '../figma-component';
import { FigmaDisplayService } from '../figma-display.service';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-figma-display',
  templateUrl: './figma-display.component.html',
  styleUrls: ['./figma-display.component.scss']
})
export class FigmaDisplayComponent {
  figmaComponents! : FigmaComponent[];

  constructor(private service: FigmaDisplayService) {

  }

  getFigmaComponents(): void {
    this.service.getFigmaComponents().subscribe(components => this.figmaComponents = components);
  }
}
