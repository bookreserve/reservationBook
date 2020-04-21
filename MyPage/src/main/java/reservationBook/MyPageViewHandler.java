package reservationBook;

import reservationBook.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {


    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                MyPage myPage = new MyPage();
                // view 객체에 이벤트의 Value 를 set 함
                myPage.setBookId(reserved.getBookId());
                myPage.setReservationId(Integer.parseInt(reserved.getId().toString()));
                myPage.setBookName(reserved.getBookName());
                myPage.setReservationStatus(reserved.getReservationStatus());
                myPage.setReservationDate(reserved.getReservationDate());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceled_then_UPDATE_1(@Payload ReservationCanceled reservationCanceled) {
        try {
            if (reservationCanceled.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByReservationId(Integer.parseInt(reservationCanceled.getId().toString()));
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setReservationStatus(reservationCanceled.getReservationStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRented_then_UPDATE_2(@Payload Rented rented) {
        try {
            if (rented.isMe()) {
                // view 객체 조회

                List<MyPage> myPageList = myPageRepository.findByReservationId(rented.getReservationId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setRentalId(Integer.parseInt(rented.getId().toString()));
                    myPage.setRentalStatus(rented.getRentalStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReturned_then_UPDATE_3(@Payload Returned returned) {
        try {
            if (returned.isMe()) {
                // view 객체 조회

                List<MyPage> myPageList = myPageRepository.findByReservationId(returned.getReservationId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setRentalStatus(returned.getRentalStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
                myPageList = myPageRepository.findByRentalId(Integer.parseInt(returned.getId().toString()));
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setRentalStatus(returned.getRentalStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}