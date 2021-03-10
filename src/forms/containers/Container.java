package forms.containers;

import forms.Element;

import java.util.*;

public abstract class Container implements Element {
    protected final List<Element> _insertedElements = new ArrayList<>();
    public int height;
    public int width;

    protected Container(Element... elements) {
        _insertedElements.addAll(Arrays.asList(elements));
        height = getHeight();
        width = getWidth();
    }

    @Override
    public int getWidth() {
        int width = 0;
        for(Element el : _insertedElements) {
            width += el.getWidth();
        }
        return width;
    }

    @Override
    public int getHeight() {
        int height = 0;
        for(Element el : _insertedElements) {
            height += el.getHeight();
        }
        return height;
    }

    @Override
    public char[][] print(int y, int x, char[][] map) {
        if (map == null) {
            map = new char[getHeight()][getWidth()];
        }
        for(Element element : _insertedElements) {
            map = element.print(y + 1, x + 2, map);
        }
        return map;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        char[][] chrArr = print(0,0,null);
        for(char[] line : chrArr) {
            result.append(new String(line) + '\n');
        }
        return result.toString();
    }
}
