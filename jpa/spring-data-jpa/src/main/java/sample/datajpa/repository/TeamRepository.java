package sample.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.datajpa.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
