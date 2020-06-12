package store.domain;

public class Tomaru {
	int user_id;
	int product_id;
	int state_time;
	int state_jikai;
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	 * @return the state_time
	 */
	public int getState_time() {
		return state_time;
	}
	/**
	 * @param state_time the state_time to set
	 */
	public void setState_time(int state_time) {
		this.state_time = state_time;
	}
	/**
	 * @return the state_jikai
	 */
	public int getState_jikai() {
		return state_jikai;
	}
	/**
	 * @param state_jikai the state_jikai to set
	 */
	public void setState_jikai(int state_jikai) {
		this.state_jikai = state_jikai;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tomaru [user_id=" + user_id + ", product_id=" + product_id + ", state_time=" + state_time
				+ ", state_jikai=" + state_jikai + "]";
	}
}
