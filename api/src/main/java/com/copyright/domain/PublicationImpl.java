package com.copyright.domain;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PublicationImpl implements Publication {

    private String id;
    private String author;
    private String title;
    private String genre;
    private Double price;
    private Date publishDate;
    private String description;

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @XmlElement
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlElement
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PublicationImpl that = (PublicationImpl) o;

        if (!getId().equals(that.getId())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "PublicationImpl{" +
            "id='" + id + '\'' +
            ", author='" + author + '\'' +
            ", title='" + title + '\'' +
            ", genre='" + genre + '\'' +
            ", price=" + price +
            ", publishDate=" + publishDate +
            ", description='" + description + '\'' +
            '}';
    }
}
