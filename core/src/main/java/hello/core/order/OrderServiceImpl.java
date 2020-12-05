package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //final 이 붙은 애들을 생성자로 만들어줌
public class OrderServiceImpl implements OrderService{

    //@Autowired //필드 Autowired 시 테스트에 Repository 할당 방법이 없다.....
    private final MemberRepository  memberRepository;
    //private  DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //@Autowired
    private final DiscountPolicy discountPolicy;

/*    
    //수정자 주입
    @Autowired(required = false) //구지 필요 없어
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("SetterMemberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("SetterDiscountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }*/

/*
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
*/

/*    @Autowired // 일반 메서드에서도 Autowired 사용 가능
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
