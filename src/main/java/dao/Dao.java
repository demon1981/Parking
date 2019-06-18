package dao;

import java.util.List;

public interface Dao <T>{

    List<String[]> returnFieldsToView();

    T findById(Class<T> generic, int id);

    void save(T value);

    void update(T value);

    void delete(T value);

}
