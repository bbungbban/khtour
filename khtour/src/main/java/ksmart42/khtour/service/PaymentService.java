package ksmart42.khtour.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.mapper.PaymentMapper;

@Service
@Transactional
public class PaymentService {
	
	private PaymentMapper paymentMapper;

}
