package org.example.exam24_25.Model.DAO;
import org.example.exam24_25.Model.Document;

import java.util.List;

public interface DocumentDao {
    public List<Document> getAllDocuments();
    public Document getDocumentById(Long docId);

}
