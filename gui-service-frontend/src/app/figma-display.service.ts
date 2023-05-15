import { Observable } from 'rxjs';
import { Injectable, Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FigmaComponent } from './figma-component';


@Injectable({
  providedIn: 'root'
})
export class FigmaDisplayService {

  private apiUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  getFigmaComponents(): Observable<FigmaComponent[]> {
    return this.http.get<FigmaComponent[]>(this.apiUrl + "/figma-components");
  }

  getText(component : FigmaComponent) : string {
    for (var child of component.children) {
      if (child.type === "TEXT") {
        return child.name;
      }
    }
    return "";
  }
 
  isButton(component : FigmaComponent) : boolean {
    return component.type === "COMPONENT" && component.name === "Button";
  }

  isTextField(component : FigmaComponent) : boolean {
    return component.type === "COMPONENT" && component.name === "Text Field";
  }

  isLabel(component : FigmaComponent) : boolean {
    return component.type === "COMPONENT" && component.name === "Label";
  }

  isHeader(component : FigmaComponent) : boolean {
    return component.type === "COMPONENT" && component.name === "Header";
  }

}
