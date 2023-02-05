package vlad.dao;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();

    void delete(long id);

    void saveOrUpdate(T vehicle);

    T getById(long id);
}
