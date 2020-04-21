package reservationBook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyPageRepository extends CrudRepository<MyPage, Long> {

    List<MyPage> findByReservationId(Integer reservationId);
    List<MyPage> findByBookId(Integer bookId);
    List<MyPage> findByRentalId(Integer rentalId);

}