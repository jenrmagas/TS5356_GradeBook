<%@ include file="/resources/header.jspf" %>
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Main Content start -->
			<h2>Course</h2>
			<form method="post" class="formstyle" action="<%=request.getContextPath()%>/courses/search.jsp">
				<fieldset>
					<legend>Course Information</legend>
					<label for="cid">
						<span>Course ID:</span>
						<input type="text" id="cid" name="cid" />
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
					<br>
					<label for="description">
						<span>Description:</span>
						<textarea rows="5"></textarea>
					</label>
				</fieldset>
				<br/>
				<button type="submit" value="save">Save Course</button>
				<button type="reset" value="cancel">Cancel</button>
			</form>
			<!-- Main Content end -->
		</div>
	    <%@ include file="/resources/navigation.jspf" %>
	</div>
</div>
<%@ include file="/resources/footer.jspf" %>