<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<h2>Course Listing</h2>
			<form method="post" class="formstyle" action="<%=request.getContextPath()%>/listings/search.jsp">
				<fieldset>
					<legend>Master Course Information</legend>
					<label for="course">
						<span>Course ID:</span>
						TS5321
					</label>
				</fieldset>
				<fieldset>
					<legend>Listing Information</legend>
					<label for="instructor">
						<span>Instructor:</span>
						McArthur, Katherine
					</label>
					<br/>
					<label for="semester">
						<span>Semester:</span>
						Winter 2012
					</label>
				</fieldset>
			</form>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>