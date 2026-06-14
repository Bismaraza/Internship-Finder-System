package controller;
import dao.*;
import model.User;
import util.*;

public class AuthController {
    private UserDAO userDAO = new UserDAO();
    public String register(String name,String email,String password,String role){
        if(Validator.isEmpty(name)||Validator.isEmpty(email)||Validator.isEmpty(password)) return "All fields are required.";
        if(!Validator.isValidEmail(email)) return "Invalid email format.";
        if(!Validator.isStrongPassword(password)) return "Password must be at least 6 characters.";
        if(userDAO.findByEmail(email)!=null) return "Email already registered.";
        User u=new User(0,name,email,password,role,Constants.STATUS_ACTIVE,null);
        if(!userDAO.register(u)) return "Registration failed.";
        if(Constants.ROLE_STUDENT.equals(role)) new StudentDAO().createDefault(u.getId(), name);
        if(Constants.ROLE_EMPLOYER.equals(role)) new EmployerDAO().createDefault(u.getId());
        new NotificationDAO().create(u.getId(),"Welcome","Your account has been created successfully.");
        return "SUCCESS";
    }
    public User login(String email,String password){
        User u=userDAO.login(email,password); if(u!=null) Session.setCurrentUser(u); return u;
    }
    public void logout(){ Session.clear(); }
}
