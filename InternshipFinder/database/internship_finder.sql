CREATE DATABASE IF NOT EXISTS internship_finder;
USE internship_finder;

DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS reports;
DROP TABLE IF EXISTS notifications;
DROP TABLE IF EXISTS bookmarks;
DROP TABLE IF EXISTS applications;
DROP TABLE IF EXISTS resumes;
DROP TABLE IF EXISTS internships;
DROP TABLE IF EXISTS companies;
DROP TABLE IF EXISTS employers;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS admins;
DROP TABLE IF EXISTS settings;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('STUDENT','EMPLOYER','ADMIN') NOT NULL,
    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    full_name VARCHAR(120),
    education VARCHAR(200),
    skills TEXT,
    field_of_study VARCHAR(100),
    city VARCHAR(100),
    availability VARCHAR(100),
    phone VARCHAR(30),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE employers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    designation VARCHAR(100),
    phone VARCHAR(30),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    level VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE companies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employer_id INT NOT NULL UNIQUE,
    company_name VARCHAR(150) NOT NULL,
    description TEXT,
    city VARCHAR(100),
    address VARCHAR(255),
    email VARCHAR(120),
    phone VARCHAR(30),
    verified BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (employer_id) REFERENCES employers(id) ON DELETE CASCADE
);

CREATE TABLE internships (
    id INT AUTO_INCREMENT PRIMARY KEY,
    company_id INT NOT NULL,
    title VARCHAR(150) NOT NULL,
    field VARCHAR(100),
    city VARCHAR(100),
    type ENUM('Remote','On-site','Hybrid') DEFAULT 'On-site',
    duration VARCHAR(100),
    stipend DECIMAL(10,2) DEFAULT 0,
    requirements TEXT,
    description TEXT,
    deadline DATE,
    status ENUM('PENDING','APPROVED','REJECTED','EXPIRED') DEFAULT 'PENDING',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE
);

CREATE TABLE resumes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    title VARCHAR(100),
    resume_path VARCHAR(255) NOT NULL,
    cover_letter_path VARCHAR(255),
    student_id_path VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
);

CREATE TABLE applications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    job_id INT NOT NULL,
    student_id INT NOT NULL,
    resume_id INT,
    status ENUM('APPLIED','REVIEWED','SHORTLISTED','REJECTED','ACCEPTED','COMPLETED') DEFAULT 'APPLIED',
    cover_note TEXT,
    applied_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY unique_application(job_id, student_id),
    FOREIGN KEY (job_id) REFERENCES internships(id) ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (resume_id) REFERENCES resumes(id) ON DELETE SET NULL
);

CREATE TABLE bookmarks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    job_id INT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY unique_bookmark(student_id, job_id),
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES internships(id) ON DELETE CASCADE
);

CREATE TABLE notifications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(150),
    message TEXT,
    is_read BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    message TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (receiver_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    company_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    feedback TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE
);

CREATE TABLE reports (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    job_id INT NOT NULL,
    reason TEXT,
    status ENUM('OPEN','CLOSED') DEFAULT 'OPEN',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES internships(id) ON DELETE CASCADE
);

CREATE TABLE settings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    setting_key VARCHAR(100) UNIQUE,
    setting_value VARCHAR(255)
);

-- Default password for all sample accounts is: 123456
-- SHA-256 hash of 123456:
INSERT INTO users(name,email,password,role,status) VALUES
('Admin','admin@jobportal.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','ADMIN','ACTIVE'),
('Ali Student','student@jobportal.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','STUDENT','ACTIVE'),
('TechCorp HR','employer@jobportal.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','EMPLOYER','ACTIVE');

INSERT INTO admins(user_id, level) VALUES (1,'SUPER_ADMIN');
INSERT INTO students(user_id,full_name,education,skills,field_of_study,city,availability,phone) VALUES
(2,'Ali Student','BS Software Engineering','Java, MySQL, Swing, HTML','Software Engineering','Lahore','Immediate','03000000000');
INSERT INTO employers(user_id,designation,phone) VALUES (3,'HR Manager','03111111111');
INSERT INTO companies(employer_id,company_name,description,city,address,email,phone,verified) VALUES
(1,'TechCorp','Verified software company offering student internships.','Lahore','Main Boulevard','hr@techcorp.com','042000000',TRUE);
INSERT INTO internships(company_id,title,field,city,type,duration,stipend,requirements,description,deadline,status) VALUES
(1,'Java Swing Intern','Software Development','Lahore','On-site','2 Months',15000,'Java, OOP, MySQL','Work on desktop software using Java Swing and JDBC.','2026-12-31','APPROVED'),
(1,'Remote Web Intern','Web Development','Remote','Remote','1 Month',10000,'HTML, CSS, JS','Build landing pages and small dashboards.','2026-12-31','APPROVED'),
(1,'Database Intern','Database','Lahore','Hybrid','2 Months',12000,'SQL, MySQL','Support database design and reporting.','2026-12-31','PENDING');
INSERT INTO settings(setting_key,setting_value) VALUES
('app_name','Internship Finder System'),
('allow_registration','true'),
('dark_theme','enabled'),
('support_email','support@jobportal.com');
