package view;

import dao.AutoModelDao;
import model.AutoModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import view.elements.FormTable;

import java.util.Calendar;

public class AutoModelView {

    private FormTable table = null;

    public AutoModelView(CTabFolder folder) {

        GridLayout gridLayout = new GridLayout();
        Composite content = new Composite(folder, SWT.NONE);
        content.setLayout(gridLayout);
        gridLayout.numColumns = 3;

        CTabItem cTabItem = new CTabItem(folder, SWT.CLOSE);
        cTabItem.setText("Модели автомобилей");
        folder.setSelection(cTabItem);

        Label label = new Label(content, SWT.NONE);
        label.setText("Модель автомобиля: ");
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
                    new AutoModelDao().save(textString);
                    updateAutoModelList();
                    text.setText("");
                }
            }
        });

        table = new FormTable(content, AutoModel.class,  new AutoModelDao());

        cTabItem.setControl(content);

        updateAutoModelList();

        label.pack();
        text.pack();
        button.pack();
    }

    public void updateAutoModelList() {
        table.update();
    }

}
