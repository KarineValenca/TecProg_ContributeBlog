/**
 * File name: BlogOwner.java
 * Purpose of class: This file is composed by a BlogOwner class.
 * Copyright: This software follows GPL license.
 **/

package model;

import java.util.*;

/**
 * Class name: BlogOwner
 * Purpose of class: This class is an extension of User class. Creates a list
 * of blogs.
 */
public class BlogOwner extends User {

	private List<Blog> blogs;
	
	public BlogOwner() {

	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

}
