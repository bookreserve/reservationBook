package reservationBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
 public class BookController {

  @Autowired
  BookRepository bookRepository;

  @PostMapping("/book")
  Book bookInsert(@RequestBody Book book) {
   return bookRepository.save(book);
  }

  @RequestMapping(method= RequestMethod.PATCH, path="/bookupdate")
  public void bookStatusChange01(@RequestBody Book book){
   Book tmp = new Book();
   Optional<Book> bookOtl = bookRepository.findById(book.getId());
   tmp = bookOtl.get();
   book.setBookName(tmp.getBookName());
   bookRepository.save(book);
  }


 }
