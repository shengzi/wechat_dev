package com.lbadvisor.work.entity;

import java.util.Date;


/**
 * 
 * <B>功能简述</B><br>
 * LbadvisorUser实体类
 * 
 * @date 2017年08月11日 12:56:54
 * @since     [工作日志 / LbadvisorUser v1.0]
 */
public class LbadvisorUser{

	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String openid;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String country;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String nickName;
	/**
	 * 
	 */
	private String photo;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private String appId;
	/**
	 * 
	 */
	private int gender;
	/**
	 * 
	 */
	private String backup;
	/**
	 * 
	 */
	private String backup2;
	/**
	 * 
	 */
	private String province;


	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getOpenid(){
		return this.openid;
	}
	
	public void setOpenid(String openid){
		this.openid = openid;
	}

	public String getCity(){
		return this.city;
	}
	
	public void setCity(String city){
		this.city = city;
	}

	public String getCountry(){
		return this.country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getNickName(){
		return this.nickName;
	}
	
	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public String getPhoto(){
		return this.photo;
	}
	
	public void setPhoto(String photo){
		this.photo = photo;
	}

	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}

	public String getAppId(){
		return this.appId;
	}
	
	public void setAppId(String appId){
		this.appId = appId;
	}

	public int getGender(){
		return this.gender;
	}
	
	public void setGender(int gender){
		this.gender = gender;
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

	public String getProvince(){
		return this.province;
	}
	
	public void setProvince(String province){
		this.province = province;
	}
	
	/**
	 * 无参构造
	 */
	public LbadvisorUser(){
	
	}
	
} 