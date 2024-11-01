package bean;

public class Book {

    private Integer bookId;
    private String bookName;
    private Integer bookSex;
    private String bookAdd;
    private String bookTel;



    //编号
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    //姓名
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    //性别
    public Integer getBookSex() {
        return bookSex;
    }

    public void setBookSex(Integer bookSex) {
        this.bookSex = bookSex;
    }
    //地址
    public String getBookAdd() {
        return bookAdd;
    }

    public void setBookAdd(String bookAdd) {
        this.bookAdd = bookAdd;
    }
    //电话
    public String getBookTel() {
        return bookTel;
    }

    public void setBookTel(String bookTel) {
        this.bookTel = bookTel;
    }

    public Book() {
    }
    }

