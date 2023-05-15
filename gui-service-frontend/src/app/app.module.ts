import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FigmaReaderComponent } from './figma-reader/figma-reader.component';
import { FigmaDisplayComponent } from './figma-display/figma-display.component';

@NgModule({
  declarations: [
    AppComponent,
    FigmaReaderComponent,
    FigmaDisplayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
