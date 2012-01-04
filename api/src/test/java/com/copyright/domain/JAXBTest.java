package com.copyright.domain;

import java.util.Date;
import java.util.HashSet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JAXBTest {
    private static final String ID = "bk101";
    private static final String AUTHOR = "Gambardella, Matthew";
    private static final String TITLE = "XML Developer's Guide";
    private static final String GENRE = "Computer";
    private static final Double PRICE = 44.95D;
    private static final Date PUBLISH_DATE = new Date(5000L);
    private static final String DESCRIPTION = "An in-depth look at creating applications with XML.";

    @Test
    public void testMarshaller() throws JAXBException {
        Publication publication1 = new PublicationImpl();
        publication1.setId(ID);
        publication1.setAuthor(AUTHOR);
        publication1.setTitle(TITLE);
        publication1.setGenre(GENRE);
        publication1.setPrice(PRICE);
        publication1.setPublishDate(PUBLISH_DATE);
        publication1.setDescription(DESCRIPTION);

        Catalog catalog = new CatalogImpl();
        HashSet<Publication> publications = new HashSet<Publication>();
        publications.add(publication1);
        catalog.setPublications(publications);

        JAXBContext jaxbContext = JAXBContext.newInstance(CatalogImpl.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(catalog, System.out);

    }

    @Test
    public void testUnmarshall() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CatalogImpl.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Catalog catalog = (Catalog) jaxbUnmarshaller.unmarshal(getClass().getResourceAsStream("/input.xml"));
        assertEquals(catalog.getPublications().size(), 12);
        Publication publication = new PublicationImpl();
        publication.setId("bk102");
        assertTrue(catalog.getPublications().contains(publication));
    }
}