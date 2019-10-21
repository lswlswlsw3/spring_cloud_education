package com.sicc.member.service;

import com.sicc.member.vo.WorkVO;

/**
 * 
 * @author Woongs
 */
public interface WorkRemoteService {
	public WorkVO getWorkInfo(String workNum);
}
