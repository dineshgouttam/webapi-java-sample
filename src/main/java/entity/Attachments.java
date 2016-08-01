package entity;

public class Attachments {
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getThumb_url() {
		return thumb_url;
	}
	public void setThumb_url(String thumb_url) {
		this.thumb_url = thumb_url;
	}
	public String[] getMrkdwn_in() {
		return mrkdwn_in;
	}
	public void setMrkdwn_in(String[] mrkdwn_in) {
		this.mrkdwn_in = mrkdwn_in;
	}
	private String text;
	private String thumb_url;
	private String[] mrkdwn_in;
	
}
