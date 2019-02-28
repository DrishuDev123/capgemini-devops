package org.capgemini.database;

import java.util.TreeSet;

import org.capgemini.model.User;

public interface UserDAO {
	public boolean create(User user);
	public TreeSet<User> readAll();
	public boolean update(User user);
	public boolean delete(int id);
}