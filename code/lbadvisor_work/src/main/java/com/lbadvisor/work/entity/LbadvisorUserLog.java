package com.lbadvisor.work.entity;

import java.util.Date;


/**
 * 
 * <B>功能简述</B><br>
 * LbadvisorUserLog实体类
 * 
 * @date 2017年08月11日 10:17:31
 * @since     [工作日志 / LbadvisorUserLog v1.0]
 */
public class LbadvisorUserLog{

	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private int userId;
	/**
	 * 
	 */
	private String userLog;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private int workHour;
	/**
	 * 
	 */
	private String workProudctName;
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

	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}

	public String getUserLog(){
		return this.userLog;
	}
	
	public void setUserLog(String userLog){
		this.userLog = userLog;
	}

	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public int getWorkHour(){
		return this.workHour;
	}
	
	public void setWorkHour(int workHour){
		this.workHour = workHour;
	}

	public String getWorkProudctName(){
		return this.workProudctName;
	}
	
	public void setWorkProudctName(String workProudctName){
		this.workProudctName = workProudctName;
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
	public LbadvisorUserLog(){
	
	}
	
} 