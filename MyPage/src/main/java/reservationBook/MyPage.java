package reservationBook;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Integer bookId;
        private Integer reservationId;
        private Integer rentalId;
        private String bookName;
        private String reservationStatus;
        private String rentalStatus;
        private Date reservationDate;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Integer getBookId() {
            return bookId;
        }

        public void setBookId(Integer bookId) {
            this.bookId = bookId;
        }
        public Integer getReservationId() {
            return reservationId;
        }

        public void setReservationId(Integer reservationId) {
            this.reservationId = reservationId;
        }
        public Integer getRentalId() {
            return rentalId;
        }

        public void setRentalId(Integer rentalId) {
            this.rentalId = rentalId;
        }
        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }
        public String getReservationStatus() {
            return reservationStatus;
        }

        public void setReservationStatus(String reservationStatus) {
            this.reservationStatus = reservationStatus;
        }
        public String getRentalStatus() {
            return rentalStatus;
        }

        public void setRentalStatus(String rentalStatus) {
            this.rentalStatus = rentalStatus;
        }
        public Date getReservationDate() {
            return reservationDate;
        }

        public void setReservationDate(Date reservationDate) {
            this.reservationDate = reservationDate;
        }

}
