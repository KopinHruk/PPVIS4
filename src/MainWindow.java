package src;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import src.actions.ActionInterfaceLabel;
import src.actions.ActionInterfaceText;
import src.actions.ActionInterfaceTree;
import src.actions.StackController;

public class MainWindow {
    private Display display = new Display();
    private Shell shell = new Shell(display);

    public MainWindow() {
        GridLayout layout = new GridLayout(7, false);
        shell.setLayout(layout);
        
        ActionInterfaceLabel answer = new ActionInterfaceLabel(shell);
        
        ActionInterfaceText input = new ActionInterfaceText(shell);
        
        ActionInterfaceTree tree = new ActionInterfaceTree(shell);

        BaseFunctionality numpad = new BaseFunctionality(shell, SWT.BORDER);

        StackController calculator = new StackController();
    }

    public void startWindow() {
        shell.open();
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}