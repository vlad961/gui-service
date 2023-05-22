export interface FigmaComponent { // TODO: label uses characters instead of name -> characters property is missing in FigmaObject
    type: string;
    name: string;
    position: Position;
    size: Size;
    children: FigmaComponent[];
}

export interface Position {
    x: number;
    y: number;
}

export interface Size {
    width: number;
    height: number;
}