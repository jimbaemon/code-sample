package demospring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService{
    /*
    * 다양한 방법의 @AutoWired 방법이 있지만
    * Primary를 사용하는것을 추천
    * */
    //@Autowired(required = false) INFO : optional
    //@Autowired @Qualifier("yourBookRepository") INFO : 해당하는 클래스를 직접 지정 Camel케이스로
    @Autowired
    BookRepository bookRepository;
    //BookRepository myBookRepository; INFO : 클래스명과 동일하게 변수명을 지정해도 주입이 되긴하는데 비추천

    //@Autowired //INFO : 다중으로 존재하는 Repository 를 List 형식으로 다중으로 주입 가능
    //List<BookRepository> bookRepositories;

/*    public void printBookRepository(){
        //this.bookRepositories.forEach(System.out::println);
        System.out.println(bookRepository.getClass());
        //System.out.println(myBookRepository.getClass());
    }*/

    @PostConstruct //INFO : Initialization 후 중간단계에서의 callback 메소드 (잘모르겠음)
    public void setup(){
        System.out.println(bookRepository.getClass());
    }

    //@Autowired(required = false) INFO : 의존성이 존재할떄만 (Optional)
    //@Autowired INFO : 의존성 상시 주입 (Respoitory 등록 필요)
    /*public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }*/
}
