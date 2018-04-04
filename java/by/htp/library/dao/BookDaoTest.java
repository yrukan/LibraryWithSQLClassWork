package by.htp.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.library.bean.Book;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.util.DBConnectionHelper;

public class BookDaoTest {

	private Connection connection;
	private List<Book> expectedList;
	private BookDao dao;

	@BeforeClass
	public void initDefaultConnection() {
		connection = DBConnectionHelper.connect();
		System.out.println("BeforeClass");

	}

	@BeforeMethod
	public void getExpectedList() throws SQLException {
		
		System.out.println("BeforeMethod");
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from books");

		expectedList = new ArrayList<Book>();

		while (rs.next()) {
			expectedList.add(new Book());
		}

		System.out.println("BeforeMethod: actual list was received");
	}

	@BeforeMethod
	public void initDao() {
		dao = new BookDaoDBImpl();

	}

	@Test
	public void testReceivedCorrectCount() {

		List<Book> actualList = dao.readAll();

		Assert.assertEquals(actualList.size(), expectedList.size(),
				"the received number of books is not equal");
		System.out.println("test received books count");

	}

	

	@AfterClass
	public void closeDBConnection() {

		DBConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: disconnected");
	}

	@AfterMethod
	public void cleanDBConnection() {
		expectedList = null;
		System.out.println("AfterMethod");
	}

}
