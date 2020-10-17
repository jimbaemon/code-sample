package study.querydsl.entity;
<<<<<<< HEAD

import lombok.*;

=======
import lombok.*;
>>>>>>> 8b94480cb570227a62481c83cd71696f5b7ef704
import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this(username, 0);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if(team != null){
            chageTeam(team);
        }
    }

    public void chageTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
