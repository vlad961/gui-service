import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FigmaReaderService {
  private apiUrl = "https://api.figma.com/v1/files/";
  private genFigmaApiKey = "figd_Xqg5FaQ5i295vt26fz9m1S0VTkI2ZGWSnpc4I4sa"

  constructor(private http: HttpClient) { }

  // deprecated
  async readFigmaProject(figmaId: string, figmaApiKey: string): Promise<void> {
    let result = await fetch(this.apiUrl + figmaId, {
      method: "GET",
      headers: {
        "X-Figma-Token": figmaApiKey
      }
    })
    let figmaTreeStructure = await result.json()

    return figmaTreeStructure;
  }

}
