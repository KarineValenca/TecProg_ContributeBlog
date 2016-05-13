/**
 * File name: Comment
 * Purpose of file: This file is composed by a Comment class and methods.
 * Copyright: This software follows GPL license.
 */

package model;

import java.util.Date;

/**
 * Class name: Comment.java
 * Purpose of class: This class defines the attributes of a comment.
 */
public class Comment {
	private int idComment;
	
	public int getIdComment() {
		return idComment;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	
	private String commentContent;
	
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	private Date commentDate;
	
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	private String commentUser;
	
	public String getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}
		
}
