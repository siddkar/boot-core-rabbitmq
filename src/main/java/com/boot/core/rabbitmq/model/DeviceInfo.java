package com.boot.core.rabbitmq.model;

import uk.co.jemos.podam.common.PodamIntValue;
import uk.co.jemos.podam.common.PodamStringValue;

public class DeviceInfo {

	@PodamIntValue(minValue = 1, maxValue = Integer.MAX_VALUE)
	private int deviceId;
	@PodamStringValue
	private String deviceName;
	private DeviceDetailsInfo deviceDetailsInfo;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public DeviceDetailsInfo getDeviceDetailsInfo() {
		return deviceDetailsInfo;
	}

	public void setDeviceDetailsInfo(DeviceDetailsInfo deviceDetailsInfo) {
		this.deviceDetailsInfo = deviceDetailsInfo;
	}

	@Override
	public String toString() {
		return "{ deviceId: " + deviceId + ", deviceName: " + deviceName + ", { " + deviceDetailsInfo.toString()
				+ " } }";
	}
}
