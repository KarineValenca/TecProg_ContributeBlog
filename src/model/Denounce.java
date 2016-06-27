/** 
 * File name: Denounce.java
 * Purpose of file: this file contains the Denounce class, attributes and its methods.   
 * Copyright: This software follows GPL license.
 */

package model;

import java.util.Date;


/**
 * Class name: Denounce
 * Purpose of class: This class is used to store all attributes from a denounce.
 */
public class Denounce {
	public int idDenounce;
	public Date dateDenounce;
	public String contentDenounce;
	public int idBlog; 
	
	public Denounce(){		
	}
	
	public Denounce(int idDenounce, Date dateDenounce, String contentDenounce, 
					int idBlog){
		this.idDenounce = idDenounce;
		this.dateDenounce = dateDenounce;
		this.contentDenounce = contentDenounce;
		this.idBlog = idBlog;
		
	}
	
	public int getIdDenounce() {
		return idDenounce;
	}
	
	public int getIdBlog() {
		return idBlog;
	}

	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}

	public void setIdDenounce(int idDenounce) {
		this.idDenounce = idDenounce;
	}
	
	public Date getDateDenounce() {
		return dateDenounce;
	}
	
	public void setDateDenounce(Date dateDenounce) {
		this.dateDenounce = dateDenounce;
	}
	
	public String getContentDenounce() {
		return contentDenounce;
	}
	
	public void setContentDenounce(String contentDenounce) {
		this.contentDenounce = contentDenounce;
	}
}
