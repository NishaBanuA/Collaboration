package com.myapp.Collaborate.test;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.Collaborate.DAO.BlogDAO;

import com.myapp.Collaborate.model.Blog;



public class BlogDAOTest {
	
                static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.myapp.Collaborate");
		annotationConfigAppContext.refresh();
		blogDAO=(BlogDAO)annotationConfigAppContext.getBean("blogDAO");
	}
	@Ignore
	@Test
	public void createBlogTest() {
		Blog blog=new Blog();
		blog.setBlogId(10);
		blog.setBlogName("VertiGo");
		blog.setBlogContent("New Era of AeroDynamic");
		blog.setUserId("nisha@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		assertTrue("Problem in Blog creation",blogDAO.createBlog(blog));
	}

	@Ignore
	@Test
	public void approveBlogTest() {
		Blog blog=new Blog();
		blog.setBlogId(10);
		blog.setBlogName("VertiGo");
		blog.setBlogContent("New Era of AeroDynamic");
		blog.setUserId("nisha@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		assertTrue("Problem in Approving Blog",blogDAO.approveBlog(blog));
	}
@Test
public void getAllApporvedBlogTest()
{
	List<Blog> listBlog=blogDAO.getBlogs();
	assertTrue("No Approved Blogs",listBlog.size()>0);
	
}

@Test
public void deleteBlogTest()
{
	assertTrue("problem in Deleting",blogDAO.deleteBlog(1000));
	
}
@Ignore
@Test
public void getBlogByBlogId()
{
	assertNotNull("problem getting blog",blogDAO.getBlog(1001));
}
}