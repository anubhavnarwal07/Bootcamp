package com.jda.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.Configuration;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.jda.config.SpringConfig;

import com.jda.model.UserModel;

@Repository
public class UserDao implements IUserInterface {

	@Autowired
	private DataSource dataSource;

	@Override
	public int registerUser(UserModel userModel) {
		int id = 0;
		try {
			Connection connection = dataSource.getConnection();
			String query = "insert into User values(?,?,?,?,?)";
			Object[] object = new Object[] { 0, userModel.getName(), userModel.getEmail(), userModel.getUsername(),
			      userModel.getPassword() };
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			id = jdbcTemplate.update(query, object);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public UserModel loginUser(UserModel userModel) {
		//sSystem.out.println("username"+userModel.getUsername());
		String insertQuery = "select * from User where username = ?";
		JdbcTemplate JdbcTemplate = new JdbcTemplate(dataSource);
		try {
			List<UserModel>  listOfUser = JdbcTemplate.query(insertQuery,
			      new Object[] { userModel.getUsername() }, new RowMapper() {
				      public UserModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					      UserModel user = new UserModel();
					      user.setName(resultSet.getString(2));
					      user.setEmail(resultSet.getString(3));
					      user.setUsername(resultSet.getString(4));
					      user.setPassword(resultSet.getString(5));
					      return user;
				      }
			      });
			return listOfUser.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public UserModel checkEmail(UserModel userModel)
	{
		String insertQuery = "select * from User where email= ?";
		JdbcTemplate JdbcTemplate = new JdbcTemplate(dataSource);
		try {
			List<UserModel>  listOfUser = JdbcTemplate.query(insertQuery,
			      new Object[] { userModel.getEmail()}, new RowMapper() {
				      public UserModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					      UserModel user = new UserModel();
					      user.setName(resultSet.getString(2));
					      user.setEmail(resultSet.getString(3));
					      user.setUsername(resultSet.getString(4));
					      user.setPassword(resultSet.getString(5));
					      return user;
				      }
			      });
			return listOfUser.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int saveUUID( String email, String uuid)
	{ 
		int id=0;
		try {
		Connection connection = dataSource.getConnection();
		String query = "update User set UUID = ? where email = ?";
		Object[] object = new Object[] {uuid,email};
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		id = jdbcTemplate.update(query, object);
		return id;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return id;
}

public int update( String password, String uuid)
{ 
	int id=0;
	try {
	Connection connection = dataSource.getConnection();
	String query = "update User set password = ? where UUID = ?";
	Object[] object = new Object[] {password,uuid};
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	id = jdbcTemplate.update(query, object);
	return id;
} catch (Exception e) {
	e.printStackTrace();
}
return id;
}
}
