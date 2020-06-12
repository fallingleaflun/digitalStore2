package store.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import store.domain.OrderItem;
import store.domain.User;

public class Order {
	private int id; // 订单编号
	private User user; // 订单所属用户
	private double money; // 订单总价
	private String buyerName; // 收货人姓名
	private String buyerTel; // 收货人电话
	private String buyerAddress; // 收货地址
	private int purchased; // 订单是否已支付，0未支付，1已支付
	private Date ordertime; // 下单时间

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * @return the buyerName
	 */
	public String getBuyerName() {
		return buyerName;
	}

	/**
	 * @param buyerName the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	/**
	 * @return the buyerTel
	 */
	public String getBuyerTel() {
		return buyerTel;
	}

	/**
	 * @param buyerTel the buyerTel to set
	 */
	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	/**
	 * @return the buyerAddress
	 */
	public String getBuyerAddress() {
		return buyerAddress;
	}

	/**
	 * @param buyerAddress the buyerAddress to set
	 */
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	/**
	 * @return the purchased
	 */
	public int getPurchased() {
		return purchased;
	}

	/**
	 * @param purchased the purchased to set
	 */
	public void setPurchased(int purchased) {
		this.purchased = purchased;
	}

	/**
	 * @return the ordertime
	 */
	public Date getOrdertime() {
		return ordertime;
	}

	/**
	 * @param ordertime the ordertime to set
	 */
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", money=" + money + ", buyerName=" + buyerName + ", buyerTel="
				+ buyerTel + ", buyerAddress=" + buyerAddress + ", purchased=" + purchased + ", ordertime=" + ordertime
				+ ", orderItems=" + orderItems + "]";
	}
}
