package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.*;

import database.Database;
import model.Device;

@Path("/")
public class DeviceService {
	Database db = new Database();
	
	
	//Add a new Device
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Device addDevice(Device device){
		System.out.println("Device :"+device);
		device=db.addDevice(device);
		return device;
	}
	//Read all devices
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public ArrayList<Device> getDevices(){
		return db.getDevices();
	}
	
	//Read single device by id
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Device getDevice(@PathParam("id") int id){
		Device device = db.getDevice(id);
		return device;
	}
	
	//Update a device
	@Path("{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Device updateDevice(@PathParam("id") int id,Device device){
		device.setId(id);
		return db.updateDevice(device);
	}
	
	//Delete device by id
	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Device deleteDevice(@PathParam("id") int id){
		return db.deleteDevice(id);
	}
	
}