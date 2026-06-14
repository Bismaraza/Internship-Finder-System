package controller;
import dao.*;
import model.*;
public class EmployerController { private EmployerDAO edao=new EmployerDAO(); private CompanyDAO cdao=new CompanyDAO(); public Employer getEmployer(int uid){ return edao.getByUserId(uid);} public Company getCompany(int eid){ return cdao.getByEmployerId(eid);} public boolean saveCompany(Company c){ return cdao.saveOrUpdate(c);} }
