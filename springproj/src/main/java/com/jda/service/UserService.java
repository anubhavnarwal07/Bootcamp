package com.jda.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jda.DAO.IUserInterface;
import com.jda.model.UserModel;
import com.jda.utility.ApplicationMailer;

@Service
public class UserService implements IUserService {
 @Autowired
	private IUserInterface userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
public boolean forgotPassword(UserModel user, String url)
{ UserModel userModel = userDao.checkEmail(user);
if(userModel!=null)
{ UUID uuid = UUID.randomUUID();
String uid = uuid.toString();
if(userDao.saveUUID(user.getEmail(),uid)>0)
{ 
	System.out.println("dhjfh");
	String link = url.substring(0,url.lastIndexOf("/")) + "/resetpasswordform?uuid=" + uuid;
ApplicationMailer mail=new ApplicationMailer();
mail.sendMail(link);
return true;
} return false;
}return false;
}
	public boolean registerUser(UserModel userModel) {
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		if (userDao.registerUser(userModel) > 0)
			return true;
		return false;
	}

	public UserModel loginUser(UserModel userModel) {
		UserModel user = userDao.loginUser(userModel);
		if (user != null) {
			
		if (BCrypt.checkpw(userModel.getPassword(), user.getPassword())  ) {
		return user;
			}
			return null;
		}
		return null;
	}
	@Override
	public boolean update(String header, UserModel userModel) {
		header = header.substring(header.lastIndexOf("=")+1,header.length());
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		if(userDao.update(userModel.getPassword(),header)>0)
		return true;
		return false;
	}

}
