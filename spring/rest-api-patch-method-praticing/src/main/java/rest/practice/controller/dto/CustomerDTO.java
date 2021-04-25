package rest.practice.controller.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class CustomerDTO {

	private Long id;
	private String telephone;
	private Collection<String> favorites;
}
