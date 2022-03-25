package ksmart42.khtour.mapper;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import ksmart42.khtour.dto.Calendar;

@Repository
public interface CalenDao {

	
	public ArrayList<Calendar> calenList();
	
}
