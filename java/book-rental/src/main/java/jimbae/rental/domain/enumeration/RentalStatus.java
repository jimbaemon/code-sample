package jimbae.rental.domain.enumeration;

import jimbae.rental.domain.Rental;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RentalStatus {
	RENT_AVAILABLE(0, "대출가능", "대출가능상태"),
	RENT_UNAVAILABLE(1, "대출불가", "대출불가능상태");

	private Integer id;
	private String title;
	private String description;

}
