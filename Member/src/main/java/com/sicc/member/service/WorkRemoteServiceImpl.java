package com.sicc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sicc.member.vo.WorkVO;

/**
 * Work 마이크로 서비스와 통신을 통해 결과 값을 가져옴
 * @author Woongs
 */
@Service
public class WorkRemoteServiceImpl implements WorkRemoteService{
	public static final String URL = "http://localhost:8082/work/"; // work 마이크로서비스와 통신을 위한 URL
	
	@Autowired
	private RestTemplate restTemplate;

	// work 마이크로서비스의 정보를 조회하는 함수
	@Override
	public WorkVO getWorkInfo(String workNum) {
		WorkVO workVO = new WorkVO();
		
		ResponseEntity<WorkVO> result =
				restTemplate.exchange(
						URL+"{workNum}",	// work 마이크로서비스에 요청하는 URL
						HttpMethod.GET, 	// GET방식으로 요청
						null,				
						WorkVO.class,		// WorkVO
						workNum);			// 업무번호

		workVO = result.getBody();			// 조회된 업무정보 저장
		
		return workVO;
	}
}