package controller;
import dao.ReportDAO;
import model.Report;
import java.util.*;
public class ReportController { private ReportDAO dao=new ReportDAO(); public boolean add(int u,int j,String r){return dao.add(u,j,r);} public java.util.List<Report> all(){return dao.getAll();} public boolean close(int id){return dao.close(id);} }
