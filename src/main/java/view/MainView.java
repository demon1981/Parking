package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;
import java.util.List;

public class MainView {

    private static Display display = null;
    private static Shell shell = null;
    private static CTabFolder folder = null;
    private static List<CTabItem> openCTabItem = new ArrayList<CTabItem>();

    private MainView() { }

    public static Shell getShell() { return shell; }

    public static void runWindow(){

        display = new Display();
        shell = new Shell(display);
        shell.setText("Parking");
        shell.setSize(1100, 900);
        shell.setLayout(new GridLayout());


        folder = new CTabFolder(shell, SWT.UP);
        GridData data = new GridData(SWT.FILL,
                SWT.FILL, true, true,
                2, 1);
        folder.setLayoutData(data);
        //folder.setSelection(0);

        ParkingEventView parkingEventView = new ParkingEventView(folder);
        new MainMenu(shell, folder);

        folder.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }


}
