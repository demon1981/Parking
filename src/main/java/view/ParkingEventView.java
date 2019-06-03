package view;

import dao.AutoModelDao;
import dao.ParkingEventDao;
import model.ParkingEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import view.elements.FormTable;

import java.util.List;

public class ParkingEventView {

    private FormTable table = null;

    public ParkingEventView(CTabFolder folder) {

        GridLayout gridLayout = new GridLayout();
        Composite content = new Composite(folder, SWT.NONE);
        content.setLayout(gridLayout);
        gridLayout.numColumns = 3;

        CTabItem cTabItem = new CTabItem(folder, SWT.NONE);
        cTabItem.setText("Автомобили на парковке");



        folder.setSelection(cTabItem);

        //Поле наименования грузоподъемнсти
        Label labelName = new Label(content, SWT.NONE);
        labelName.setText("Марка : ");
        GridData gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        labelName.setLayoutData(gridData);

        Combo autoModelCombo = new Combo(content, SWT.NONE);
//
        List<String[]> autoModelList = new AutoModelDao().returnFieldsToView();
        for (String[] filds: autoModelList) {
            autoModelCombo.add(filds[0]);
        }
        //autoModelCombo.setItems(new AutoModelDao().returnFieldsToView());
        autoModelCombo.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));

//
//        final Text textName = new Text(content, SWT.BORDER);
//        gridData = new GridData();
//        gridData.horizontalAlignment = SWT.FILL;
//        textName.setLayoutData(new GridData(150, SWT.DEFAULT));
//
//        //поле стоимости стоянки
//        Label labelCostOfParcing = new Label(content, SWT.NONE);
//        labelCostOfParcing.setText("Стоимость стояноки(сут.): ");
//        gridData = new GridData();
//        gridData.horizontalAlignment = SWT.FILL;
//        labelCostOfParcing.setLayoutData(gridData);
//
//        final Text textCostOfParcing = new Text(content, SWT.BORDER);
//        gridData = new GridData();
//        gridData.horizontalAlignment = SWT.FILL;
//        textCostOfParcing.setLayoutData(new GridData(150, SWT.DEFAULT));
//
//        textCostOfParcing.addVerifyListener(new VerifyListener() {
//            public void verifyText(VerifyEvent verifyEvent) {
//
//                System.out.println(textCostOfParcing);
//            }
//        });


//        final Button button = new Button(content, SWT.NONE);
//        gridData = new GridData();
//        gridData.horizontalAlignment = SWT.FILL;
//        button.setText("Save");
//        button.addSelectionListener(new SelectionAdapter() {
//            @Override
//            public void widgetSelected(SelectionEvent arg0) {
//                String name = textName.getText().trim();
//                String cost = textCostOfParcing.getText().trim();
//                if (name != "" & cost != "") {
//                    new AutoCapacityDao().save(name, Double.valueOf(cost));
//                    updateTable();
//                    textName.setText("");
//                }
//            }
//        });

        table = new FormTable(content, ParkingEvent.class,  new ParkingEventDao());

        cTabItem.setControl(content);

        updateTable();

//        labelName.pack();
//        textName.pack();
//        button.pack();
    }

    public void updateTable() {
        table.update();
    }




}
