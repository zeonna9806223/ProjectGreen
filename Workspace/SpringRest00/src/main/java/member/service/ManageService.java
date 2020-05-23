package member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mchange.v2.beans.swing.TestBean;
@Transactional
@Service("ManageService")
public class ManageService {

	public String TestBean() {
		return "aaa";
	}
}
