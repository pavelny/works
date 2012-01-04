package com.copyright.repository;
import com.copyright.domain.Publication;
import com.copyright.domain.PublicationImpl;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = {"/repository-spring-test.xml"})
public class PublicationRepositoryImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String ID = "bk101";
    private static final String AUTHOR = "Gambardella, Matthew";
    private static final String TITLE = "XML Developer's Guide";
    private static final String GENRE = "Computer";
    private static final Double PRICE = 44.95D;
    private static final Date PUBLISH_DATE = new Date(5000L);
    private static final String DESCRIPTION = "An in-depth look at creating applications with XML.";

    @Autowired
    protected static PublicationRepository publicationRepository;

//    @BeforeClass
//    public static void setUp(){
//        ((PublicationRepositoryImpl)publicationRepository).createCollection();
//    }

    @Ignore
    @Test
    @SuppressWarnings("unchecked")
    public void getPublicationById() {
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

//    @AfterClass
//    public static void tearDown(){
//        ((PublicationRepositoryImpl)publicationRepository).dropCollection();
//    }

}
