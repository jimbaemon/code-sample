package jimbae.inflearnjavatest;

import java.util.Optional;

public interface MemberService {
	Optional<Member> findById(Long memberId) throws MemberNotFoundException;
}
