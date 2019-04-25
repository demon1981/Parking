package view;


import dao.AutoCapacityDao;
import dao.CustomersDao;
import model.Customers;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import view.elements.FormTable;

public class AutoCapacityView {

    private FormTable table = null;

    public AutoCapacityView(CTabFolder folder) {

        GridLayout gridLayout = new GridLayout();
        Composite content = new Composite(folder, SWT.NONE);
        content.setLayout(gridLayout);
        gridLayout.numColumns = 3;

        CTabItem cTabItem = new CTabItem(folder, SWT.CLOSE);
        cTabItem.setText("Грузоподемность автомобилей");
        folder.setSelection(cTabItem);

        //Поле наименования грузоподъемнсти
        Label labelName = new Label(content, SWT.NONE);
        labelName.setText("Новая грузоподемность : ");
        GridData gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        labelName.setLayoutData(gridData);

        final Text textName = new Text(content, SWT.BORDER);
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        textName.setLayoutData(new GridData(150, SWT.DEFAULT));

        //поле стоимости стоянки
        Label labelCostOfParcing = new Label(content, SWT.NONE);
        labelCostOfParcing.setText("Стоимость стояноки(сут.): ");
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        labelCostOfParcing.setLayoutData(gridData);

        final Text textCostOfParcing = new Text(content, SWT.BORDER);
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        textCostOfParcing.setLayoutData(new GridData(150, SWT.DEFAULT));

        textCostOfParcing.addVerifyListener(new VerifyListener() {
            public void verifyText(VerifyEvent verifyEvent) {
                System.out.println(textCostOfParcing);
            }
        });


        final Button button = new Button(content, SWT.NONE);
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        button.setText("Save");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                String name = textName.getText().trim();
                String cost = textName.getText().trim();
                if (name != "" & cost != "") {
                    new AutoCapacityDao().save(name, Double.valueOf(cost));
                    updateCustomersList();
                    textName.setText("");
                }
            }
        });

        table = new FormTable(content, Customers.class,  new CustomersDao());

        cTabItem.setControl(content);

        updateCustomersList();

        labelName.pack();
        textName.pack();
        button.pack();
    }

    public void updateCustomersList() {
        table.update();
    }

}
