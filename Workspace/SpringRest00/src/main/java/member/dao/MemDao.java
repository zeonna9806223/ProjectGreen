package member.dao;

import java.util.List;

import member.model.Mem;



public interface MemDao {
	Mem getMem(int id);
	
	List<Mem> getMems();

	Object saveMem(Mem bean);
	
	void updateMem(Mem bean); 

	void deleteMem(int key);

	Mem getMem(String memberAccount);
	
	


}
