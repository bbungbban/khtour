package ksmart42.khtour.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ksmart42.khtour.dto.Calendar;
import ksmart42.khtour.mapper.CalenDao;

@Service
public class CalenService {
	@Autowired(required = false)
	private CalenDao dao;
	
	public ArrayList<Calendar> calenList(){
		return dao.calenList();
	}
	

}
