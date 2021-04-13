package sample.datajpa.dto;

import lombok.Data;

@Data
public class MemberDTO {
	private Long id;
	private String username;
	private String name;

	public MemberDTO(Long id, String username, String name) {
		this.id = id;
		this.username = username;
		this.name = name;
	}
}
