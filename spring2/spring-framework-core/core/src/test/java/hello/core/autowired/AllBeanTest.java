package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountSerivce = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountSerivce.discount(member, 10000, "fixDiscountPolicy");
        assertThat(discountSerivce).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountSerivce.discount(member, 20000, "rateDiscountPolicy");
        assertThat(discountSerivce).isInstanceOf(DiscountService.class);
        assertThat(rateDiscountPrice).isEqualTo(2000);

        int wrongSpellDiscount = discountSerivce.discount(member, 20000, "rrrr");
        assertThat(discountSerivce).isInstanceOf(DiscountService.class);
        assertThat(wrongSpellDiscount).isEqualTo(0);
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            Optional<DiscountPolicy> discountPolicy = Optional.ofNullable(policyMap.get(discountCode));
            return discountPolicy.isEmpty()?0:discountPolicy.get().discount(member, price);
        }
    }

}
