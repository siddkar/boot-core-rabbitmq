package com.boot.core.rabbitmq.model;

import uk.co.jemos.podam.common.PodamIntValue;
import uk.co.jemos.podam.common.PodamStringValue;

public class DeviceDetailsInfo {

	@PodamStringValue(length = 12)
	private String location;
	@PodamIntValue(minValue = 1, maxValue = 128)
	private int ram;
	@PodamIntValue(minValue = 128, maxValue = 500)
	private int hdd;
	@PodamStringValue
	private String cpu;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getHdd() {
		return hdd;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return "location: " + location + ", ram: " + ram + ", hdd: " + hdd + ", cpu" + cpu;
	}

}
