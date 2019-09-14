package pl.terminal.server.domain.need;

public class NeedRequestId {

	private final String id;

	public NeedRequestId(String id) {
		this.id = id;
	}

	public String getInternal() {
		return id;
	}
}
