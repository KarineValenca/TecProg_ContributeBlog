/** 
 * File name: DenounceDAO.java
 * Purpose of file: this file contains the interface DenounceDAO and its methods.   
 * Copyright: This software follows GPL license.
 */

package dao;

import java.util.List;

import model.Denounce;

/**
 * Interface name: DenounceDAO
 * Purpose of interface: this interface that defines the methods: listDenounce
 * and deleteDenounce. 
 */
public interface DenounceDAO {
	
	public List<Denounce> listDenounce ();
	
	public boolean deleteDenounce(String idDenounce);
}
