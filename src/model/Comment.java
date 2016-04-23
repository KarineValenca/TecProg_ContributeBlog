/*
 * Class name: Comment.java
 * Purpose of class: This class defines the attributes of a comment.
 * Copyright: This software follows GPL license.
 */

package model;

import java.util.Date;

public class Comment {
	private int idComment;
	private String commentContent;
	private Date commentDate;
	private String commentUser;
	
	public int getIdComment() {
		return idComment;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}
		
}
