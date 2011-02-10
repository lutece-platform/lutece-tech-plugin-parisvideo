
<%@ page errorPage="ErrorPage.jsp" %>
<jsp:useBean id="insertparisvideo" scope="session" class="fr.paris.lutece.plugins.parisvideo.web.ParisvideoJspBean" />
<%= insertparisvideo.doAuth1( request ) %>
