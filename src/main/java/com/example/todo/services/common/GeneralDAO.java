package com.example.todo.services.common;

public class GeneralDAO<T> {

    public void save(T entity) {
        System.out.println("Saving entity of: " + entity.getClass().getName());

    }
}
