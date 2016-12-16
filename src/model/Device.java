package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Device {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String deviceName;
	private String ipAddress;
	private String modelName;
	private String snmpConfigVersion;
	private String snmpConfigCommunityString;
	private String snmpConfigPort;
	public String getSnmpConfigVersion() {
		if(snmpConfigVersion.trim().equals(""))
			return null;
		return snmpConfigVersion;
	}
	public Device(String deviceName, String ipAddress, String modelName, String snmpConfigVersion,
			String snmpConfigCommunityString, String snmpConfigPort) {
		super();
		this.deviceName = deviceName;
		this.ipAddress = ipAddress;
		this.modelName = modelName;
		this.snmpConfigVersion = snmpConfigVersion;
		this.snmpConfigCommunityString = snmpConfigCommunityString;
		this.snmpConfigPort = snmpConfigPort;
	}
	public void setSnmpConfigVersion(String snmpConfigVersion) {
		this.snmpConfigVersion = snmpConfigVersion;
	}
	public String getSnmpConfigCommunityString() {
		if(snmpConfigCommunityString.trim().equals(""))
			return null;
		return snmpConfigCommunityString;
	}
	public void setSnmpConfigCommunityString(String snmpConfigCommunityString) {
		this.snmpConfigCommunityString = snmpConfigCommunityString;
	}
	public String getSnmpConfigPort() {
		if(snmpConfigPort.trim().equals(""))
			return null;
		return snmpConfigPort;
	}
	public void setSnmpConfigPort(String snmpConfigPort) {
		this.snmpConfigPort = snmpConfigPort;
	}
	//default constructor
	public Device(){
		
	}
	//getter and setter methods
	public String getdeviceName() {
		if(deviceName.trim().equals(""))
			return null;
		return deviceName;
	}

	public void setdeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getipAddress() {
		if(ipAddress.trim().equals(""))
			return null;
		return ipAddress;
	}

	public void setipAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getmodelName() {
		if(modelName.trim().equals(""))
			return null;
		return modelName;
	}

	public void setmodelName(String modelName) {
		this.modelName = modelName;
	}

	
	
}
