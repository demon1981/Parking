package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class MainView {

    private static Display display = null;
    private static Shell shell = null;

    private MainView() { }

    public static Shell getShell() { return shell; }

    public static void runWindow(){

        display = new Display();
        shell = new Shell(display);
        shell.setText("Parking");
        shell.setSize(1100, 900);
        shell.setLayout(new GridLayout());

        setMenu();

        CTabFolder folder = new CTabFolder(shell, SWT.UP);
        GridData data = new GridData(SWT.FILL,
                SWT.FILL, true, true,
                2, 1);
        folder.setLayoutData(data);
        CTabItem cTabItem1 = new CTabItem(folder, SWT.NONE);
        cTabItem1.setText("Модели автомобилей");

        AutoModelView autoModelView = new AutoModelView(folder, cTabItem1);

        CTabItem cTabItem2 = new CTabItem(folder, SWT.NONE);
        cTabItem2.setText("Tab2");
        CTabItem cTabItem3 = new CTabItem(folder, SWT.NONE);
        cTabItem3.setText("Tab3");

        folder.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    private static void setMenu(){

        Menu bar = new Menu (shell, SWT.BAR);
        shell.setMenuBar (bar);
        MenuItem fileItem = new MenuItem (bar, SWT.CASCADE);
        fileItem.setText ("Файл");
        Menu fileMenu = new Menu (shell, SWT.DROP_DOWN);
        fileItem.setMenu (fileMenu);

        MenuItem exitItem =  new MenuItem (fileMenu, SWT.PUSH);
        exitItem.setText ("Выход\tCtrl+Q");
        exitItem.setAccelerator (SWT.MOD1 + 'Q');
        exitItem.addListener (SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                shell.close ();
            }
        });


        MenuItem dataBase = new MenuItem(bar, SWT.CASCADE);
        dataBase.setText("База данных");
        Menu dataBaseItem =  new Menu (shell, SWT.DROP_DOWN);
        dataBase.setMenu(dataBaseItem);

        MenuItem autoModelItem =  new MenuItem (dataBaseItem, SWT.PUSH);
        autoModelItem.setText ("Модели автомобилей\tCtrl+А");
        autoModelItem.setAccelerator (SWT.MOD1 + 'А');
        autoModelItem.addListener (SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                shell.close ();
            }
        });

    }
}
