package com.myapp.Collaborate.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.Collaborate.model.Blog;
import com.myapp.Collaborate.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
@Transactional
public boolean createForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			System.out.println("Insertion Successful");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
	

	public Forum getForum(int forumId) {
		
			Session session=sessionFactory.openSession();
		  Forum forum=(Forum) session.get(Forum.class, forumId );
			session.close();
			return forum;
		
		
	}
    
	public List<Forum> getforums()
	
	{
		
		
	        Session session = sessionFactory.openSession();

	        Query query= (Query) session.createQuery("From Blog where status='A'");

	        List<Forum> listForum = query.list();
	        session.close();

	        return listForum;
	    }
	
@Transactional
public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}

	
	public boolean deleteForum(int forumId) { 
		try{
			Session session=sessionFactory.openSession();
			Forum forum =(Forum) session.get(Forum.class, forumId);
			session.delete(forum);
			session.flush();
			session.close();
			return true;
		}catch(Exception e)
		{
			System.out.println("Excepion Arised:" + e);
		}
		return false;
		
	}

	public List<Forum> getForum() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean editForum(int forumId) {
		// TODO Auto-generated method stub
		return false;
	}

}