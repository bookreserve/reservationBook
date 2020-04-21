package reservationBook;

public class BookStatusChanged extends AbstractEvent {

    private Long id;
    private String bookStatus;

    public BookStatusChanged(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
