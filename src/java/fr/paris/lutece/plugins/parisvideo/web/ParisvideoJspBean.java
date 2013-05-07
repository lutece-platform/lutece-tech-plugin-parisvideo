/*
 * Copyright (c) 2002-2013, Mairie de Paris
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

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tvnavig.server.searchengine.service.common.AssetOGC;
import com.tvnavig.server.searchengine.service.common.AssetPlayer;
import com.tvnavig.server.user.service.common.UserDomainResult;

import fr.paris.lutece.plugins.parisvideo.business.ParisVideoAccount;
import fr.paris.lutece.plugins.parisvideo.business.ParisVideoHome;
import fr.paris.lutece.plugins.parisvideo.service.ParisvideoService;
import fr.paris.lutece.portal.service.admin.AdminUserService;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.service.util.AppPathService;
import fr.paris.lutece.portal.web.insert.InsertServiceJspBean;
import fr.paris.lutece.portal.web.insert.InsertServiceSelectionBean;
import fr.paris.lutece.util.html.HtmlTemplate;
import fr.paris.lutece.util.html.Paginator;

/**
 * This class provides the user interface to manage features ( manage, create,
 * modify, remove )
 */
public class ParisvideoJspBean extends InsertServiceJspBean implements InsertServiceSelectionBean
{
	private static final long serialVersionUID = 1L;

	// Right
	public static final String RIGHT_MANAGE_PARISVIDEO = "PARISVIDEO_MANAGEMENT";

	// templates
	private static final String TEMPLATE_VIDEO_CHOOSE = "/admin/plugins/parisvideo/list_videos.html";
	private static final String TEMPLATE_VIDEO = "/admin/plugins/parisvideo/voir_video.html";

	// Markers
	private static final String MARK_PAGINATOR = "paginator";
	private static final String MARK_NB_ITEMS_PER_PAGE = "nb_items_per_page";
    private static final String PARAMETER_INPUT = "input";
    private static final String BASE_URL = "baseUrl";
    private static final String MARK_LIST_LIST = "videos";

	private static final String TEMPLATE_AUT_1 = "/admin/plugins/parisvideo/auth_1.html";
	private static final String TEMPLATE_AUT_2 = "/admin/plugins/parisvideo/auth_2.html";

	private static final String PARAMETER_PLUGIN_NAME = "plugin_name";

    private String _input;

    //Variables
    private int _nDefaultItemsPerPage = 6;
    private String _strCurrentPageIndex;
    private int _nItemsPerPage;

	private List<AssetOGC>  _videoList;

	private static Plugin _plugin = null;

    private void init( HttpServletRequest request )
    {
        String strPluginName = request.getParameter( PARAMETER_PLUGIN_NAME );
        //_user = AdminUserService.getAdminUser( request );
        _plugin  = PluginService.getPlugin( strPluginName );
        _input = request.getParameter( PARAMETER_INPUT );
    }

    /**
     * donne accès au form de saisie du login et mot de passe
     */
	public String getInsertServiceSelectorUI(HttpServletRequest request) 
	{
        init( request );

        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put( BASE_URL, AppPathService.getBaseUrl( request ) );
        model.put( PARAMETER_INPUT, _input );
        
		ParisVideoAccount parisVideoAccount = null;
        Collection<ParisVideoAccount> _collec = ParisVideoHome.findAll( _plugin );
        
        if( _collec == null || _collec.size() == 0 )
        {
        	parisVideoAccount = new ParisVideoAccount();
        } 
        else 
        {
        	//we take the first one in database
        	parisVideoAccount = (ParisVideoAccount) _collec.toArray()[0];
        }
        
        ParisvideoService parisService = new ParisvideoService();
        
        List<UserDomainResult> domainList = new ArrayList<UserDomainResult>();
		try 
		{
	        UserDomainResult[] domainArray = null;
			domainArray = parisService.getDomain(parisVideoAccount.getLogin(), parisVideoAccount.getPassword());
			domainList = Arrays.asList( domainArray );
		} 
		catch (Exception e) 
		{
		}
        
        model.put( "domains", domainList );

        Locale locale = AdminUserService.getLocale( request );
        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_AUT_2, locale, model );

