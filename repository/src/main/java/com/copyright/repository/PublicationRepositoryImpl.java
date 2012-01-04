package com.copyright.repository;

import com.copyright.domain.Publication;
import com.copyright.domain.PublicationImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PublicationRepositoryImpl implements PublicationRepository<Publication, String> {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Publication findById(String id) {
        return mongoTemplate.findById(id, PublicationImpl.class);
    }

    @Override
    public void save(Publication publication) {
        mongoTemplate.save(publication);
    }

    @Override
    public void saveAll(List<Publication> publicationsToSave) {
        mongoTemplate.insert(publicationsToSave, PublicationImpl.class);
    }


    @Override
    public void delete(Publication publication) {
        mongoTemplate.remove(publication);
    }

    @Override
    public List<PublicationImpl> findAll() {
        return mongoTemplate.findAll(PublicationImpl.class);
    }

    @Override
    public List<PublicationImpl> findByAuthor(String author) {
        return mongoTemplate.find(new Query(Criteria.where("author").is(author)), PublicationImpl.class);
    }

    public void createCollection() {
        if (!mongoTemplate.collectionExists(PublicationImpl.class)) {
            mongoTemplate.createCollection(PublicationImpl.class);
        }
    }

    public void dropCollection() {
        if (mongoTemplate.collectionExists(PublicationImpl.class)) {
            mongoTemplate.dropCollection(PublicationImpl.class);
        }
    }
}
