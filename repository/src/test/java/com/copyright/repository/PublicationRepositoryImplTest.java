package com.copyright.repository;

import com.copyright.domain.Publication;
import com.copyright.domain.PublicationImpl;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/repository-spring-test.xml"})
public class PublicationRepositoryImplTest {

    private static final String ID = "bk101";
    private static final String AUTHOR = "Gambardella, Matthew";
    private static final String TITLE = "XML Developer's Guide";
    private static final String GENRE = "Computer";
    private static final Double PRICE = 44.95D;
    private static final Date PUBLISH_DATE = new Date(5000L);
    private static final String DESCRIPTION = "An in-depth look at creating applications with XML.";

    @Autowired
    protected PublicationRepository publicationRepository;

    @Before
    public void setUp() {
        ((PublicationRepositoryImpl) publicationRepository).createCollection();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetPublicationById() {
        assertNull(publicationRepository.findById(ID));
        Publication publication = new PublicationImpl();
        publication.setId(ID);
        publication.setAuthor(AUTHOR);
        publication.setTitle(TITLE);
        publication.setGenre(GENRE);
        publication.setPrice(PRICE);
        publication.setPublishDate(PUBLISH_DATE);
        publication.setDescription(DESCRIPTION);
        publicationRepository.save(publication);
        Publication result = publicationRepository.findById(ID);
        assertNotNull(result);
        assertEquals(ID, publication.getId());
        assertEquals(AUTHOR, publication.getAuthor());
        assertEquals(TITLE, publication.getTitle());
        assertEquals(GENRE, publication.getGenre());
        assertEquals(PRICE, publication.getPrice());
        assertEquals(PUBLISH_DATE, publication.getPublishDate());
        assertEquals(DESCRIPTION, publication.getDescription());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testFindAll() {
        assertEquals(0, publicationRepository.findAll().size());
        Publication publication1 = new PublicationImpl();
        publication1.setId("1");
        publicationRepository.save(publication1);
        Publication publication2 = new PublicationImpl();
        publication2.setId("2");
        publicationRepository.save(publication2);
        Publication publication3 = new PublicationImpl();
        publication3.setId("3");
        publicationRepository.save(publication3);
        List<Publication> result = publicationRepository.findAll();
        assertEquals(3, result.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSaveAll() {
        assertEquals(0, publicationRepository.findAll().size());
        Publication publication1 = new PublicationImpl();
        publication1.setId("1");
        Publication publication2 = new PublicationImpl();
        publication2.setId("2");
        Publication publication3 = new PublicationImpl();
        publication3.setId("3");
        List<Publication> publications = Lists.newArrayList(publication1, publication2, publication3);
        publicationRepository.saveAll(publications);
        List<Publication> result = publicationRepository.findAll();
        assertEquals(3, result.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testFindByAuthor() {
        assertEquals(0, publicationRepository.findAll().size());
        Publication publication1 = new PublicationImpl();
        publication1.setId("1");
        publication1.setAuthor("Kernighan");
        Publication publication2 = new PublicationImpl();
        publication2.setId("2");
        publication2.setAuthor("Stroustrup");
        Publication publication3 = new PublicationImpl();
        publication3.setId("3");
        publication3.setAuthor("Kernighan");
        List<Publication> publications = Lists.newArrayList(publication1, publication2, publication3);
        publicationRepository.saveAll(publications);
        List<Publication> result = publicationRepository.findByAuthor("Kernighan");
        assertEquals(2, result.size());
        result = publicationRepository.findByAuthor("Stroustrup");
        assertEquals(1, result.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testDelete() {
        assertEquals(0, publicationRepository.findAll().size());
        Publication publication1 = new PublicationImpl();
        publication1.setId(ID);
        Publication publication2 = new PublicationImpl();
        publication2.setId("2");
        Publication publication3 = new PublicationImpl();
        publication3.setId("3");
        List<Publication> publications = Lists.newArrayList(publication1, publication2, publication3);
        publicationRepository.saveAll(publications);
        assertEquals(3, publicationRepository.findAll().size());
        Publication result = publicationRepository.findById(ID);
        publicationRepository.delete(result);
        assertEquals(2, publicationRepository.findAll().size());
        assertNull(publicationRepository.findById(ID));
    }


    @After
    public void tearDown() {
        ((PublicationRepositoryImpl) publicationRepository).dropCollection();
    }
}
