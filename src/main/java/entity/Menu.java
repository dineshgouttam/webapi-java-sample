package entity;

public class Menu {

	public Menu(String drinkName, int price, String image_url, boolean isSpecial) {
		super();
		this.drinkName = drinkName;
		this.price = price;
		this.image_url = image_url;
		this.isSpecial = isSpecial;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public boolean isSpecial() {
		return isSpecial;
	}
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
	private String drinkName;
	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	private int price;
	private String image_url;
	private boolean isSpecial;
	
}
