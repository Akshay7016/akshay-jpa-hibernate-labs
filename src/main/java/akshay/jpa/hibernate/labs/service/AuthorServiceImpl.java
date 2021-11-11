package akshay.jpa.hibernate.labs.service;

import akshay.jpa.hibernate.labs.dao.AuthorDao;
import akshay.jpa.hibernate.labs.dao.AuthorDaoImpl;
import akshay.jpa.hibernate.labs.entities.Author;

public class AuthorServiceImpl implements AuthorService {

	private AuthorDao dao;

	public AuthorServiceImpl() {
		dao = new AuthorDaoImpl();
	}

	@Override
	public void addAuthor(Author author) {
		dao.beginTransaction();
		try {
			dao.addAuthor(author);
			dao.commitTransaction();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void updateAuthor(Author author) {
		dao.beginTransaction();
		dao.updateAuthor(author);
		dao.commitTransaction();
	}

	@Override
	public void removeAuthor(Author author) {
		dao.beginTransaction();
		dao.removeAuthor(author);
		dao.commitTransaction();
	}

	@Override
	public Author findAuthorById(int id) {
		Author author;
		author = dao.getAuthorByAuthorId(id);
		System.out.println("findEmployeeById in EmployeeServiceImpl");
		return author;
	}
}