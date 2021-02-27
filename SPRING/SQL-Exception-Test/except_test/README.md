#스프링 SQLException 반환처리 테스트용 프로젝트

## 제작 계기
- 프로젝트 진행중에 SQLException 에 대한 catch 작업이 제대로 안되는 에러를 발견했다.
확인해보니 스프링 DataSource 쪽에서 좀더 상세하게 Exception 을 변환처리 해주고 있었음
해당 기능이 Spring의 default기능인지 해당 프로젝트를 통해 확인후 아니면
소스의 AOP 혹은 XML 을 추적하여 Config 에서 설정해주는 부분을 찾아준다.


## 1일차...
기본 구조 생성 완료 `service`는 단일로 둘것이기 때문에 구지 interface 로 생성하지는 않는다.
h2 가 문제다.. 버전을 업하면서 'IFEXISTS` 옵션이 `default` 로 true 가 되버려서 골치가 아프다.
처리하고 자야겠다. 

## 2일차...
H2 를 Mybatis 연결 이후 일부러 SQLException 을 발생시켜 보았다.
h2 jdbc 에서 제공하는 Exception이 발생했고 SQLException 을 상속받고 있지 않았다..
각각의 JDBC 가 제공하는 Exception 처리를 따로 해줘야 하는듯 하다.

## 결론
SQLException 처리의 경우 단순하게 SQLException 을 catch 해서는 안되고 각각의
JDBC 가 제공해주는 Exception 처리 방식을 이용해야 한다. 이상