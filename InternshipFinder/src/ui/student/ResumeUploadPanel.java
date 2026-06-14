package ui.student;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import controller.ResumeController;
import dao.StudentDAO;
import model.Student;
import util.*;

public class ResumeUploadPanel extends JPanel {

    File resume;
    JLabel selectedResume = UITheme.label("No resume selected");
    JTextField title = UITheme.textField();

    public ResumeUploadPanel() {
        setBackground(UITheme.BG);
        setLayout(new GridLayout(0, 1, 0, 10));

        add(UITheme.title("Upload Resume"));
        add(UITheme.label("Resume Title"));
        add(title);

        JButton chooseResume = UITheme.button("Choose Resume PDF/DOC");
        JButton upload = UITheme.button("Upload");

        add(chooseResume);
        add(selectedResume);
        add(upload);

        chooseResume.addActionListener(e -> {
            resume = choose();
            if (resume != null) {
                selectedResume.setText(resume.getName());
            }
        });

        upload.addActionListener(e -> upload());
    }

    File choose() {
        JFileChooser fc = new JFileChooser();
        return fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION
                ? fc.getSelectedFile()
                : null;
    }

    void upload() {
        Student s = new StudentDAO().getByUserId(Session.getUserId());

        if (s == null) {
            DialogUtil.error(this, "Student profile not found.");
            return;
        }

        if (resume == null) {
            DialogUtil.error(this, "Please choose a resume file.");
            return;
        }

        String res = new ResumeController().upload(
                s.getId(),
                title.getText(),
                resume,
                null,
                null
        );

        if ("SUCCESS".equals(res)) {
            DialogUtil.success(this, "Resume uploaded successfully");
        } else {
            DialogUtil.error(this, res);
        }
    }
}