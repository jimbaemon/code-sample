package study.querydsl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

    private String username;
    private int age;

    public MemberDto(String username, int age) {
        System.out.println(this.hashCode());
        System.out.println("콘스트럭터 타쪄염!!!!");
        this.username = username;
        this.age = age;
    }
}
