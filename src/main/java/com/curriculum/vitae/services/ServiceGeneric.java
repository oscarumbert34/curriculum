package com.curriculum.vitae.services;

import com.curriculum.vitae.exceptions.TransactionException;

import java.util.List;

public interface ServiceGeneric <T>{
    public void save(T entity) throws TransactionException;

    public T findLast();

    public List<T> findAll();
}
