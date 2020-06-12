package store.domain;

import java.io.Serializable;
import java.util.Date;

public class IpRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int user_id; // 用户编号
	private short role; // 用户角色, 0为普通用户，1为管理员, 2为销售人员
	private String ip;
	private Date opTime;// 最后操作时间
	private short opType;//操作类型，0为登录，1为退出
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
	 * @return the role
	 */
	public short getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(short role) {
		this.role = role;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the opTime
	 */
	public Date getOpTime() {
		return opTime;
	}
	/**
	 * @param opTime the opTime to set
	 */
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}
	/**
	 * @return the opType
	 */
	public short getOpType() {
		return opType;
	}
	/**
	 * @param opType the opType to set
	 */
	public void setOpType(short opType) {
		this.opType = opType;
	}

}
