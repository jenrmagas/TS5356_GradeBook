<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<h2>Update Grades: Assignment [#]</h2>
			<form action="<%=request.getContextPath()%>/listings/contents/assignments.jsp" method="post" >
				<table>
					<tr>
						<th>User ID</th>
						<th>Name</th>
						<th>Grade</th>
						<th>Notes</th>
					</tr>
					<tr>
						<td>1867013</td>
						<td>Magas, Jen</td>
						<td><input maxlength="2" type="text" id="grade_1867013" value="92" /></td>
						<td><textarea cols="20" rows="4"></textarea></td>
					</tr>
					<tr>
						<td>1293542</td>
						<td>Magas, Mark</td>
						<td><input maxlength="2" type="text" id="grade_1293542" value="86" /></td>
						<td><textarea cols="20" rows="4">Grade reduced for late submission</textarea></td>
					</tr>
				</table>
				<button type="submit">Update Grades</button> 
				<button type="reset">Cancel</button>
			</form>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>
