package com.example.service.common;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {

    boolean crear(T entity);

    void eliminar(ID id);

    T buscar(ID id);

    boolean modificar(T entity);

    List<T> mostrarTodos();

}