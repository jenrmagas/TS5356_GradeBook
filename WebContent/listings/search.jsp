<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<h2>Search Course Listings</h2>
			<form method="post" class="formstyle" action="<%=request.getContextPath()%>/listings/search.jsp">
				<fieldset>
					<legend>Master Course</legend>

					<label for="cid">
						<span>Course ID:</span>
						<input type="text" id="cid" name="cid" />
					</label>
					<br/>
					<label for="cname">
						<span>Course Name:</span>
						<input type="text" id="lname" name="lname" />
					</label>
					<br/>
					<label for="dept">
						<span>Department:</span>
						<select id="dept" name="dept"> <!--  TODO: Populate from Database -->
							<option value="">Select One</option>
							<option value="ENG">English &amp; Literature</option>
							<option value="MTH">Math</option>
							<option value="SCI">Sciences</option>
							<option value="TCH">Technology &amp; Information Systems</option>
						</select>
					</label>
				</fieldset>
				<fieldset>
				<legend>Course Listing:</legend>
					<label for="semester">
						<span>Semester</span>
						<select id="semester" name="semester"> <!--  TODO: Populate from database -->
							<option value="">Select One</option>
							<optgroup label="2012">
								<option value="2012q1">Winter</option>
								<option value="2012q2">Spring</option>
								<option value="2012q3">Summer</option>
								<option value="2012q4">Fall</option>
							</optgroup>
							<optgroup label="2013">
								<option value="2013q1">Winter</option>
								<option value="2013q2">Spring</option>
								<option value="2013q3">Summer</option>
								<option value="2013q4">Fall</option>
							</optgroup>
						</select>
					</label>
					<br/>
					<label for="section">
						<span>Section:</span>
						<input type="text" id="section" name="section" />
					</label>
					<br/>
					<label for="instructor">
						<span>Instructor:</span>
						<input type="text" id="instructor" name="instructor" />
					</label>
				</fieldset>
				<button type="submit" value="Search">Search</button>
			</form>
			
			<h2>Search Results</h2>
			
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
					<td><a href="<%=request.getContextPath()%>/listings/edit.jsp?cid=123901">Edit</a> / 
					<a href="<%=request.getContextPath()%>/listings/delete.jsp">Delete</a> / 
					<a href="<%=request.getContextPath()%>/listings/enroll.jsp">Enroll</a></td>
				</tr>
				<tr>
					<td>MTH1200</td>
					<td>Math</td>
					<td>College Algebra</td>
					<td>2013, Winter</td>
					<td>05</td>
					<td>Prof. Weisser</td>
					<td><a href="<%=request.getContextPath()%>/listings/edit.jsp">Edit</a> / 
					<a href="<%=request.getContextPath()%>/listings/delete.jsp">Delete</a> / 
					<a href="<%=request.getContextPath()%>/listings/enroll.jsp">Enroll</a></td>
				</tr>
			</table>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>
