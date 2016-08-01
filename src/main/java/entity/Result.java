package entity;


public class Result {
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getResolvedQuery() {
		return resolvedQuery;
	}
	public void setResolvedQuery(String resolvedQuery) {
		this.resolvedQuery = resolvedQuery;
	}
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getActionIncomplete() {
		return actionIncomplete;
	}
	public void setActionIncomplete(String actionIncomplete) {
		this.actionIncomplete = actionIncomplete;
	}


	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public Fulfillment getFulfillment() {
		return fulfillment;
	}
	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	private String source;
	private String resolvedQuery;
	private String speech;
	private String action;
	private String actionIncomplete;
	private Parameters parameters;
	private Contexts[] contexts;
	
	public Contexts[] getContexts() {
		return contexts;
	}
	public void setContexts(Contexts[] contexts) {
		this.contexts = contexts;
	}
	private Metadata metadata;
	private Fulfillment fulfillment;
	private Double score;
}
