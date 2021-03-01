package scope.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/*
* INFO : Scope("prototype") 어노테이션은 호출시 마다 새로운 인스턴스가 생성되도록 하는것
* 문제점 : 다른 컴포넌트에서 Proto 클래스 주입시 인스턴스 값은 고정되므로 의도되로 동작 X
* 해결법 : proxyMode 로 프록씨로 클래스를 감싼다 (직접참조를 막는것)
*/
@Component @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Proto {

    @Autowired
    Single single;

}
