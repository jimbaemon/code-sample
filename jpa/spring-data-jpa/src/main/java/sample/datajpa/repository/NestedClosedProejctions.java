package sample.datajpa.repository;

public interface NestedClosedProejctions {
	String getUsername();
	TeamInfo getTeam();

	interface TeamInfo{
		String getName();
	}
}
