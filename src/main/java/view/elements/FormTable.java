package view.elements;

import dao.Dao;
import model.AutoModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FormTable {

    private Dao dao;
    private Table table;
    private List<TableColumn> tableColumns;


    public FormTable(Composite composite, Class className, Dao dao) {

        this.table = new Table(composite, SWT.VIRTUAL | SWT.BORDER);
        this.tableColumns = new ArrayList<TableColumn>();
        this.dao = dao;

        table.setLinesVisible(true);
        GridData gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        gridData.horizontalSpan = 3;
        gridData.verticalAlignment = GridData.FILL;
        gridData.grabExcessVerticalSpace = true;
        gridData.grabExcessHorizontalSpace = true;
        table.setLayoutData(gridData);

        TableColumn column = new TableColumn(table, SWT.CENTER);
        column.setText("№");
        column.setWidth(30);
        tableColumns.add(column);

        Field[] fieldList = className.getDeclaredFields();

        for (Field classFild : fieldList) {

            if (classFild.getName() == "id") continue;

            column = new TableColumn(table, SWT.CENTER);
            column.setText(classFild.getName());
            column.setWidth(80);
            tableColumns.add(column);
        }
        table.setHeaderVisible(true);
    }

    public void removeAll() {
        table.removeAll();
    }

    public void update() {
        removeAll();
        List<String[]> allFildsModel = dao.findAll();

        Integer num = 0;
        for (String[] filds: allFildsModel) {
            TableItem item = new TableItem(this.table, SWT.NONE);
            item.setText(0, (++num).toString());

            for (int i = 0; i < filds.length; i++) {
                item.setText(i+1, filds[i].toString());
            }
        }

    }
}