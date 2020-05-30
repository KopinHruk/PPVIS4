package src;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import src.actions.ActionInterfaceInputButton;

public class AddFunctionality {

    private Text inputField;
    private Composite parent;
    private List<ActionInterfaceInputButton> buttons = new ArrayList<>();
    private Point prevSize;

    public AddFunctionality(Composite parent, Text inputField) {
        this.parent = parent;
        this.inputField = inputField;
    }

    public void show() {
        buttons.add(new ActionInterfaceInputButton(inputField, "pow", parent));

        buttons.add(new ActionInterfaceInputButton(inputField, "e^", parent));

        this.prevSize = parent.getSize();
        parent.pack();
        parent.setSize(prevSize);
    }

    public void hide() {
        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).DisposeButton();
        }
        buttons.clear();
        parent.pack();
        parent.setSize(prevSize);
    }
}