<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<table>
				<tr>
					<th>CID</th>
					<th>Course Name</th>
					<th>Session</th>
					<th>Actions</th>
				</tr>
				<tr>
					<td>MTH1200</td>
					<td>College Algebra</td>
					<td>02</td>
					<td><a href="<%=request.getContextPath()%>/listings/contents/assignments.jsp">Manage Assignments</a></td>
				</tr>
				<tr>
					<td>MTH1200</td>
					<td>College Algebra</td>
					<td>05</td>
					<td><a href="<%=request.getContextPath()%>/listings/contents/assignments.jsp">Manage Assignments</a></td>
				</tr>
			</table>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>
