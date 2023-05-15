export interface FigmaComponent {
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