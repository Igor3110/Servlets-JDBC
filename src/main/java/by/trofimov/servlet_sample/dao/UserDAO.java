package by.trofimov.servlet_sample.dao;

import java.util.List;
import java.io.Serializable;

public interface UserDAO<K extends Serializable, E> {

        E save(E entity);

        List<E> findAll();

}
