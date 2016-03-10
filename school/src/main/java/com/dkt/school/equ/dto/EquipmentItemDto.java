package com.dkt.school.equ.dto;

import com.dkt.school.equ.model.EquipmentItem;

public class EquipmentItemDto extends EquipmentItem{
	
	private String buyDateString;

	private String useStatusStr;
	
	private String storageName;
	
	private String dateOfOutStr;
	
	private String dateOfDealineStr;
	
	//要显示的设备种类
	private Integer categoryId;
	//要显示的设备种类
	private String category;
	//要显示的设备名称
	private String name;
	//要显示的设备品牌
	private String brand;
	//要显示的设备型号
	private String model;
	//要显示的存放地点建筑
	private String building;
	//要显示的存放地点名称
	private String store;
	//要显示的存放房间
	private String room;
	//要显示的设备购买日期
	private String buyTime;
	//要显示的设备来源
	private String sourceStr;
	
	public String getSourceStr() {
		return sourceStr;
	}

	public void setSourceStr(String sourceStr) {
		this.sourceStr = sourceStr;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public String getDateOfDealineStr() {
		return dateOfDealineStr;
	}

	public void setDateOfDealineStr(String dateOfDealineStr) {
		this.dateOfDealineStr = dateOfDealineStr;
	}

	public String getDateOfOutStr() {
		return dateOfOutStr;
	}

	public void setDateOfOutStr(String dateOfOutStr) {
		this.dateOfOutStr = dateOfOutStr;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getUseStatusStr() {
		return useStatusStr;
	}

	public void setUseStatusStr(String useStatusStr) {
		this.useStatusStr = useStatusStr;
	}

	public String getBuyDateString() {
		return buyDateString;
	}

	public void setBuyDateString(String buyDateString) {
		this.buyDateString = buyDateString;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "EquipmentItemDto [buyDateString=" + buyDateString
				+ ", useStatusStr=" + useStatusStr + ", storageName="
				+ storageName + ", dateOfOutStr=" + dateOfOutStr
				+ ", dateOfDealineStr=" + dateOfDealineStr + ", category="
				+ category + ", name=" + name + ", brand=" + brand + ", model="
				+ model + ", building=" + building + ", store=" + store
				+ ", room=" + room + ", buyTime=" + buyTime + ", sourceStr="
				+ sourceStr + "]";
	}

	
	
	
}
