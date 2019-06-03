
package dao;

import model.AutoModel;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class AutoModelDao extends AbstractDao<AutoModel>{

    public AutoModel findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AutoModel.class, id);
    }

    public void save(String name) {
        super.save(new AutoModel(name));
    }

    public List<AutoModel> findAll() {
        return super.findAll(AutoModel.class);
    }

    public List<String[]> returnFieldsToView() {

        List<String[]> autoModelListString = new ArrayList<String[]>();

        List<AutoModel> autoModelList = findAll();

        for (AutoModel autoModel :
                autoModelList) {
            autoModelListString.add(new String[]{autoModel.getName()});
        }

        return autoModelListString;
    }

}