package controller;
import dao.StudentDAO;
import model.Student;
public class StudentController { private StudentDAO dao=new StudentDAO(); public Student getProfile(int uid){ return dao.getByUserId(uid);} public boolean updateProfile(Student s){ return dao.update(s);} }
