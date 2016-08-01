package entity;

public class Contexts {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	public int getLifespan() {
		return lifespan;
	}
	public void setLifespan(int lifespan) {
		this.lifespan = lifespan;
	}
	private String name;
	private Parameters parameters;
	private int lifespan;

}
