import dao.AutoModelDao;
import model.*;
import dao.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import view.AutoModelView;
import view.MainView;

import java.util.List;


public class Main {

    private final static int COUNT = 10;

    public static void main(String[] arg) {

        MainView.runWindow();



        //AutoModelView autoModelView = new AutoModelView(MainView.getShell());





//        Display display = new Display();
//        final Shell shell = new Shell(display);
//
//        GridLayout gridLayout = new GridLayout();
//        gridLayout.numColumns = 3;
//
//
////        RowLayout rowLayout = new RowLayout();
////        rowLayout.marginLeft = 10;
////        rowLayout.marginTop = 10;
//
//        //rowLayout.
//
//        shell.setLayout(gridLayout);
//
//        Label label = new Label(shell, SWT.NONE);
//        label.setText("Модель автомобиля: ");
//        GridData gridData = new GridData();
//        gridData.horizontalAlignment = SWT.FILL;
//        label.setLayoutData(gridData);
//
//        final Text text = new Text(shell, SWT.BORDER);
//        gridData = new GridData();
//        gridData.horizontalAlignment = SWT.FILL;
//        text.setLayoutData(new GridData(150, SWT.DEFAULT));
//
//        final Button button = new Button(shell, SWT.NONE);
//        gridData = new GridData();
//        gridData.horizontalAlignment = SWT.FILL;
//        button.setText("Save");
//        button.addSelectionListener(new SelectionAdapter() {
//            @Override
//            public void widgetSelected(SelectionEvent arg0) {
//                String textString = text.getText().trim();
//                if (textString != "") {
//                    new AutoModelDao().save(textString);
//                }
//            }
//        });
//
//        label.pack();
//        text.pack();
//        button.pack();
//
//        final Table table = new Table(shell, SWT.VIRTUAL | SWT.BORDER);
//        table.setLinesVisible(true);
////        table.addListener(SWT.SetData, new Listener() {
////            public void handleEvent(Event event) {
////                TableItem item = (TableItem) event.item;
////                int index = table.indexOf(item);
////                item.setText("Item " + index);
////                System.out.println(item.getText());
////            }
////        });
//
//        gridData = new GridData();
//        gridData.horizontalAlignment = SWT.FILL;
//        gridData.horizontalSpan = 3;
//        gridData.verticalAlignment = GridData.FILL;
//        gridData.grabExcessVerticalSpace = true;
//        gridData.grabExcessHorizontalSpace = true;
//
//        table.setLayoutData(gridData);
//
//        AutoModelDao autoModelName = new AutoModelDao();
//        List<AutoModel> allModel = autoModelName.findAll();
//
//
//        for (AutoModel model: allModel) {
//            TableItem item = new TableItem(table, SWT.NONE);
//            item.setText(0, model.toString());
//        }

//        long t1 = System.currentTimeMillis();
//        table.setItemCount(COUNT);
//        long t2 = System.currentTimeMillis();
        //System.out.println("Items: " + COUNT + ", Time: " + (t2 - t1) + " (ms)");
//        shell.layout();
//        shell.pack();
//        shell.open();
//        while (!shell.isDisposed()) {
//            if (!display.readAndDispatch())
//                display.sleep();
//        }
//        display.dispose();


        /*Display display = new Display();

        Shell shell = new Shell(display);
        shell.setText("My Parking");
        shell.setSize(800,900);
        RowLayout rowLayout = new RowLayout();
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        shell.setLayout(rowLayout);

        Label label = new Label(shell, SWT.NONE);
        label.setText("Модель автомобиля: ");

        final Text text = new Text(shell, SWT.BORDER);
        //text.setText("SWT.BORDER");
        //text.setLayoutData(new RowData(150, SWT.DEFAULT));
        label.pack();
        text.pack();

        // Button
        final Button button = new Button(shell, SWT.NONE);
        button.setText("Save");

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                String textString = text.getText().trim();
                if (textString != "") {
                    new AutoModelDao().save(textString);
                }
            }
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();*/


        //***********************************************************************
//        AutoModel model = new AutoModel("Toyota");
//
//        System.out.println("My model: " + model);
////
//        AutoModelDao autoModelName = new AutoModelDao();
//        List<AutoModel> allModel = autoModelName.findAll();
//
//        for (AutoModel model: allModel) {
//            System.out.println(model);
//        }

    }


}
