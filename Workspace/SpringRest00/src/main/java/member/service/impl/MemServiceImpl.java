package member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import member.dao.MemDao;
import member.model.Mem;
import member.service.MemService;


@Transactional
@Service("memServiceImpl")
public class MemServiceImpl implements MemService {
	
	@Autowired
	private MemDao memDao;

	
	public MemServiceImpl() {
	}
	
	@Autowired
	public void setMemDao(MemDao memDao) {
		this.memDao = memDao;
	}////////////////////////////////////////////////////////////////////

	@Override
	public Mem getMem(int id) {
	
		return memDao.getMem(id);
	}

	@Override
	public List<Mem> getMems() {
		return memDao.getMems();
	}

	@Override
	public Object saveMem(Mem bean) {
		return memDao.saveMem(bean);
	}

	@Override
	public void updateMem(Mem bean) {
		memDao.updateMem(bean);
	}

	@Override
	public void deleteMem(int key) {
		memDao.deleteMem(key);
	}

	@Override
	public Mem getMem(String memberAccount) {
		return memDao.getMem(memberAccount);
	}


	
}
