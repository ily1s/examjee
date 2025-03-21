package org.example.exam24_25.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class Magazine extends Document {
    private String publisher;
    private String issueNumber;
    @Temporal(TemporalType.DATE)
    private Date dateIssue;


}
