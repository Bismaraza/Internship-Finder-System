package controller;

import dao.CompanyDAO;
import dao.EmployerDAO;
import dao.InternshipDAO;
import dao.NotificationDAO;
import model.Company;
import model.Employer;
import model.Internship;

public class InternshipController {

    private InternshipDAO dao = new InternshipDAO();

    public boolean post(Internship j) {
        return dao.create(j);
    }

    public java.util.List<Internship> search(String f, String c, String t, String d) {
        return dao.search(f, c, t, d);
    }

    public java.util.List<Internship> all() {
        return dao.getAll();
    }

    public java.util.List<Internship> pending() {
        return dao.getPending();
    }

    public java.util.List<Internship> byCompany(int cid) {
        return dao.getByCompany(cid);
    }

    public Internship get(int id) {
        return dao.getById(id);
    }

    public boolean status(int id, String s) {
        Internship job = dao.getById(id);
        boolean ok = dao.updateStatus(id, s);

        if (ok && job != null) {
            Company company = new CompanyDAO().getById(job.getCompanyId());

            if (company != null) {
                Employer employer = new EmployerDAO().getById(company.getEmployerId());

                if (employer != null) {
                    new NotificationDAO().create(
                            employer.getUserId(),
                            "Internship Status Updated",
                            "Your internship post \"" + job.getTitle() + "\" is now: " + s
                    );
                }
            }
        }

        return ok;
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
}