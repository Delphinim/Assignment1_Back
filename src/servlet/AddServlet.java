package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDao;

import java.io.IOException;

@WebServlet("/add")
@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Book book = new Book();
        String bookName = req.getParameter("bookName");
        int bookSex = Integer.parseInt(req.getParameter("bookSex"));
        String bookAdd = req.getParameter("bookAdd");
        String bookTel = req.getParameter("bookTel");
        book.setBookTel(bookTel);
        book.setBookName(bookName);
        book.setBookAdd(bookAdd);
        book.setBookSex(bookSex);
        BookDao bookDao = new BookDao();
        bookDao.addBook(book);
        req.getRequestDispatcher("").forward(req, resp);
    }
}
