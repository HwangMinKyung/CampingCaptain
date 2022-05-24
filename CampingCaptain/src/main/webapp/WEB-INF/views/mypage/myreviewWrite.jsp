<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="review_write_form" align="center">
	<h2> 리얼 리뷰 작성하기 </h2>
    <h5> 고객님의 소중한 후기에 부족들은 감사하고 있습니다.</h5>    
	<form name="formm" method="post" id="myreview" action="insertMyReview">	
	    <label>Title</label>
	    <input type="text" name="title" id="title" value="${RealReviewVO.title}" size="45">
	      
		<select name="campingname"id="campingname">
			<c:forEach items="${conditionBranchMap}" var="option">
				<option value="${option.value}">${option.key}</option>
			</c:forEach>
		</select>
	 	<br> 
	 	<input type="text" class="class" name="id" id="id" value="${UsersVO.id}" style="display:none">
		<label class="contentname">Content</label>
	    <textarea rows="8" cols="65" id="content" name="content"></textarea>
		<div class="clear"></div>
	 	<div id="buttons">
			<input type="button" value="글쓰기" class="submit" onclick="input_myreview()"> 
			<input type="reset" value="다시쓰기" class="cancel">
			<input type="button" value="목록" onclick="location.href='myreview'">
		</div>
	</form>
</div>
	
<%@ include file="../footer.jsp" %>