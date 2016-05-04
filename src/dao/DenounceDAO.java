/** 
* File name: DenounceDAO.java
* Purpose of file: this file contains the interface DenounceDAO and its methods.   
* Copyright: This software follows GPL license.
**/

package dao;

import java.util.List;

import model.Denounce;

/**
* Interface name: DenounceDAO
* Purpose of interface: this interface that defines the methods: listDenounce
* and deleteDenounce. 
**/
public interface DenounceDAO {
	
	/** 
	* Method name: listDenounce
	* Purpose of method: setting method listarDenuncia.  
	* @param: there is no param.
	* @return there is no return.
	**/
	public List<Denounce> listDenounce ();
	
	/** 
	* Method name: deleteDenounce
	* Purpose of method: setting method listarDenuncia.  
	* @param id denounce: unique identify of denounce to be deleted.
	* @return there is no return.
	**/
	public void deleteDenounce(String idDenounce);
}
