package org.example.exam24_25.Model.DAO;

import org.example.exam24_25.Model.Borrow;
import org.example.exam24_25.Model.Document;
import org.example.exam24_25.Model.User;

import java.util.List;

public interface BorrowDao {

    public List<Borrow> listCurrentBorrows();
    public void borrowDocument(User user, Document document);
    public void returnDocument(Long borrowId);
}
