package sample.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.datajpa.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
