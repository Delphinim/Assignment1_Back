package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDao;

import java.io.IOException;

@WebServlet("/update")
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        BookDao bookDao = new BookDao();
        Book book = bookDao.getBookById(bookId);
        req.setAttribute("book", book);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Book book = new Book();
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        String bookName = req.getParameter("bookName");
        int bookSex = Integer.parseInt(req.getParameter("bookSex"));
        String bookAdd = req.getParameter("bookAdd");
        String bookTel = req.getParameter("bookTel");
        book.setBookId(bookId);
        book.setBookTel(bookTel);
        book.setBookName(bookName);
        book.setBookAdd(bookAdd);
        book.setBookSex(bookSex);
        BookDao bookDao = new BookDao();
        bookDao.updateBook(book);
        req.getRequestDispatcher("").forward(req, resp);
    }
}
