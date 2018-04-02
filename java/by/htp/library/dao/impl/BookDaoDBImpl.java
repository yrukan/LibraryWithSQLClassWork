package by.htp.library.dao.impl;

import static by.htp.library.dao.util.DBConnectionHelper.connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDao;

public class BookDaoDBImpl implements BookDao {
	private static final String SQL_SELECT_BOOKS = "select * from books";

	public void create(Book entity) {

	}

	public Book read(int id) {

		return null;
	}

	public List<Book> readAll() {
		Connection connection = connect();
		List<Book> books = new ArrayList<Book>();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));

				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return books;
	}

	private void disconnect(Connection connection) {
		// TODO Auto-generated method stub

	}

	public void update(Book entity) {

	}

	public void delete(int id) {

	}

}
