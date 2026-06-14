package controller;
import dao.ResumeDAO;
import model.Resume;
import util.*;
import java.io.File;
public class ResumeController { private ResumeDAO dao=new ResumeDAO(); public String upload(int studentId,String title,File resume,File cover,File idFile){ try{ if(resume==null || !Validator.isValidDocument(resume.getName())) return "Select valid PDF/DOC resume."; String rp=FileUtil.copyFile(resume,Constants.RESUME_DIR,studentId); String cp=cover==null?"":FileUtil.copyFile(cover,Constants.COVER_LETTER_DIR,studentId); String ip=idFile==null?"":FileUtil.copyFile(idFile,Constants.STUDENT_ID_DIR,studentId); return dao.create(new Resume(0,studentId,title,rp,cp,ip,null))?"SUCCESS":"Upload failed."; }catch(Exception e){e.printStackTrace(); return e.getMessage();} } public Resume latest(int sid){return dao.getLatestByStudent(sid);} }
