package view;

import dao.AutoCapacityDao;
import dao.AutoModelDao;
import dao.CustomersDao;
import dao.ParkingEventDao;
import model.AutoCapacity;
import model.AutoModel;
import model.Customers;
import model.ParkingEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import view.elements.FormCombo;
import view.elements.FormTable;

import java.util.List;

public class ParkingEventView {

    private FormTable table = null;

    public ParkingEventView(CTabFolder folder) {

        GridLayout gridLayout = new GridLayout();
        Composite content = new Composite(folder, SWT.NONE);
        content.setLayout(gridLayout);
        gridLayout.numColumns = 2;

        CTabItem cTabItem = new CTabItem(folder, SWT.NONE);
        cTabItem.setText("Автомобили на парковке");

        folder.setSelection(cTabItem);

        //Поле наименования грузоподъемнсти
        Label labelName = new Label(content, SWT.NONE);
        labelName.setText("Марка : ");
        labelName.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
        final FormCombo<AutoModel> autoModelCombo = new FormCombo(content, new AutoModelDao(), AutoModel.class);

        labelName = new Label(content, SWT.NONE);
        labelName.setText("Клиент : ");
        labelName.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
        final FormCombo<Customers> customersCombo = new FormCombo(content, new CustomersDao(), Customers.class);

        labelName = new Label(content, SWT.NONE);
        labelName.setText("Грузоподъемность : ");
        labelName.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
        final FormCombo<AutoCapacity> autoCapasityCombo = new FormCombo(content, new AutoCapacityDao(), AutoCapacity.class);

        final Button saveButton = new Button(content, SWT.NONE);
        saveButton.setText("Save");
        saveButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {

                if (autoModelCombo.getSelectIndex() != -1 & customersCombo.getSelectIndex() != -1 &
                        autoCapasityCombo.getSelectIndex() != -1) {

                    new ParkingEventDao().save(autoModelCombo.getSelectObject(), customersCombo.getSelectObject(), autoCapasityCombo.getSelectObject());
                    updateTable();

                }
            }
        });


        final Button setTimeButton = new Button(content, SWT.NONE);
        setTimeButton.setText("Выезд");
        setTimeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {

                ParkingEvent selectEvent = (ParkingEvent) table.getSelectObject();
                selectEvent.checkOutCar();
                new ParkingEventDao().update(selectEvent);
                updateTable();
            }
        });

        table = new FormTable(content, ParkingEvent.class, new ParkingEventDao());

        cTabItem.setControl(content);

        updateTable();
    }

    public void updateTable() {
        table.update();
    }
}
