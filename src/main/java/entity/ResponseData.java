package entity;

public class ResponseData {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getAlternateResult() {
		return alternateResult;
	}
	public void setAlternateResult(String alternateResult) {
		this.alternateResult = alternateResult;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getAsr() {
		return asr;
	}
	public void setAsr(String asr) {
		this.asr = asr;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	private String id;
	private Result result;
	private String alternateResult;
	private Status status;
	private String asr;
	private String sessionId;
}
