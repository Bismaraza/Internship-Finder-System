package controller;
import dao.*;
import model.*;
import java.util.*;
public class RecommendationController { public java.util.List<Internship> recommend(Student s){ java.util.List<Internship> all=new InternshipDAO().search("","","",""); java.util.List<Internship> rec=new ArrayList<>(); String skills=(s==null||s.getSkills()==null?"":s.getSkills().toLowerCase()); String field=(s==null||s.getFieldOfStudy()==null?"":s.getFieldOfStudy().toLowerCase()); String city=(s==null||s.getCity()==null?"":s.getCity().toLowerCase()); for(Internship j:all){ String data=(j.getTitle()+" "+j.getField()+" "+j.getRequirements()+" "+j.getCity()).toLowerCase(); if((!field.isEmpty()&&data.contains(field))||(!city.isEmpty()&&data.contains(city))){ rec.add(j); continue; } for(String sk:skills.split(",")){ if(sk.trim().length()>1 && data.contains(sk.trim())){ rec.add(j); break; } } } return rec; } }
