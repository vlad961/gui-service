  submitFigmaLink(): void {
    const fileId = this.getFigmaFileId(this.figmaLink);
    if (fileId) {
      this.figmaReaderService.getFigmaData(fileId, this.figmaApiKey).subscribe(data => {
        console.log(data);
      });
    } else {
      alert("Invalid Figma link. Please make sure it is in the correct format.");
    }
  }
