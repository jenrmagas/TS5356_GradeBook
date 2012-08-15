<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<h2>Search Students</h2>
			<form method="post" class="formstyle" action="<%=request.getContextPath()%>/students/search.jsp">
				<fieldset>
					<legend>Student Information</legend>

					<label for="uid">
						<span>User ID (UID):</span>
						<input type="text" id="uid" name="uid" />
					</label>
					<br/>
					<label for="lname">
						<span>Last Name:</span>
						<input type="text" id="lname" name="lname" />
					</label>
					<br/>
					<label for="fname">
						<span>First Name:</span>
						<input type="text" id="fname" name="fname" />
					</label>
				</fieldset>
				<button type="submit" value="Search">Search</button>
			</form>

			<h2>Search Results</h2>

			<table>
				<tr>
					<th>UID</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Actions</th>
				</tr>
				<tr>
					<td>1867013</td>
					<td>Magas</td>
					<td>Jen</td>
					<td><a href="<%=request.getContextPath()%>/students/view_grades.jsp">View Grades</a> / 
					<a href="<%=request.getContextPath()%>/students/edit_user.jsp">Edit</a></td>
				</tr>
				<tr>
					<td>1293542</td>
					<td>Magas</td>
					<td>Mark</td>
					<td><a href="<%=request.getContextPath()%>/students/view_grades.jsp">View Grades</a> / 
					<a href="<%=request.getContextPath()%>/students/edit_user.jsp">Edit</a></td>
				</tr>
			</table>

			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>
