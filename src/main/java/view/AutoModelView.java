package view;


import dao.AutoModelDao;
import model.AutoModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.List;

public class AutoModelView {

    private Table table = null;

    public AutoModelView(Shell shell) {

        //Shell shell = new Shell(parentShell);

        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 3;

        shell.setLayout(gridLayout);

        Label label = new Label(shell, SWT.NONE);
        label.setText("Модель автомобиля: ");
        GridData gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        label.setLayoutData(gridData);

        final Text text = new Text(shell, SWT.BORDER);
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        text.setLayoutData(new GridData(150, SWT.DEFAULT));

        final Button button = new Button(shell, SWT.NONE);
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

        table = new Table(shell, SWT.VIRTUAL | SWT.BORDER);
        table.setLinesVisible(true);
        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        gridData.horizontalSpan = 3;
        gridData.verticalAlignment = GridData.FILL;
        gridData.grabExcessVerticalSpace = true;
        gridData.grabExcessHorizontalSpace = true;
        table.setLayoutData(gridData);

        updateAutoModelList();

        label.pack();
        text.pack();
        button.pack();
//        shell.layout();
//        shell.pack();
//        shell.open();
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
