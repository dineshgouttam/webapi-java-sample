package entity;

public class Slack {

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	private String text;
	private Attachments[] attachments;
	public Attachments[] getAttachments() {
		return attachments;
	}
	public void setAttachments(Attachments[] attachments) {
		this.attachments = attachments;
	}
}
