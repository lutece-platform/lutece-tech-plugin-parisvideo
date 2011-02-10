<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="parisVideoManage" scope="session" class="fr.paris.lutece.plugins.parisvideo.web.ManageParisVideoJspBean" />

<% parisVideoManage.init( request, parisVideoManage.RIGHT_MANAGE ); %>
<%= parisVideoManage.getManageParisVideo( request ) %>

<%@ include file="../../AdminFooter.jsp" %>