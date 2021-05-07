package jimbae.inflearnjavatest;

public class Study {

	private StudyStatus status;

	private int limit;

	private String name;

	public Study(int limit) {
		if(limit < 0) {
			throw new IllegalArgumentException("limit 은 0 보다 커야 한다.");
		}
		this.limit = limit;
	}

	public Study(int limit, String name) {
		if(limit < 0) {
			throw new IllegalArgumentException("limit 은 0 보다 커야 한다.");
		}
		this.limit = limit;
		this.name = name;
	}

	public StudyStatus getStatus() {
		return this.status = StudyStatus.DRAFT;
	}

	@Override
	public String toString() {
		return "Study{" +
			"status=" + status +
			", limit=" + limit +
			", name='" + name + '\'' +
			'}';
	}

	public int getLimit() {
		return limit;
	}
}
