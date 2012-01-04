package com.copyright.domain;

import java.io.Serializable;
import java.util.Date;

public interface Publication extends Serializable {

    String getId();

    void setId(String id);

    String getAuthor();

    void setAuthor(String author);

    String getTitle();

    void setTitle(String title);

    String getGenre();

    void setGenre(String genre);

    Double getPrice();

    void setPrice(Double price);

    Date getPublishDate();

    void setPublishDate(Date publishDate);

    String getDescription();

    void setDescription(String description);
}
