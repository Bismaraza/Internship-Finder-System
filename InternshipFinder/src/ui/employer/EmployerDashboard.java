package ui.employer;

import javax.swing.*;
import java.awt.*;

import ui.common.*;
import util.*;
import ui.auth.LoginForm;

public class EmployerDashboard extends JFrame {
    JPanel content = new JPanel(new CardLayout());

    public EmployerDashboard() {
        setTitle("Employer Dashboard");
        setSize(1200, 720);
        UITheme.applyFrame(this);
        setLayout(new BorderLayout());

        String[] items = {
            "Dashboard", "Company Profile", "Post Internship",
            "Manage Internships", "Applicants", "Shortlisted",
            "Notifications", "Logout"
        };

        add(new SidebarPanel(items, e -> switchPage(e.getActionCommand())), BorderLayout.WEST);
        add(new HeaderPanel("Employer Dashboard"), BorderLayout.NORTH);

        content.add(home(), "Dashboard");
        content.add(new CompanyProfilePanel(), "Company Profile");
        content.add(new PostInternshipPanel(), "Post Internship");
        content.add(new ManageInternshipsPanel(), "Manage Internships");
        content.add(new ApplicantsPanel(), "Applicants");
        content.add(new ShortlistedCandidatesPanel(), "Shortlisted");
        content.add(new EmployerNotificationsPanel(), "Notifications");

        add(content, BorderLayout.CENTER);
        setVisible(true);
    }

    JPanel home() {
        JPanel p = UITheme.panel();
        p.setLayout(new GridLayout(2, 2, 12, 12));
        p.add(new DashboardCard("Create company profile", "Profile"));
        p.add(new DashboardCard("Post internship opportunities", "Internships"));
        p.add(new DashboardCard("Review applications", "Applicants"));
        p.add(new DashboardCard("Shortlist candidates", "Shortlisted"));
        return p;
    }

    void switchPage(String n) {
        if ("Logout".equals(n)) {
            Session.clear();
            dispose();
            new LoginForm();
            return;
        }
        ((CardLayout) content.getLayout()).show(content, n);
    }
}