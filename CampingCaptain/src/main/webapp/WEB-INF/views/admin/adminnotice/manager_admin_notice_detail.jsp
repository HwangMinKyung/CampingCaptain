<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../admin_header.jsp"%>
<%@ include file="../manager_admin_menu.jsp"%>      

<div id="manager_admin_notice_detail" align="center">
	<h4>지점 관리자 공지사항 상세보기</h4>
	<form name="frm" id="manager_detail_form" method="post">
		<table>
			<tr>
				<th>번호</th>
				<td width="130">${adminnoticeVO.aseq}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${adminnoticeVO.title}</td>
			</tr>
			<tr>
				<th width="130">내용</th>
				<td>${adminnoticeVO.content}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${adminnoticeVO.admin_name}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${adminnoticeVO.indate}"/></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${adminnoticeVO.count}</td>
			</tr>
		</table><br>
		<input class="btn" type="button" value="목록" onclick="history.go(-1);">
	</form>
</div>

<%@ include file="../admin_footer.jsp"%>