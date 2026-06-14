package ui.admin;

import javax.swing.*;
import java.awt.*;

import ui.common.*;
import util.*;
import ui.auth.LoginForm;

public class AdminDashboard extends JFrame {
    JPanel content = new JPanel(new CardLayout());

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(1200, 720);
        UITheme.applyFrame(this);
        setLayout(new BorderLayout());

        String[] items = {
            "Dashboard", "Users", "Employers", "Internship Approval",
            "Reports", "Fake/Expired Internships", "Analytics", "Logout"
        };

        add(new SidebarPanel(items, e -> switchPage(e.getActionCommand())), BorderLayout.WEST);
        add(new HeaderPanel("Admin Dashboard"), BorderLayout.NORTH);

        content.add(home(), "Dashboard");
        content.add(new ManageUsersPanel(), "Users");
        content.add(new ManageEmployersPanel(), "Employers");
        content.add(new InternshipApprovalPanel(), "Internship Approval");
        content.add(new ReportsPanel(), "Reports");
        content.add(new FakeExpiredInternshipsPanel(), "Fake/Expired Internships");
        content.add(new AnalyticsPanel(), "Analytics");

        add(content, BorderLayout.CENTER);
        setVisible(true);
    }

    JPanel home() {
        JPanel p = UITheme.panel();
        p.setLayout(new GridLayout(2, 2, 12, 12));
        p.add(new DashboardCard("Manage users", "Users"));
        p.add(new DashboardCard("Approve internships", "Internships"));
        p.add(new DashboardCard("Manage reports", "Reports"));
        p.add(new DashboardCard("View basic analytics", "Analytics"));
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