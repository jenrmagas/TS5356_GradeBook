<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<h2>Manage Enrollment</h2>
			<table>
				<tr>
					<th>ID</th>
					<th>Department</th>
					<th>Name</th>
					<th>Semester</th>
					<th>Section</th>
					<th>Instructor</th>
					<th>Actions</th>
				</tr>
				<tr>
					<td>SCI2390</td>
					<td>Sciences</td>
					<td>Biology III</td>
					<td>2013, Winter</td>
					<td>01</td>
					<td>Dr. Smith</td>
					<td><a href="<%=request.getContextPath()%>/listings/view.jsp">View</a> / 
					<a href="<%=request.getContextPath()%>/students/drop_enrollment.jsp">Drop</a></td>
				</tr>
				<tr>
					<td>MTH1200</td>
					<td>Math</td>
					<td>College Algebra</td>
					<td>2013, Winter</td>
					<td>05</td>
					<td>Prof. Weisser</td>
					<td><a href="<%=request.getContextPath()%>/listings/view.jsp">View</a> / 
					<a href="<%=request.getContextPath()%>/students/drop_enrollment.jsp">Drop</a></td>
				</tr>
			</table>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>
