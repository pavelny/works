package com.copyright.domain;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "catalog")
public class CatalogImpl implements Catalog {

    private Set<Publication> publications = new HashSet<Publication>();

    @XmlElement(type = PublicationImpl.class, name = "publication")
    public Set<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }

    @Override
    public String toString() {
        return "CatalogImpl{" +
            "publications=" + publications +
            '}';
    }
}
