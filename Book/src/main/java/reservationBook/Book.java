package reservationBook;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Book_table")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String bookStatus;

    @PostPersist
    public void onPostPersist(){
        BookRegistered bookRegistered = new BookRegistered();
        BeanUtils.copyProperties(this, bookRegistered);
        bookRegistered.publish();


    }

    @PostUpdate
    public void onPostUpdate(){
        BookStatusChanged bookStatusChanged = new BookStatusChanged();
        BeanUtils.copyProperties(this, bookStatusChanged);
        bookStatusChanged.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }




}