        return template.getHtml(  );
	}
	
	/**
	 * video list for a domain
	 */
	public String doAuth2(HttpServletRequest request) throws Exception
	{
        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put( PARAMETER_INPUT, request.getParameter( PARAMETER_INPUT ) );
        
        _strCurrentPageIndex = Paginator.getPageIndex( request, Paginator.PARAMETER_PAGE_INDEX, _strCurrentPageIndex );
        _nItemsPerPage = Paginator.getItemsPerPage( request, Paginator.PARAMETER_ITEMS_PER_PAGE, _nItemsPerPage, _nDefaultItemsPerPage );

        String strDomain = request.getParameter("domain");
        if( strDomain != null && strDomain.length()>0 )
        {//if we come from the search form (and not from the pagination)

        	Integer domainId = Integer.decode( strDomain );

            String strBeginDate = request.getParameter("beginDate");
            Calendar beginDate = getCalendarFromString(strBeginDate);
            
            String strEndDate = request.getParameter("endDate");
            Calendar endDate = getCalendarFromString(strEndDate);

            String searchSubject = request.getParameter("searchSubject");
            if(searchSubject!=null && searchSubject.length()==0)
            	searchSubject = null;
            
	        ParisvideoService parisService = new ParisvideoService();
	        _videoList = parisService.getVideos(domainId, searchSubject, null, beginDate, endDate, null);
        }
        
        String strBaseUrl = AppPathService.getBaseUrl( request );
        String strUrl = strBaseUrl + "jsp/admin/plugins/parisvideo/DoAuth2.jsp";

        Paginator paginator = new Paginator( _videoList, _nItemsPerPage, strUrl, Paginator.PARAMETER_PAGE_INDEX, _strCurrentPageIndex );

        model.put( MARK_NB_ITEMS_PER_PAGE, "" + _nItemsPerPage );
        model.put( MARK_PAGINATOR, paginator );
        model.put( MARK_LIST_LIST, paginator.getPageItems(  ) );
        model.put( BASE_URL, AppPathService.getBaseUrl( request ) );

        Locale locale = AdminUserService.getLocale( request );
        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_VIDEO_CHOOSE, locale, model );

        return template.getHtml(  );
	}

	/**
	 * 
	 * @param strBeginDate 20090523
	 * @return 
	 */
	private Calendar getCalendarFromString(String strDate) 
	{
		Calendar beginDate = null;
		if(strDate != null && strDate.length()>0)
		{
			beginDate = Calendar.getInstance();
			String strYear = strDate.substring(0, 4);
			int year = Integer.parseInt(strYear);
			String strMonth = strDate.substring(5, 7);
			int month = Integer.parseInt(strMonth);
			String strDay = strDate.substring(8, 10);
			int date = Integer.parseInt(strDay);
			beginDate.set(year, month, date);
		}
		return beginDate;
	}
	
	/**
	 * 
	 */
	public String doVideoChoose(HttpServletRequest request) throws Exception
	{
        Map<String, Object> model = new HashMap<String, Object>(  );
        
        if(_input == null)
        	_input = request.getParameter( PARAMETER_INPUT );
        
        model.put( PARAMETER_INPUT, _input );
        model.put( BASE_URL, AppPathService.getBaseUrl( request ) );

        String strVideoId = request.getParameter("videoId");
        int videoId = Integer.parseInt(strVideoId);

        ParisvideoService parisService = new ParisvideoService();
        AssetPlayer ap = parisService.getVideo(videoId);

        String strHtmlCode = ap.getHtmlEmbed();
        
        return insertUrlWithoutEscape( request, _input, strHtmlCode );
	}

	/**
	 * 
	 */
	public String doVoir(HttpServletRequest request) throws Exception
	{
        String strVideoId = request.getParameter("id");
        int videoId = Integer.parseInt(strVideoId);

        ParisvideoService parisService = new ParisvideoService();
        AssetPlayer ap = parisService.getVideo(videoId);

        Map<String, String> model = new HashMap<String, String>(  );
        model.put( BASE_URL, AppPathService.getBaseUrl( request ) );
        model.put( "code", ap.getHtmlEmbed() );

        Locale locale = AdminUserService.getLocale( request );
        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_VIDEO, locale, model );

        return template.getHtml();
	}
}