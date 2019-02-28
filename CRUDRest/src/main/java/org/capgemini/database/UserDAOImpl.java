package org.capgemini.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import org.capgemini.model.User;
import org.capgemini.util.DBConnection;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	PreparedStatement preparedStatement;
	
	@Override
	public boolean create(User user) {
		try {
			preparedStatement = DBConnection.getConnection().prepareStatement("INSERT INTO users VALUES (userIdSeq.nextval,?,?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getGender());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public TreeSet<User> readAll() {
		TreeSet<User> users;
		try {
			ResultSet userRecords;
			preparedStatement = DBConnection.getConnection().prepareStatement("SELECT * FROM users");
			userRecords = preparedStatement.executeQuery();
			users = new TreeSet<User>();
			while(userRecords.next()) 
				users.add(new User(userRecords.getInt(1),userRecords.getString(2),userRecords.getInt(3),userRecords.getString(4)));
			return users;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean update(User user) {
		String query= "UPDATE users SET";
		try {
			if(user.getName()!=null)
				query += " name='"+user.getName()+"',";
			if(user.getAge()>0)
				query += "age="+user.getAge()+",";
			if(user.getGender()!=null)
				query += " gender='"+user.getGender()+"'";
			else
				query = query.substring(0, query.length()-1);
			query += " WHERE userid="+user.getId();
			Statement statement = DBConnection.getConnection().createStatement();
			System.out.println(query);
			if(statement.executeUpdate(query)>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			preparedStatement = DBConnection.getConnection().prepareStatement("DELETE FROM users WHERE userid=?");
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate()>0)
				return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}