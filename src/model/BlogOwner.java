/*
 * Class name: BlogOwner.java
 * Purpose of class: This class is an extension of User class. Creates a list 
 * of blogs.
 * Copyright: This software follows GPL license.
 */

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
