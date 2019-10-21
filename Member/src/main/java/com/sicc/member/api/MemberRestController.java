package com.sicc.member.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sicc.member.service.MemberServiceImpl;
import com.sicc.member.service.WorkRemoteServiceImpl;
import com.sicc.member.vo.MemberVO;
import com.sicc.member.vo.WorkVO;

/**
 * 사용자 정보 Rest API
 * @author Woongs
 */
@RestController
@RequestMapping("/member")
public class MemberRestController {
	@Autowired
	MemberServiceImpl memberServiceImpl;			// 사용자 CRUD를 위한 구현체
	
	@Autowired
	WorkRemoteServiceImpl workRemoteServiceImpl;	// 업무 정보를 가져옴

	// work 마이크로 서비스에서 정보 가져옴
	@RequestMapping(path = "/work/{workNum}", method = RequestMethod.GET)
	public WorkVO getWorkInfo(@PathVariable String workNum) {
		return workRemoteServiceImpl.getWorkInfo(workNum);
	}
	
	// 전체 조회
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<MemberVO> memberSearchAll() {
		List<MemberVO> memberList = memberServiceImpl.findAll();
		
		return memberList; // 조회된 리스트가 있을때
	}
	
	// 사번으로 조회
	@RequestMapping(path = "/{sabun}", method = RequestMethod.GET)
	public MemberVO memberSearch(@PathVariable String sabun) {
		return memberServiceImpl.findBySabun(sabun);
	}
	
	// 저장
	@RequestMapping(path = "/{sabun}/{name}/{division}", method = RequestMethod.POST)
	public MemberVO memberSave(@PathVariable String sabun, @PathVariable String name, @PathVariable String division) {
		MemberVO memberVO = new MemberVO();
		memberVO.setSabun(sabun);
		memberVO.setName(name);
		memberVO.setDivision(division);
		
		memberVO = memberServiceImpl.save(memberVO); // 저장
		return memberVO;
	}
	
	// 갱신
	@RequestMapping(path = "/{sabun}/{name}/{division}", method = RequestMethod.PUT)
	public MemberVO memberUpdateBySabun(@PathVariable String sabun, @PathVariable String name, @PathVariable String division) {
		MemberVO memberVO = new MemberVO();
		memberVO.setSabun(sabun);
		memberVO.setName(name);
		memberVO.setDivision(division);
		
		memberVO = memberServiceImpl.updateBySabun(memberVO); // 갱신
		return memberVO;
	}

	// 삭제
	@RequestMapping(path = "/{sabun}", method = RequestMethod.DELETE)
	public String memberDeleteBySabun(@PathVariable String sabun) {
		memberServiceImpl.deleteBySabun(sabun);
		return sabun+" is deleted.";
	}
}
