package hello.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class HelloLombok {

    private String name;
    private String age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
    }
}
