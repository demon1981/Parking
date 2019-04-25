package view;


import dao.AutoModelDao;
import dao.CustomersDao;
import model.AutoModel;
import model.Customers;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import view.elements.FormTable;

public class CustomersView {

    private FormTable table = null;

    public CustomersView(CTabFolder folder) {

        GridLayout gridLayout = new GridLayout();
        Composite content = new Composite(folder, SWT.NONE);
        content.setLayout(gridLayout);
        gridLayout.numColumns = 3;

        CTabItem cTabItem = new CTabItem(folder, SWT.CLOSE);
        cTabItem.setText("Клиенты парковки");
        folder.setSelection(cTabItem);

        Label label = new Label(content, SWT.NONE);
        label.setText("Новый клиент парковки: ");
        GridData gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        label.setLayoutData(gridData);

        final Text text = new Text(content, SWT.BORDER);
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        text.setLayoutData(new GridData(150, SWT.DEFAULT));

        final Button button = new Button(content, SWT.NONE);
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        button.setText("Save");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                String textString = text.getText().trim();
                if (textString != "") {
                    new CustomersDao().save(textString);
                    updateCustomersList();
                    text.setText("");
                }
            }
        });

        table = new FormTable(content, Customers.class,  new CustomersDao());

        cTabItem.setControl(content);

        updateCustomersList();

        label.pack();
        text.pack();
        button.pack();
    }

    public void updateCustomersList() {
        table.update();
    }

}
