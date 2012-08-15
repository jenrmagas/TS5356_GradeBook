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
						<select id="course" name="course"> <!-- TODO: Populate from master courses -->
							<option value="">Select One</option>
							<option value="TS5321">TS5321</option>
							<option value="SCI1200">SCI1200</option>
						</select>
					</label>
				</fieldset>
				<fieldset>
					<legend>Listing Information</legend>
					<label for="instructor">
						<span>Instructor:</span>
						<select id="instructor" name="instructor"> <!--  TODO: Populate with all users in role "instructor" -->
							<option value="">Select One</option>
							<option value="12973">Brueggemann, Tim</option>
							<option value="125378">McArthur, Katherine</option>
							<option value="192834">Smith, Dr.</option>
						</select>
					</label>
					<br/>
					<label for="semester">
						<span>Semester:</span>
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
				</fieldset>
				<br/>
				<button type="submit" value="save">Save Changes</button>
				<button type="reset" value="cancel">Cancel Changes</button>
			</form>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>