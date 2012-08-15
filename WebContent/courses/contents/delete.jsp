<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<form method="post" action="<%=request.getContextPath()%>/courses/contents/assignments.jsp">
				<p>Are you sure you want to delete [assignment name]?</p>
				
				<button type="submit" value="drop">Delete Assignment</button>
				<button type="reset" value="cancel">Cancel</button>
			</form>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>
