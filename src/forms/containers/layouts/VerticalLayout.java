package forms.containers.layouts;

import forms.containers.*;
import forms.Element;
import util.MutableInt;

public class VerticalLayout extends Layout {
    public VerticalLayout(Element... elements) {
        super(elements);
    }

    @Override
    void changeMaxLength(Bordered element) {
        element.width = maxLength;
    }

    @Override
    void shift(MutableInt y, MutableInt x, Element element) {
        y.value += element.getHeight();
    }

    @Override
    public int getWidth() {
        return Max(x -> x.getWidth());
    }
}
