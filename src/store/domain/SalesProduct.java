package store.domain;

public class SalesProduct {
	private int user_id; // 用户编号
	private int procuct_id; // 商品编号
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
	 * @return the procuct_id
	 */
	public int getProcuct_id() {
		return procuct_id;
	}
	/**
	 * @param procuct_id the procuct_id to set
	 */
	public void setProcuct_id(int procuct_id) {
		this.procuct_id = procuct_id;
	}
}
