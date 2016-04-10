package dao;

import java.util.List;

import model.Denounce;

public interface DenounceDAO {
	public List<Denounce> listDenounce ();
	public void deleteDenounce(String idDenounce);
}
