package ui.student;

import javax.swing.*;
import java.awt.*;

import ui.common.*;
import util.*;
import ui.auth.LoginForm;

public class StudentDashboard extends JFrame {
    JPanel content = new JPanel(new CardLayout());

    public StudentDashboard() {
        setTitle("Student Dashboard");
        setSize(1200, 720);
        UITheme.applyFrame(this);
        setLayout(new BorderLayout());

        String[] items = {
            "Dashboard", "Profile", "Search Internships", "Upload Resume",
            "Applications", "Saved Internships", "Recommendations",
            "Notifications", "Logout"
        };

        add(new SidebarPanel(items, e -> switchPage(e.getActionCommand())), BorderLayout.WEST);
        add(new HeaderPanel("Student Dashboard"), BorderLayout.NORTH);

        content.setBackground(UITheme.BG);
        content.add(home(), "Dashboard");
        content.add(new StudentProfilePanel(), "Profile");
        content.add(new InternshipSearchPanel(), "Search Internships");
        content.add(new ResumeUploadPanel(), "Upload Resume");
        content.add(new MyApplicationsPanel(), "Applications");
        content.add(new SavedInternshipsPanel(), "Saved Internships");
        content.add(new RecommendationsPanel(), "Recommendations");
        content.add(new StudentNotificationsPanel(), "Notifications");

        add(content, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel home() {
        JPanel p = UITheme.panel();
        p.setLayout(new GridLayout(2, 2, 12, 12));
        p.add(new DashboardCard("Search internship opportunities", "Internships"));
        p.add(new DashboardCard("Track application status", "Applications"));
        p.add(new DashboardCard("View saved internships", "Bookmarks"));
        p.add(new DashboardCard("Get status updates", "Notifications"));
        return p;
    }

    private void switchPage(String name) {
        if ("Logout".equals(name)) {
            Session.clear();
            dispose();
            new LoginForm();
            return;
        }
        ((CardLayout) content.getLayout()).show(content, name);
    }
}