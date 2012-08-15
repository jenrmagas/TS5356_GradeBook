<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<h2>Course Assignment Results</h2>
			
			<table>
				<tr>
					<th>Assignment Type</th>
					<th>Assignment #</th>
					<th>Assignment Name</th>
					<th>Grade Weight</th>
					<th>Due Date</th>
					<th>Class Average</th>
					<th>Actions</th>
				</tr>
				<tr>
					<td>Standard Assignment</td>
					<td>1</td>
					<td>Long Division</td>
					<td>10%</td>
					<td>01/23/2013</td>
					<td>89%</td>
					<td><a href="<%=request.getContextPath()%>/listings/contents/grades.jsp">Update Grades</a></td>
				</tr>
				<tr>
					<td>Quiz</td>
					<td>2</td>
					<td>Long Division Concepts</td>
					<td>2%</td>
					<td>01/25/2013</td>
					<td>78%</td>
					<td><a href="<%=request.getContextPath()%>/listings/contents/grades.jsp">Update Grades</a></td>
				</tr>
			</table>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>
