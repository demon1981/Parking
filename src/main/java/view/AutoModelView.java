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

import java.util.List;

public class AutoModelView {

    private Table table = null;

    public AutoModelView(CTabFolder folder, CTabItem cTabItem) {

        Shell shell = new Shell();

        Composite content = new Composite(folder, SWT.NONE);

        GridLayout gridLayout = new GridLayout();

        content.setLayout(gridLayout);

        gridLayout.numColumns = 3;

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
                }
            }
        });

        table = new Table(content, SWT.VIRTUAL | SWT.BORDER);
        table.setLinesVisible(true);
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        gridData.horizontalSpan = 3;
        gridData.verticalAlignment = GridData.FILL;
        gridData.grabExcessVerticalSpace = true;
        gridData.grabExcessHorizontalSpace = true;
        table.setLayoutData(gridData);

        cTabItem.setControl(content);

        updateAutoModelList();

        label.pack();
        text.pack();
        button.pack();
    }

    public void updateAutoModelList() {

        AutoModelDao autoModelName = new AutoModelDao();
        List<AutoModel> allModel = autoModelName.findAll();

        table.removeAll();
        //table.clearAll();

        for (AutoModel model: allModel) {
            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(0, model.toString());
        }
    }

//    public void update() {
//        updateAutoModelList();
//    }
}
