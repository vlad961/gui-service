import { Component, OnInit } from '@angular/core';
import { FigmaReaderService } from "./figma-reader.service";

@Component({
  selector: 'app-figma-reader',
  templateUrl: './figma-reader.component.html',
  styleUrls: ['./figma-reader.component.scss']
})
export class FigmaReaderComponent implements OnInit {
  figmaLink!: string
  figmaApiKey!: string // declare it here
  figmaData!: any;

  constructor(private figmaReaderService: FigmaReaderService) { }

  ngOnInit(): void {
  }

  submitFigmaLink(): void {
    const fileId = this.getFigmaFileId(this.figmaLink);
    if (fileId) {
      this.figmaData = this.figmaReaderService.readFigmaProject(fileId, this.figmaApiKey);
      this.sendJsonToBackend();
    } else {
      alert("Invalid Figma link. Please make sure it is in the correct format.");
    }
  }

  getFigmaFileId(url: string): string | null {
    const fileIdMatch = url.match(/file\/(.*?)\//);
    return fileIdMatch ? fileIdMatch[1] : null;
  }

  async sendJsonToBackend() {
    if (this.figmaData) {
      // Wait for the figmaData to be available.
      const figmaData = await this.figmaData;

      this.figmaReaderService.sendFigmaJson(JSON.stringify(this.figmaData)).subscribe(response => {
        console.log(response);
      });
    } else {
      console.log('No Figma data available');
    }
  }

  // TODO: Fill empty angular boxes with data from java objects in backend
  // Find out how many components are in the frame and create boxes for those components
  // Get position attributes from java objects
}


