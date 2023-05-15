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
    this.service.getFigmaComponents().subscribe(components => this.figmaComponents = components.reverse());
  }

  isButton(component : FigmaComponent) {
    return this.service.isButton(component);
  }

  getButtonText(button : FigmaComponent) {
    return this.service.getButtonText(button);
  }

  isTextField(component : FigmaComponent) {
    return this.service.isTextField(component);
  }

  getTextFieldText(textfield : FigmaComponent) {
    return this.service.getTextFieldText(textfield);
  }

  isLabel(component : FigmaComponent) {
    return this.service.isLabel(component)
  }

  getLabelText(label : FigmaComponent) {
    return this.service.getLabelText(label);
  }

  isHeader(component : FigmaComponent) {
    return this.service.isHeader(component);
  }

  getHeaderText(header : FigmaComponent) {
    return this.service.getHeaderText(header);
  }
}
