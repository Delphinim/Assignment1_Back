package dao;

import bean.Book;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    /**
     * 所有学生信息
     *
     * @return
     */
    public List<Book> selectBook() {
        List<Book> bookList = new ArrayList<>();

        String sql = "select * from book";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Book book = new Book();
                book.setBookId(rst.getInt("book_id"));
                book.setBookName(rst.getString("book_name"));
                book.setBookSex(rst.getInt("book_sex"));
                book.setBookAdd(rst.getString("book_add"));
                book.setBookTel(rst.getString("book_tel"));
                bookList.add(book);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    /**
     * 添加学生
     *
     * @param book
     * @return
     */
    public boolean addBook(Book book) {
        String sql = "INSERT INTO book(book_name,book_sex,book_add,book_tel) VALUES(?,?,?,?);";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, book.getBookName());
            pst.setInt(2, book.getBookSex());
            pst.setString(3, book.getBookAdd());
            pst.setString(4, book.getBookTel());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 修改学生信息
     *
     * @param book
     * @return
     */
    public boolean updateBook(Book book) {
        String sql = "UPDATE book set book_name=?,book_sex=?,book_add=?,book_tel=? WHERE book_id=?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, book.getBookName());
            pst.setInt(2, book.getBookSex());
            pst.setString(3, book.getBookAdd());
            pst.setString(4, book.getBookTel());
            pst.setInt(5, book.getBookId());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除学生信息
     *
     * @param bookId
     * @return
     */
    public boolean deleteBook(int bookId) {
        String sql = "delete from book where book_id = ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, bookId);
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更具id查询学生
     *
     * @param bookId
     * @return
     */
    public Book getBookById(int bookId) {

        String sql = "select * from book where book_id = " + bookId;
        Book book = new Book();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                book.setBookId(rst.getInt("book_id"));
                book.setBookName(rst.getString("book_name"));
                book.setBookSex(rst.getInt("book_sex"));
                book.setBookAdd(rst.getString("book_add"));
                book.setBookTel(rst.getString("book_tel"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    //条件查询
    public List<Book> getBookName(String bookName) {
        List<Book> list = new ArrayList<>();

        String sql = " select * from book where book_name =" + bookName;
        Book book = new Book();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                book.setBookId(rst.getInt("book_id"));
                book.setBookName(rst.getString("book_name"));
                book.setBookSex(rst.getInt("book_sex"));
                book.setBookAdd(rst.getString("book_add"));
                book.setBookTel(rst.getString("book_tel"));
                list.add(book);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
