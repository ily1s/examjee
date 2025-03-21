package org.example.exam24_25.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Book extends Document {
    private String author;
    private String isbn;
    @Temporal(TemporalType.DATE)
    private Date datePublishion;




}
