package store.domain;

public class UserPortrait {
	private int id; // 用户编号
	private String username; // 用户姓名
	private int product_id; // 浏览最多的商品编号
	private String category; // 浏览最多的商品类型
	private int freq_login_time; // 登录最多的时段编号,1是5点到12点，2是12点到18点，3是18点到0点以及0点到5点
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the freq_login_time
	 */
	public int getFreq_login_time() {
		return freq_login_time;
	}
	/**
	 * @param freq_login_time the freq_login_time to set
	 */
	public void setFreq_login_time(int freq_login_time) {
		this.freq_login_time = freq_login_time;
	}
}
