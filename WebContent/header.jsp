<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>

<header>
<div class="titlehaikei" style="display: flex; justify-content: space-between; align-items: center;">
    <h1 style="margin: 0;">得点管理システム</h1>


    <div style="font-size: 0.9em;">
    	<%
    	bean.Teacher teacher = (bean.Teacher) session.getAttribute("teacher");
    	if (teacher != null) {
    	%>
    		<span><%= teacher.getName() %>様 <a href="<%= request.getContextPath() %>/LogoutAction">ログアウト</a></span>
    	<%
    	}
    	%>
    </div>
</div>
<hr>
</header>
