package hello;

public class WebhookResponse {
    public WebhookResponse(String speech, String displayText, String data) {
		super();
		this.speech = speech;
		this.displayText = displayText;
		this.data = data;
	}
	public String getSpeech() {
		return speech;
	}
	public String getDisplayText() {
		return displayText;
	}
	public String getData() {
		return data;
	}
	public String getSource() {
		return source;
	}
	private final String speech;
    private final String displayText;
    private final String data;
    private final String source = "java-webhook";

}
