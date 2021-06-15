package jimbae.rental.domain;

import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jimbae.rental.domain.enumeration.RentalStatus;

@Entity
@Table(name = "rental")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Rental {
	//일련번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//사용자 일련번호
	@Column(name = "user_id")
	private Long userId;

	//대출 가능 여부
	@Enumerated(EnumType.STRING)
	@Column(name = "rental_status")
	private RentalStatus rentalStatus;
	
	//연체료
	@Column(name = "late_fee")
	private Long lateFee;

	//대출아이템
	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<RentedItem> rentedItem = new HashSet<>();

	//연체아이템
}
