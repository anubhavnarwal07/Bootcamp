package com.jda.DAO;

import com.jda.model.UserModel;

public interface IUserInterface {
public int registerUser(UserModel userModel);
public UserModel loginUser(UserModel userModel);
public int saveUUID( String email, String uuid);
public UserModel checkEmail(UserModel user);
public int update(String password, String header);

}
