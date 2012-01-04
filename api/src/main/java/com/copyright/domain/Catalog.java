package com.copyright.domain;

import java.util.Set;

public interface Catalog {

    Set<Publication> getPublications();

    void setPublications(Set<Publication> publications);
}
