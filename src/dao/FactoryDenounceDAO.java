/** 
* File name: FactoryDenounceDAO.java
* Purpose of file: this file contains the interface FactoryDenounceDAO and its methods.   
* Copyright: This software follows GPL license.
**/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.Denounce;
import model.DenounceBlog;
import model.User;

/**
* Interface name: FactoryDenounceDAO
* Purpose of interface: this interface that defines the method: createDenounce
* and deleteDenounce. 
**/
public interface FactoryDenounceDAO {
	
	/** 
	* Method name: createDenounce
	* Purpose of method: setting method createDenuncia.  
	* @param id: unique identify of denounce.
	* @param denounce: object denounce.
	* @param user: object user. User is responsible of denounce.
	* @return there is no return.
	**/
	void createDenounce(int id, Denounce denounce, User user);
	
	
	
}
