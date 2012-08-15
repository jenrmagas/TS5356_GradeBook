<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<h2>Enroll in Course</h2>
			<form method="post" class="formstyle" action="<%=request.getContextPath()%>/listings/search.jsp">
				<fieldset>
					<label for="course">
						<span>Course ID:</span>
						<input type="text" disabled="disabled" 
						id="course" name="course" value="TS5356"/>
					</label>
					<br/>
					<label for="section">
						<span>Section:</span>
						<input type="text" disabled="disabled" 
						id="section" name="section" value="01"/>
					</label>
					<br/>
					<label for="semester">
						<span>Semester:</span>
						<input type="text" disabled="disabled" 
						id="semester" name="semester" value="2013, Winter"/>
					</label>
					<br/>
					<label for="uid">
						<span>User ID (UID):</span>
						<input type="text" id="uid" name="uid" />
					</label>
				</fieldset>
				<button type="submit" value="Search">Enroll</button> 
				<button type="reset" value="cancel">Cancel</button>
			</form>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>