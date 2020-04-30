package repo;

import java.util.List;
import java.util.Optional;

public interface AbstractRepository<T> {
    void create(T element);
    T findById(int id);
   List<T> findByName(String name);
   List<T> getAll();
}
