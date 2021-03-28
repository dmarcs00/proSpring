package com.example.service.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    @Override
    public boolean crear(T entity) {
        return getRepository().save(entity).equals(entity);
    }

    @Override
    public void eliminar(ID id) {
    	getRepository().deleteById(id);
    }

    @Override
    public T buscar(ID id) {
        /*if(getRepo().existsById(id)){
            return getRepo().findById(id).get();
        }
        return null;*/
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public boolean modificar(T entity) {
        try{
        	getRepository().save(entity);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<T> mostrarTodos() {
        return getRepository().findAll();
    }

    public abstract JpaRepository<T, ID> getRepository();
}
