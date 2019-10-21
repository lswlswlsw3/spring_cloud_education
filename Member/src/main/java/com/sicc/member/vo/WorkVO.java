package com.sicc.member.vo;

import org.springframework.stereotype.Component;

/**
 * 작업 VO
 * @author Woongs
 */
@Component
public class WorkVO {
	private Integer sn;			// sn
	private String workNum;		// 작업 번호
	private String title;		// 작업명
	private String contents;	// 작업내용
	private String priority;	// 중요도

	// 기본 생성자
	public WorkVO() {
		// TODO Auto-generated constructor stub
	}

	// 생성자
	public WorkVO(Integer sn, String workNum, String title, String contents, String priority) {
		super();
		this.sn = sn;
		this.workNum = workNum;
		this.title = title;
		this.contents = contents;
		this.priority = priority;
	}

	// setter & getter
	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getWorkNum() {
		return workNum;
	}

	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	// toString()
	@Override
	public String toString() {
		return "WorkVO [sn=" + sn + ", workNum=" + workNum + ", title=" + title + ", contents=" + contents
				+ ", priority=" + priority + "]";
	}
}
