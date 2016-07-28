package entity;

public class Metadata {
	public String getIntentId() {
		return intentId;
	}
	public void setIntentId(String intentId) {
		this.intentId = intentId;
	}
	public String getIntentName() {
		return intentName;
	}
	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}
	private String intentId;
	private String webhookUsed;
	public String getWebhookUsed() {
		return webhookUsed;
	}
	public void setWebhookUsed(String webhookUsed) {
		this.webhookUsed = webhookUsed;
	}
	private String intentName;
}
