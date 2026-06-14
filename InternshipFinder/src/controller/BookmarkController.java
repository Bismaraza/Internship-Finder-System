package controller;
import dao.BookmarkDAO;
import model.Bookmark;
import java.util.*;
public class BookmarkController { private BookmarkDAO dao=new BookmarkDAO(); public boolean add(int s,int j){return dao.add(s,j);} public boolean remove(int id){return dao.remove(id);} public java.util.List<Bookmark> list(int sid){return dao.getByStudent(sid);} }
