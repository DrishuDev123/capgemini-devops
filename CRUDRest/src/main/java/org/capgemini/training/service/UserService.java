package org.capgemini.training.service;

import java.util.TreeSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.capgemini.database.UserDAOImpl;
import org.capgemini.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

	@Autowired
    UserDAOImpl userDAOImpl;
	
	public UserService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		userDAOImpl = context.getBean("userDAOImpl", UserDAOImpl.class);
		((AbstractApplicationContext) context).close();
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TreeSet<User> readUsers() {
    	userDAOImpl.readAll();
        return userDAOImpl.readAll();
    }
    
    @DELETE
	@Path("/{userid}")
    public String deleteUser(@PathParam("userid") int userId) {
    	userDAOImpl = new UserDAOImpl();
    	if(userDAOImpl.delete(userId))
    		return "User deleted successfully";
    	else
    		return "User doesn't exists";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createUser(User user) {
    	userDAOImpl = new UserDAOImpl();
    	if(userDAOImpl.create(user))
    		return "Created successfully";
    	else
    		return "Created successfully";
    }
    
    @PUT
    @Path("/{userid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateUser(@PathParam("userid") int userId, User user) {
    	userDAOImpl = new UserDAOImpl();
    	user.setId(userId);
    	if(userDAOImpl.update(user))
    		return "Updated successfully";
    	else
    		return "Updated unsuccessfull";
    }

	public UserDAOImpl getUserDAOImpl() {
		return userDAOImpl;
	}

	public void setUserDAOImpl(UserDAOImpl userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}
    
}