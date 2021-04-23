package sample.datajpa.repository;

import java.util.List;

import sample.datajpa.entity.Member;

public interface MemberRepositoryCustom {
	List<Member> findMemberCustom();
}
