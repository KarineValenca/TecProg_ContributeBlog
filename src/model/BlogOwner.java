package model;

import java.util.*;

public class BlogOwner extends User {

	private List<Blog> blogs;
		
	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public BlogOwner() {
		
	}

}
