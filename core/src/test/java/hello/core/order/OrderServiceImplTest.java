package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        // 생성자에 @Autowired 를 줘야 하는 이유
        // 클래스 private 변수에 @Autowired 사용시 순수한 자바 코드에서 테스트를 진행할 방법이 없다.
        //OrderServiceImpl orderService = new OrderServiceImpl();

        // 생성자에 @Autowired 사용시 final 키워드가 사용 가능하다 -> 컴파일 에러로 오류를 잡을수 있다.
        // 생성자 이외의 @Autowired 는 Class 가 생성된 이후에 이루어 지기 때문에 final 키워드를 사용할 수 없다.


        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "jimbae", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());


        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}