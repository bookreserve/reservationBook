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

    @Autowired
    BookRepository rookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBook_BookListRegist(@Payload Book book){


    }
}
