<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article id="order_list_form">
	<div align="center">
		<h2>현재 예약 확인</h2>
		<form>
			<div align="center">
				<table id="orderList" style="text-align: center;"> 
					<tr>
						<th width="80">예약번호</th>
						<th width="100">예약자이름</th>
						<th width="150">지점</th>
						<th width="50">구역</th>
						<th width="70">결제금액</th>
						<th width="85">체크인</th>
						<th width="85">체크아웃</th>
						<th colspan="2" width="215">예약 상태</th>
						<th width="120"></th>
					</tr>
					<c:forEach items="${campOrderList}" var="campOrderList">
						<tr>
							<td>${campOrderList.oseq}</td> 
							<td>${campOrderList.order_name}</td>
							<td>${campOrderList.camp_name}</td>
							<td>${campOrderList.camp_zone}</td>
							<td>${campOrderList.total_price}</td>
							<td>${campOrderList.indate}</td>
							<td>${campOrderList.outdate}</td>
							<c:choose>
								<c:when test="${campOrderList.indate < today}">
									<td colspan="2">
										<span style="color: rgb(145,154,157);">지난내역</span>
									</td>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${campOrderList.order_status == 'y'}">
											<td>
												<span style="color: red;">예약 확정 완료</span>
											</td>
										</c:when>
										<c:when test="${campOrderList.order_status == 'n'}">
											<td>
												<span>예약 진행 중</span>
											</td>
										</c:when>
									</c:choose>
									<td><a href="myOrder_detail?oseq=${campOrderList.oseq}" onclick="window.open(this.href, '_blank', 'toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=500, height=500'); return false;">예약상세내용보기</a></td>
									<td><button id="btn" onclick="myCancel(${campOrderList.oseq})">예약취소하기</button></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>	
	</div>
	<%@ include file="myOrder_page_area.jsp"%>
</article>

<%@ include file="../footer.jsp" %>