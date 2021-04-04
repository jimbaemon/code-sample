package sample.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.datajpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
