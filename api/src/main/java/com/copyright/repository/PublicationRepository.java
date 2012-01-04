package com.copyright.repository;

import com.copyright.domain.Publication;
import java.io.Serializable;
import java.util.List;

public interface PublicationRepository<T, K extends Serializable>{

    void save(T publication);

    void saveAll(List<T> publicationsToSave);

    Publication findById(K id);

    List<? extends T> findAll();

    List<? extends T> findByAuthor(String author);

    void delete(T publication);
}
