package forms.containers;

import forms.BorderType;
import forms.Element;
import forms.Place;

public abstract class Bordered extends Container {
    protected BorderType borderType;

    protected Bordered(Element... elements) {
        super(elements);
    }

    void printBorders(int y, int x, char[][] map) {
        for(int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (row == 0 || row == height - 1) {
                    map[row + y][column + x] = borderType.getChar(Place.Horizontal);
                } else if (column == 0 || column == width - 1) {
                    map[row + y][column + x] = borderType.getChar(Place.Vertical);
                } else if (map[row + y][column + x] == 0){
                    map[row + y][column + x] = ' ';
                }
            }
        }
        map[y][x] = borderType.getChar(Place.TopLeft);
        map[y][x + width - 1] = borderType.getChar(Place.TopRight);
        map[y + height - 1][x + width - 1] = borderType.getChar(Place.BottomRight);
        map[y + height - 1][x] = borderType.getChar(Place.BottomLeft);
    }

    @Override
    public int getWidth() {
        return super.getWidth() + 4;
    }

    @Override
    public int getHeight() {
        return super.getHeight() + 2;
    }

    @Override
    public char[][] print(int y, int x, char[][] map) {
        map = super.print(y, x, map);
        printBorders(y, x, map);
        return map;
    }
}
