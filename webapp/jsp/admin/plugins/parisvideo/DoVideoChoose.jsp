<%@ page errorPage="ErrorPage.jsp" %>
<jsp:useBean id="insertparisvideo" scope="session" class="fr.paris.lutece.plugins.parisvideo.web.ParisvideoJspBean" />
<%
	response.sendRedirect( insertparisvideo.doVideoChoose( request ) );
%>
