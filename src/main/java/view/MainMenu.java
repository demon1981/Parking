package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.*;

public class MainMenu {

    public MainMenu(final Shell shell, final CTabFolder folder) {

        Menu bar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(bar);
        MenuItem fileItem = new MenuItem(bar, SWT.CASCADE);
        fileItem.setText("Файл");
        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
        fileItem.setMenu(fileMenu);

        MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
        exitItem.setText("Выход\tCtrl+Q");
        exitItem.setAccelerator(SWT.MOD1 + 'Q');
        exitItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                shell.close();
            }
        });

        //раздел меню
        MenuItem dataBase = new MenuItem(bar, SWT.CASCADE);
        dataBase.setText("База данных");
        Menu dataBaseItem = new Menu(shell, SWT.DROP_DOWN);
        dataBase.setMenu(dataBaseItem);

        //элемент меню Модели автомобилей
        MenuItem autoModelItem = new MenuItem(dataBaseItem, SWT.PUSH);
        autoModelItem.setText("Модели автомобилей\tCtrl+А");
        autoModelItem.setAccelerator(SWT.MOD1 + 'А');
        autoModelItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                new AutoModelView(folder);
            }
        });

        //элемент меню Клиенты парковки
        MenuItem customersMenuItem = new MenuItem(dataBaseItem, SWT.PUSH);
        customersMenuItem.setText("Клиенты парковки\tCtrl+К");
        customersMenuItem.setAccelerator(SWT.MOD1 + 'К');
        customersMenuItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                new CustomersView(folder);
            }
        });

        //элемент меню Грузоподемность автомбоилей
        MenuItem autoCapacityMenuItem = new MenuItem(dataBaseItem, SWT.PUSH);
        autoCapacityMenuItem.setText("Грузоподемность автомбоилей\tCtrl+Г");
        autoCapacityMenuItem.setAccelerator(SWT.MOD1 + 'Г');
        autoCapacityMenuItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                new AutoCapacityView(folder);
            }
        });


    }
}
