package forms.containers.layouts;

import forms.containers.Bordered;
import forms.Element;
import util.MutableInt;

public class HorizontalLayout extends Layout {
    public HorizontalLayout(Element... elements) {
        super(elements);
    }

    @Override
    void changeMaxLength(Bordered element) {
        element.height = maxLength;
    }

    @Override
    void shift(MutableInt y, MutableInt x, Element element) {
        x.value += element.getWidth() + 1;
    }

    @Override
    public int getHeight() {
        return Max(x -> x.getHeight());
    }

    @Override
    public int getWidth() {
        return super.getWidth() + _insertedElements.size() - 1;
    }

}
