package controller;
import dao.*;
import model.*;
import java.util.*;
public class AdminController { public java.util.List<User> users(){return new UserDAO().getAllUsers();} public boolean userStatus(int id,String st){return new UserDAO().updateStatus(id,st);} public java.util.List<Company> companies(){return new CompanyDAO().getAll();} public boolean verifyCompany(int id, boolean v){return new CompanyDAO().verify(id,v);} }
