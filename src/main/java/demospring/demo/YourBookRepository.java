package demospring.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary //INFO : 같은 interface 를 상속받는 다중의 Repository 존재시 해당 Repository 를 상속 받도록 지정해주는 어노테이션
public class YourBookRepository implements BookRepository {
}
