package demospring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceRunner{ //implements ApplicationRunner {

    @Autowired
    BookService bookService;

/*
    INFO : Runner 는 Application 이 구동이 다된후 작동함 (존재하는 runner 를 모두 한번씩 동작함)
    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookService.printBookRepository();
    }*/
}

