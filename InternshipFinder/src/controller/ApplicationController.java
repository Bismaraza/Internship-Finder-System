package controller;

import dao.ApplicationDAO;
import dao.NotificationDAO;
import dao.StudentDAO;
import model.Application;
import model.Student;

public class ApplicationController {

    private ApplicationDAO dao = new ApplicationDAO();

    public boolean apply(Application a) {
        boolean ok = dao.apply(a);

        if (ok) {
            Student s = new StudentDAO().getById(a.getStudentId());

            if (s != null) {
                new NotificationDAO().create(
                        s.getUserId(),
                        "Application Submitted",
                        "Your application has been submitted successfully."
                );
            }
        }

        return ok;
    }

    public java.util.List<Application> byStudent(int sid) {
        return dao.getByStudent(sid);
    }

    public java.util.List<Application> byJob(int jid) {
        return dao.getByJob(jid);
    }

    public java.util.List<Application> all() {
        return dao.getAll();
    }

    public boolean updateStatus(int appId, int studentId, String st) {
        boolean ok = dao.updateStatus(appId, st);

        if (ok) {
            Student s = new StudentDAO().getById(studentId);

            if (s != null) {
                new NotificationDAO().create(
                        s.getUserId(),
                        "Application Status Updated",
                        "Your application status is now: " + st
                );
            }
        }

        return ok;
    }
}