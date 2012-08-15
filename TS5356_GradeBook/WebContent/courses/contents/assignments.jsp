<jsp:directive.include file="/resources/header.jspf"/>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			
			<h2>Manage Course Assignments</h2>

			<form action="<%=request.getContextPath()%>/courses/contents/edit.jsp" method="post">
				<button type="submit" value="new">New Assignment</button>
	
				<table>
					<tr>
						<th>Assignment Type</th>
						<th>Name</th>
						<th>Week Due</th>
						<th>Grade Weight</th>
						<th>Actions</th>
					</tr>
					<tr>
						<td>Standard Assignment</td>
						<td>Brushing Up</td>
						<td>Week 1</td>
						<td>10%</td>
						<td><a href="<%=request.getContextPath()%>/courses/contents/edit.jsp">Edit</a> / 
						<a href="<%=request.getContextPath()%>/courses/contents/delete.jsp">Delete</a>
					</tr>
					<tr>
						<td>Standard Assignment</td>
						<td>Long Division</td>
						<td>Week 4</td>
						<td>10%</td>
						<td><a href="<%=request.getContextPath()%>/courses/contents/edit.jsp">Edit</a> / 
						<a href="<%=request.getContextPath()%>/courses/contents/delete.jsp">Delete</a>
					</tr>
					<tr>
						<td>Test</td>
						<td>Midterm</td>
						<td>Week 8</td>
						<td>30%</td>
						<td><a href="<%=request.getContextPath()%>/courses/contents/edit.jsp">Edit</a> / 
						<a href="<%=request.getContextPath()%>/courses/contents/delete.jsp">Delete</a>
					</tr>
					<tr>
						<td>Test</td>
						<td>Final</td>
						<td>Week 16</td>
						<td>45%</td>
						<td><a href="<%=request.getContextPath()%>/courses/contents/edit.jsp">Edit</a> / 
						<a href="<%=request.getContextPath()%>/courses/contents/delete.jsp">Delete</a>
					</tr>
				</table>
			</form>
			
		</div>
	    <jsp:directive.include file="/resources/navigation.jspf"/>
	</div>
</div>
<jsp:directive.include file="/resources/footer.jspf"/>
