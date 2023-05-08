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
  figmaData!: Promise<void>

  constructor(private figmaReaderService: FigmaReaderService) { }

  ngOnInit(): void {
  }

  submitFigmaLink(): void {
    const fileId = this.getFigmaFileId(this.figmaLink);
    if (fileId) {
      this.figmaData = this.figmaReaderService.readFigmaProject(fileId, this.figmaApiKey)
    } else {
      alert("Invalid Figma link. Please make sure it is in the correct format.");
    }
  }

  getFigmaFileId(url: string): string | null {
    const fileIdMatch = url.match(/file\/(.*?)\//);
    return fileIdMatch ? fileIdMatch[1] : null;
  }
}


