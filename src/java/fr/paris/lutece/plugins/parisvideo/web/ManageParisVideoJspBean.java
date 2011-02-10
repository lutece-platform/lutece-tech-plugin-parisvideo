/*
 * Copyright (c) 2002-2009, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.parisvideo.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.parisvideo.business.ParisVideoAccount;
import fr.paris.lutece.plugins.parisvideo.business.ParisVideoHome;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.web.admin.PluginAdminPageJspBean;
import fr.paris.lutece.util.html.HtmlTemplate;


/**
 * class ManageDirectoryJspBean
 */
public class ManageParisVideoJspBean extends PluginAdminPageJspBean
{
	private static final long serialVersionUID = -9066072472517012072L;

	// Right
	public static final String RIGHT_MANAGE = "PARISVIDEO_MANAGEMENT";

    //templates
    private static final String TEMPLATE_MANAGE_PLUGIN = "admin/plugins/parisvideo/manage_plugin_parisvideo.html";

    // other constants
    private static final String PROPERTY_PAGE_TITLE_PARISVIDEO = "parisvideo.adminFeature.pageTitle";
	private static final String PARIS_VIDEO_ACCOUNT_KEY = "account";
	private static final String PARIS_VIDEO_MSG = "msg";

	private static final String REQUEST_ACTION = "action";
	private static final String REQUEST_ACTION_UPDATE = "insert_or_update";
	private static final String REQUEST_NAME = "name";
	private static final String REQUEST_LOGIN = "login";
	private static final String REQUEST_PASSWORD = "password";
	
    
    /**
     * Return management page of plugin directory
     * @param request The Http request
     * @return Html management page of plugin directory
     */
    public String getManageParisVideo( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_PARISVIDEO );
        
        boolean successMsg = registerParisVideoIfExist(request);
        
        ParisVideoAccount parisVideoAccount = getDefaultParisVideo();
       
        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put(PARIS_VIDEO_ACCOUNT_KEY , parisVideoAccount);
        model.put(PARIS_VIDEO_MSG , successMsg);
        
        HtmlTemplate templateList = AppTemplateService.getTemplate( TEMPLATE_MANAGE_PLUGIN, getLocale(  ), model );
        return getAdminPage( templateList.getHtml(  ) );
    }


	private ParisVideoAccount getDefaultParisVideo() 
	{
		ParisVideoAccount parisVideoAccount = null;
        Collection<ParisVideoAccount> _collec = ParisVideoHome.findAll( getPlugin(  ) );
        
        if( _collec == null || _collec.size() == 0 )
        {
        	parisVideoAccount = new ParisVideoAccount();
        } 
        else 
        {
        	//we take the first one in database
        	parisVideoAccount = (ParisVideoAccount) _collec.toArray()[0];
        }
		return parisVideoAccount;
	}


	private boolean registerParisVideoIfExist(HttpServletRequest request) 
	{
		String _strAction = request.getParameter( REQUEST_ACTION );
        String _strName = request.getParameter( REQUEST_NAME );
        String _strLogin = request.getParameter( REQUEST_LOGIN );
        String _strPassword = request.getParameter( REQUEST_PASSWORD );
        
        if(_strAction != null && _strAction.compareTo(REQUEST_ACTION_UPDATE) == 0)
        {
            ParisVideoAccount pVAToRegister = new ParisVideoAccount();
            pVAToRegister.setLogin( _strLogin );
            pVAToRegister.setName( _strName );
            pVAToRegister.setPassword( _strPassword );
        	ParisVideoHome.createOrUpdate( pVAToRegister, getPlugin() );
        	return true;
        }
        else
        {
        	return false;
        }
	}
}
