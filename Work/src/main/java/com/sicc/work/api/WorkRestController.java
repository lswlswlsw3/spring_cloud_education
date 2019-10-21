package com.sicc.work.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sicc.work.service.WorkServiceImpl;
import com.sicc.work.vo.WorkVO;

/**
 * 업무 관련 REST API
 * @author Woongs
 */
@RestController
@RequestMapping("/work")
public class WorkRestController {
	// 로그정보
	private static final Logger logger = LoggerFactory.getLogger(WorkRestController.class);
	
	@Autowired
	WorkServiceImpl workServiceImpl;

	// 전체 조회
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<WorkVO> workSearchAll() {
		List<WorkVO> workList = workServiceImpl.findAll();
		return workList; // 조회된 리스트가 있을때
	}

	// 업무 번호로 조회
	@RequestMapping(path = "/{work_num}", method = RequestMethod.GET)
	public WorkVO workSearch(@PathVariable String work_num) {
		return workServiceImpl.findByWorkNum(work_num);
	}
	
	// 저장
	@RequestMapping(path = "/{work_num}/{title}/{contents}/{priority}", method = RequestMethod.POST)
	public WorkVO workSave(@PathVariable String work_num, @PathVariable String title, @PathVariable String contents, @PathVariable String priority) {
		WorkVO workVO = new WorkVO();
		
		workVO.setWorkNum(work_num);
		workVO.setTitle(title);
		workVO.setContents(contents);
		workVO.setPriority(priority);
		
		return workServiceImpl.save(workVO);
	}

	// 갱신
	@RequestMapping(path = "/{work_num}/{title}/{contents}/{priority}", method = RequestMethod.PUT)
	public WorkVO memberUpdateByWorkNum(@PathVariable String work_num, @PathVariable String title, @PathVariable String contents, @PathVariable String priority) {
		WorkVO workVO = new WorkVO();
		
		workVO.setWorkNum(work_num);
		workVO.setTitle(title);
		workVO.setContents(contents);
		workVO.setPriority(priority);

		return workServiceImpl.updateByWorkNum(workVO); // 갱신
	}

	// 삭제
	@RequestMapping(path = "/{work_num}", method = RequestMethod.DELETE)
	public String memberDeleteBySabun(@PathVariable String work_num) {
		workServiceImpl.deleteByWorkNum(work_num);
		
		return "work information is deleted.";
	}
}