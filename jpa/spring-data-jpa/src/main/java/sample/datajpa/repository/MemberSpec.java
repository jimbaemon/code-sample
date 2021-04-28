package sample.datajpa.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import sample.datajpa.entity.Member;
import sample.datajpa.entity.Team;

public class MemberSpec {
	public static Specification<Member> teamName(final String teamName){
		return new Specification<Member>() {
			@Override
			public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				if(StringUtils.isEmpty(teamName)){
					return null;
				}

				Join<Member, Team> team = root.join("team", JoinType.INNER);//회원과 조인
				return criteriaBuilder.equal(team.get("name"), teamName);
			}
		};
	}

	public static Specification<Member> username(final String username){
		return (Specification<Member>) (root, query, criteriaBuilder) ->
			 criteriaBuilder.equal(root.get("username"), username);
	}
}
