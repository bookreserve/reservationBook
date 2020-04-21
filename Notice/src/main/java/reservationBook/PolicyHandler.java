package reservationBook;

import reservationBook.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_Notice(@Payload ReservationCanceled reservationCanceled){

        if(reservationCanceled.isMe()){
            System.out.println("##### listener Notice : " + reservationCanceled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReturned_Notice(@Payload Returned returned){

        if(returned.isMe()){
            System.out.println("##### listener Notice : " + returned.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRented_Notice(@Payload Rented rented){

        if(rented.isMe()){
            System.out.println("##### listener Notice : " + rented.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_Notice(@Payload Reserved reserved){

        if(reserved.isMe()){
            System.out.println("##### listener Notice : " + reserved.toJson());
        }
    }

}
