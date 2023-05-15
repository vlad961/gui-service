import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
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
}
