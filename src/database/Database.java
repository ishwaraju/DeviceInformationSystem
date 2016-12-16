package database;
import java.sql.*;
import java.util.ArrayList;

import model.Device;
public class Database {
	static Connection getConnection()throws Exception{
		Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/db","root","root");  
		return con;
	}
	public Device addDevice(Device device){
		try{ 
			Connection con = Database.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into device(deviceName,ipAddress,modelName,snmpConfigVersion,snmpConfigCommunityString,snmpConfigPort) values (?,?,?,?,?,?)");
			stmt.setString(1, device.getdeviceName());
			stmt.setString(2, device.getipAddress());
			stmt.setString(3, device.getmodelName());
			stmt.setString(4, device.getSnmpConfigVersion());
			stmt.setString(5, device.getSnmpConfigCommunityString());
			stmt.setString(6, device.getSnmpConfigPort());
			int i = stmt.executeUpdate();
			System.out.println(i+ " record inserted");
			con.close();
		}catch(SQLException sql){
			System.out.println("problem in inserting record. Please check the fields values");
		}
		catch(Exception e){System.out.println(e);}
		return device;
	}
	public Device getDevice(int id){
		Device device = new Device();
		try{
			Connection con = Database.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from device where id = ?");
			stmt.setInt(1, id);
			ResultSet rs= stmt.executeQuery();
			System.out.println(rs);
			if(rs.next()){
				device.setId(id);
				device.setdeviceName(rs.getString("deviceName"));
				device.setipAddress(rs.getString("ipAddress"));
				device.setmodelName(rs.getString("modelName"));
				device.setSnmpConfigVersion(rs.getString("snmpConfigVersion"));
				device.setSnmpConfigCommunityString(rs.getString("snmpConfigCommunityString"));
				device.setSnmpConfigPort(rs.getString("snmpConfigPort"));
			}
			
		}catch(Exception e){e.printStackTrace();}
		return device;
	}
	public ArrayList<Device> getDevices() {
		ArrayList<Device> deviceList = new ArrayList<Device>();
		try{
			Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from device");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Device device = new Device();
				device.setId(rs.getInt("id"));
				device.setdeviceName(rs.getString("deviceName"));
				device.setipAddress(rs.getString("ipAddress"));
				device.setmodelName(rs.getString("modelName"));
				device.setSnmpConfigVersion(rs.getString("snmpConfigVersion"));
				device.setSnmpConfigCommunityString(rs.getString("snmpConfigCommunityString"));
				device.setSnmpConfigPort(rs.getString("snmpConfigPort"));
				deviceList.add(device);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return deviceList;
	}
	public Device deleteDevice(int id) {
		int i=0;
		Device device = null;
		try{
			Connection con = Database.getConnection();
			device = getDevice(id);
			PreparedStatement ps = con.prepareStatement("delete from device where id = ?");
			ps.setInt(1, id);
			i = ps.executeUpdate();
			System.out.println(i+ " record deleted");
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return device;
	}
	public Device updateDevice(Device device) {
		int i=0;
		if(device.getId()<=0)
			return null;
		try{
			Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement("update device set deviceName=?,ipAddress=?,modelName=?,snmpConfigVersion=?,snmpConfigCommunityString=?,snmpConfigPort=? where id=?");
			ps.setString(1, device.getdeviceName());
			ps.setString(2, device.getipAddress());
			ps.setString(3, device.getmodelName());
			ps.setString(4, device.getSnmpConfigVersion());
			ps.setString(5, device.getSnmpConfigCommunityString());
			ps.setString(6, device.getSnmpConfigPort());
			ps.setInt(7, device.getId());
			i = ps.executeUpdate();
			System.out.println(i+ " record updated");
			con.close();
		}catch(SQLException sql){
			System.out.println("problem in inserting record. Please check the fields values");
		}
		
		catch(Exception e){
			e.printStackTrace();
		}		
		return device;
	}
}
