package forms.containers;

import forms.BorderType;
import forms.Element;

public class Frame extends Bordered {
    public String header;

    public Frame(String header, Element element) {
        super(element);
        this.header = header;
        borderType = BorderType.Double;

        int headLength = header.length();
        width = width >= headLength + 4 ? width : headLength + 4;
    }

    @Override
    public char[][] print(int y, int x, char[][] map) {
        map = super.print(y, x, map);

        char[] chrArr = ('╡' + header + '╞').toCharArray();
        for(int i = 0; i < chrArr.length; i++) {
            map[y][x + i + 1] = chrArr[i];
        }
        return map;
    }
}
