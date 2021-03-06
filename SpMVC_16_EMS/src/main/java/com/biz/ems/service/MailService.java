package com.biz.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.ems.domain.EmailVO;
import com.biz.ems.repository.EmailDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {
	
	private final EmailDao emailDao;
	
	public int insert(EmailVO emailVO) {
		emailDao.save(emailVO);
		return 0;
	}
	
	public List<EmailVO> selectAll() {		
		return (List<EmailVO>) emailDao.findAll();
	}
	
	public EmailVO findBySeq(long emsSeq) {
//		EmailVO emailVO = emailDao.findById(emsSeq);
		EmailVO emailVO = emailDao.findByEmsSeq(emsSeq);
		return emailVO;
	}

	public void delete(long emsSeq) {
		emailDao.deleteById(emsSeq);
	}

	public void update(EmailVO emailVO) {
		emailDao.save(emailVO);
	}

}
