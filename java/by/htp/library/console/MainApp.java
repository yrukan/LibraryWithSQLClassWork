package by.htp.library.console;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoDBImpl;

public class MainApp {

	public static void main(String[] args) {
		
		BookDao dao = new BookDaoDBImpl();
		
		List<Book> books = dao.readAll();
		
		for(Book book: books){
			System.out.println(book.toString());
		}
		

	}

}
