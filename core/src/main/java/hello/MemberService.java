package hello;

import hello.member.Member;

public interface MemberService {

    public int joinMember(Member member);

    public Member selectMember(Member member);
}
