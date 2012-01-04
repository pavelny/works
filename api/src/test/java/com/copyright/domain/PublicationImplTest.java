package com.copyright.domain;

import java.util.Date;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PublicationImplTest{

    private static final String ID = "bk101";
    private static final String AUTHOR = "Gambardella, Matthew";
    private static final String TITLE = "XML Developer's Guide";
    private static final String GENRE = "Computer";
    private static final Double PRICE = 44.95D;
    private static final Date PUBLISH_DATE = new Date(5000L);
    private static final String DESCRIPTION = "An in-depth look at creating applications with XML.";

    @Test
    public void testGetSet() {
        Publication publication = new PublicationImpl();
        publication.setId(ID);
        publication.setAuthor(AUTHOR);
        publication.setTitle(TITLE);
        publication.setGenre(GENRE);
        publication.setPrice(PRICE);
        publication.setPublishDate(PUBLISH_DATE);
        publication.setDescription(DESCRIPTION);
        assertEquals(ID, publication.getId());
        assertEquals(AUTHOR, publication.getAuthor());
        assertEquals(TITLE, publication.getTitle());
        assertEquals(GENRE, publication.getGenre());
        assertEquals(PRICE, publication.getPrice());
        assertEquals(PUBLISH_DATE, publication.getPublishDate());
        assertEquals(DESCRIPTION, publication.getDescription());
    }
}
