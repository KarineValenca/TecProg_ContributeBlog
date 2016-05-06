/** 
 * File name: FactoryDenounceDAO.java
 * Purpose of file: this file contains the interface FactoryDenounceDAO and its methods.   
 * Copyright: This software follows GPL license.
 */

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
 */
public interface FactoryDenounceDAO {
	
	void createDenounce(int id, Denounce denounce, User user);

	
}
