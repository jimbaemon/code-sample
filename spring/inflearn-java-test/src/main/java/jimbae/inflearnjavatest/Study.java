package jimbae.inflearnjavatest;

public class Study {

	private StudyStatus status;

	private int limit;

	public Study(int limit) {
		if(limit < 0) {
			throw new IllegalArgumentException("limit 은 0 보다 커야 한다.");
		}
		this.limit = limit;
	}

	public StudyStatus getStatus() {
		return this.status = StudyStatus.DRAFT;
	}

	public int getLimit() {
		return limit;
	}
}
