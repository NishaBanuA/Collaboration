package com.myapp.Collaborate.test;


	


	import static org.junit.Assert.*;

	import java.util.List;

	import org.junit.BeforeClass;
	import org.junit.Ignore;
	import org.junit.Test;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.myapp.Collaborate.DAO.BlogDAO;
import com.myapp.Collaborate.DAO.ForumDAO;
import com.myapp.Collaborate.model.Blog;
import com.myapp.Collaborate.model.Forum;



	public class ForumDAOTest {
		
	                static ForumDAO forumDAO;
		
		@BeforeClass
		public static void initialize()
		{
			
			AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
			annotationConfigAppContext.scan("com.myapp.Collaborate");
			annotationConfigAppContext.refresh();
			forumDAO=(ForumDAO)annotationConfigAppContext.getBean("ForumDAO");
		}
		
		@Test
		public void createForumTest() {
			Forum forum=new Forum();
			forum.setForumId(10);
			forum.setForumName("VertiGo");
			forum.setForumContent("New Era of AeroDynamic");
			forum.setUserId("nisha@gmail.com");
			forum.setCreateDate(new java.util.Date());
			forum.setStatus("NA");
			
			assertTrue("Problem in Forum creation",forumDAO.createForum(forum));
		}

		@Ignore
		@Test
		public void approveFourmTest() {
			Forum forum=new Forum();
			forum.setForumId(10);
			forum.setForumName("VertiGo");
			forum.setForumContent("New Era of AeroDynamic");
			forum.setUserId("nisha@gmail.com");
			forum.setCreateDate(new java.util.Date());
			forum.setStatus("NA");
			
			assertTrue("Problem in Approving forum",forumDAO.approveForum(forum));
	
		}
		@Ignore
	@Test
	public void getAllApporvedForumTest()
	{
		List<Forum> listForum=forumDAO.getForum();
		assertTrue("No Approved forum",listForum.size()>0);
		
	}

	
	@Ignore
	@Test
	public void getForumByForumId()
	{
		assertNotNull("problem getting forum",forumDAO.getForum(1001));
	}
	}

