package ru.itgirls.jdbcspringexample.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.itgirls.jdbcspringexample.Books.Book;

import java.util.List;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class BookRepositoryImpl implements BookRepository{

    @Autowired
    private DataSource dataSource;
    public BookRepositoryImpl (DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<Book> findAllBooks() {
        //сложим все книги
        List <Book> result = new ArrayList<Book>();

        //sql запрос
        String SQL_findALLBooks = "select * from books;";

        //connection to DB
        try (Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_findALLBooks)) {
            while (resultSet.next()) {
                Book book = convertRowToBook (resultSet);
                result.add(book);
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    private Book convertRowToBook (ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Book(id,name);
    }
}
