package view.elements;

import dao.AutoModelDao;
import dao.Dao;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import java.util.*;

public class FormCombo <T> {

    private Dao dao;
    private Combo formCombo;
    private Class<T> clazz;

    public FormCombo(Composite content, Dao dao, Class<T> clazz) {
        this.dao = dao;
        this.clazz = clazz;

        formCombo = new Combo(content, SWT.NONE);
        formCombo.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));

        List<String[]> fildsList = this.dao.returnFieldsToView();
        for (String[] filds :
                fildsList) {
            formCombo.add(filds[1]);
        }
    }

    public int getSelectIndex() {
        return formCombo.getSelectionIndex();
    }

    public T getSelectObject() {
        return (T) dao.findById(clazz, formCombo.getSelectionIndex() + 1);
    }

}
