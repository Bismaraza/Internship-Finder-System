package controller;
import dao.NotificationDAO;
import model.Notification;
import java.util.*;
public class NotificationController { private NotificationDAO dao=new NotificationDAO(); public java.util.List<Notification> list(int uid){return dao.getByUser(uid);} public boolean create(int uid,String t,String m){return dao.create(uid,t,m);} public boolean read(int id){return dao.markRead(id);} }
