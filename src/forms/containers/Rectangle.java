package forms.containers;

import forms.BorderType;
import forms.Element;

public class Rectangle extends Bordered {
    public Rectangle(Element element) {
        super(element);
        borderType = BorderType.Single;
    }
}
