package com.resturant.base;

import java.awt.*;
import java.util.List;


public interface BaseRepository<T extends BaseEntity <ID>, ID> {
    void create(T entity);

    void delete(ID id);
    T findById(ID id);
    List<T> findAll();
}
