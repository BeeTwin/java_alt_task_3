package forms.containers.layouts;

import util.MutableInt;
import forms.Element;
import forms.containers.Bordered;
import forms.containers.Container;

import java.util.function.Function;

public abstract class Layout extends Container {
    protected int maxLength;

    protected Layout(Element... elements) {
        super(elements);
    }

    protected int Max(Function<Element, Integer> selector) {
        int current;
        for(Element element : _insertedElements) {
            maxLength = (current = selector.apply(element)) > maxLength ? current : maxLength;
        }
        return maxLength;
    }

    @Override
    public char[][] print(int y, int x, char[][] map) {
        if (map == null) {
            map = new char[getHeight()][getWidth()];
        }

        for(Element element : _insertedElements) {
            if (element instanceof Bordered) {
                changeMaxLength((Bordered) element);
            }
            map = element.print(y, x, map);

            MutableInt my; MutableInt mx;
            shift(my = new MutableInt(y), mx = new MutableInt(x), element);
            y = my.value; x = mx.value;
        }
        return map;
    }

    abstract void changeMaxLength(Bordered element);
    abstract void shift(MutableInt y, MutableInt x, Element element);
}
