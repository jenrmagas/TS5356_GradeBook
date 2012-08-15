<jsp:directive.include file="/resources/header.jspf"/>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			
			<h2>Manage Course Assignments</h2>

			<form class="formstyle" action="<%=request.getContextPath()%>/courses/contents/assignments.jsp" method="post">
				<fieldset>
					<label for="assignmentType">
						<span>Assignment Type:</span>
						<select id="assignmentType" name="assignmentType">
							<option>Please Select</option>
							<option value="Standard">Standard Assignment</option>
							<option value="Test">Test</option>
							<option value="Quiz">Quiz</option>
						</select>
					</label>
					<br />
					<label for="name">
						<span>Name:</span>
						<input type="text" id="name" name="name" />
					</label>
					<br/>
					<label for="week">
						<span>Week Due:</span>
						<input type="number" id="week" name="week" />
					</label>
					<br/>
					<label for="weight">
						<span>Grade Weight:</span>
						<input type="number" id="weight" name="weight" />
					</label>
					<br/>
					<label for="description">
						<span>Description:</span>
						<textarea id="description" name="description"></textarea>
					</label>
				</fieldset>
				
				<button type="submit" value="update">Save Assignment</button> 
				<button type="reset" value="cancel">Cancel Changes</button>
			</form>
			
		</div>
	    <jsp:directive.include file="/resources/navigation.jspf"/>
	</div>
</div>
<jsp:directive.include file="/resources/footer.jspf"/>
