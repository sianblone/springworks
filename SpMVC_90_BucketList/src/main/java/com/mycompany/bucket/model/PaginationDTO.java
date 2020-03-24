package com.mycompany.bucket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PaginationDTO {
	
	private long totalCount;// 전체 데이터 개수
	
	private int offset;// 시작 레코드
	private int limit;// 끝 레코드
	
	private int listPerPage;// 한 페이지에 보일 데이터 개수
	private int pageCount;// 현재 페이지 하단에 보일 페이지 개수
	
	private int firstPageNo;// 전체 데이터의 첫 페이지 번호(일반적으로 1)
	private int lastPageNo;// 전체 데이터의 끝 페이지 번호
	
	private int prePageNo;// 이전 페이지 번호
	private int nextPageNo;// 다음 페이지 번호
	
	private int startPageNo;// 아래에서 5~10페이지를 보여준다고 할 때 5
	private int endPageNo;// 아래에서 5~10페이지를 보여준다고 할 때 10
	
	private int currentPageNo;// 현재 페이지 번호

}
