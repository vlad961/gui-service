import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FigmaReaderService {
  private figmaApiUrl = "https://api.figma.com/v1/files/";
  private genFigmaApiKey = "figd_Xqg5FaQ5i295vt26fz9m1S0VTkI2ZGWSnpc4I4sa"

  private apiUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  async readFigmaProject(figmaId: string, figmaApiKey: string): Promise<any> {
    let result = await fetch(this.figmaApiUrl + figmaId, {
      method: "GET",
      headers: {
        "X-Figma-Token": figmaApiKey
      }
    })
    let figmaTreeStructure = await result.json()
    return figmaTreeStructure;
  }

  sendFigmaJson(jsonData: string): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/process-json`, jsonData, { responseType: "text" as "json"});
  }

}
