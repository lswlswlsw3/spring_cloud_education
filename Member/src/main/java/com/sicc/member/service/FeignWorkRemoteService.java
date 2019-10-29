package com.sicc.member.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sicc.member.vo.WorkVO;

/**
 * Feign으로 work호출 정의
 * @author Woongs
 */
@FeignClient(name = "work", url = "http://localhost:8082/work/")
public interface FeignWorkRemoteService {
	@RequestMapping(path = "/{workNum}")
	WorkVO getWorkInfoByFeign(@PathVariable(value="workNum") String workNum);
}
