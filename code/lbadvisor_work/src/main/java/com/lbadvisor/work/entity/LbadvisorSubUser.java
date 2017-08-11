package com.lbadvisor.work.entity;

import java.util.Date;


/**
 * 
 * <B>功能简述</B><br>
 * LbadvisorSubUser实体类
 * 
 * @date 2017年08月11日 12:56:54
 * @since     [工作日志 / LbadvisorSubUser v1.0]
 */
public class LbadvisorSubUser{

	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private int subUserId;
	/**
	 * 
	 */
	private int checkUserId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String backup;
	/**
	 * 
	 */
	private String backup2;


	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public int getSubUserId(){
		return this.subUserId;
	}
	
	public void setSubUserId(int subUserId){
		this.subUserId = subUserId;
	}

	public int getCheckUserId(){
		return this.checkUserId;
	}
	
	public void setCheckUserId(int checkUserId){
		this.checkUserId = checkUserId;
	}

	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public String getBackup(){
		return this.backup;
	}
	
	public void setBackup(String backup){
		this.backup = backup;
	}

	public String getBackup2(){
		return this.backup2;
	}
	
	public void setBackup2(String backup2){
		this.backup2 = backup2;
	}
	
	/**
	 * 无参构造
	 */
	public LbadvisorSubUser(){
	
	}
	
} 