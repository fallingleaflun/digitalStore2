package store.domain;

import store.domain.Order;
import store.domain.Product;

public class OrderItem {
	private Order order;
	private Product p;
	private int buynum;
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	/**
	 * @return the p
	 */
	public Product getP() {
		return p;
	}
	/**
	 * @param p the p to set
	 */
	public void setP(Product p) {
		this.p = p;
	}
	/**
	 * @return the buynum
	 */
	public int getBuynum() {
		return buynum;
	}
	/**
	 * @param buynum the buynum to set
	 */
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
}
