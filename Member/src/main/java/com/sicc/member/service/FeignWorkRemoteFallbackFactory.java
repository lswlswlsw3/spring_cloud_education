package com.sicc.member.service;

import org.springframework.stereotype.Component;

import com.sicc.member.vo.WorkVO;

import feign.hystrix.FallbackFactory;

/**
 * Feign으로 work호출 fallback factory (fallback 원인파악을 위함)
 * @author Woongs
 */
@Component
public class FeignWorkRemoteFallbackFactory implements FallbackFactory<FeignWorkRemoteService> {
	@Override
	public FeignWorkRemoteService create(Throwable cause) {
		String errMsg = "[ Work dosen't work. FeignWorkRemoteService fallbackFactory occurs. ] : "+cause;
		return workNum -> errMsg;
	}
}

