package com.sicc.member.service;

/**
 * Work 마이크로서비스 통신을 위한 정의
 * @author Woongs
 */
public interface WorkRemoteService {
	// work 마이크로서비스 정보 조회를 위한 함수
	public String getWorkInfo(String workNum);
}
