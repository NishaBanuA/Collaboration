package com.myapp.Collaborate.DAO;

import java.util.ArrayList;
import java.util.List;

import com.myapp.Collaborate.model.Blog;
import com.myapp.Collaborate.model.Forum;

public interface ForumDAO {
	public boolean createForum(Forum forum);
	public Forum getForum(int ForumId);
	public  List<Forum> getForum(); 
		
	public boolean approveForum(Forum forum);
	public boolean editForum(int forumId);
	public boolean deleteForum(int forumId);
	
}