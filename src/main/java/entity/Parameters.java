package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameters {


	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getIce1() {
		return ice1;
	}

	public void setIce1(String ice1) {
		this.ice1 = ice1;
	}

	public String getIngredients1() {
		return ingredients1;
	}

	public void setIngredients1(String ingredients1) {
		this.ingredients1 = ingredients1;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public String getUser_name1() {
		return user_name1;
	}

	public void setUser_name1(String user_name1) {
		this.user_name1 = user_name1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	private String name;
	private String ice;
	private String ingredients;
	private int number;
	private String user_name;
	
	@JsonProperty("name.original")
	private String name1;
	@JsonProperty("ice.original")
	private String ice1;
	@JsonProperty("ingredients.original")
	private String ingredients1;
	@JsonProperty("number.original")
	private int number1;
	@JsonProperty("user_name.original")
	private String user_name1;

	
}
