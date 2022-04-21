package ksmart42.khtour.mapper;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Reservation;

@Mapper
public interface ReservationMapper {
	
	
	//예약정보 등록
	public int addReservation(Reservation reservation);

}
