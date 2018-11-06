package com.gmail.michzuerch.locateipaddress.backend.mongodb.service;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CrudService<T> {

    MongoRepository<T, ObjectId> getRepository();

    default T save(User currentUser, T entity) {
        return getRepository().save(entity);
    }

    default void delete(User currentUser, T entity) {
        if (entity == null) {
            System.err.println("Entity null");
        }
        getRepository().delete(entity);
    }

    default void delete(User currentUser, ObjectId id) {
        delete(currentUser, load(id));
    }

    default long count() {
        return getRepository().count();
    }

    default T load(ObjectId id) {
        T entity = getRepository().findById(id).orElse(null);
        if (entity == null) {
            System.err.println("Entity null2");
        }
        return entity;
    }

    T createNew(User currentUser);
}
