package com.sicc.member.service;

import org.springframework.stereotype.Component;
import com.sicc.member.vo.WorkVO;

/**
 * Feign으로 work호출 fallback
 * @author Woongs
 */
@Component
public class FeignWorkRemoteFallback implements FeignWorkRemoteService {
	@Override
	public String getWorkInfoByFeign(String workNum) {
		String errMsg = "[ Work dosen't work. FeignWorkRemoteService fallback occurs. ] : "+workNum;
		return errMsg;
	}
}


