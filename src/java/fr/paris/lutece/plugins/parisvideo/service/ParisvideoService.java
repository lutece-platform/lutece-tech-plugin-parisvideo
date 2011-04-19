package fr.paris.lutece.plugins.parisvideo.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;

import com.tvnavig.server.asset.service.common.MetaValueResult;
import com.tvnavig.server.searchengine.SearchAssetService;
import com.tvnavig.server.searchengine.SearchAssetServiceService;
import com.tvnavig.server.searchengine.SearchAssetServiceServiceLocator;
import com.tvnavig.server.searchengine.service.common.AssetOGC;
import com.tvnavig.server.searchengine.service.common.AssetPlayer;
import com.tvnavig.server.user.UserService;
import com.tvnavig.server.user.UserServiceService;
import com.tvnavig.server.user.UserServiceServiceLocator;
import com.tvnavig.server.user.service.common.UserDomainResult;
import com.tvnavig.server.user.service.common.UserServiceResult;

/**
 * This class allows to get video from ParisTV (from wsdl files with Axis 1.4)
 * http://v01-adminvnavig.apps.paris.mdp/tvnavig/default/services
 * http://v01-vnavig.apps.paris.mdp
 * 
 * One can access those webservices from Paris intranet only
 * 
 * See junit test to understand how it works.
 */
public class ParisvideoService
{
	/**
	 * get the domain list for a give login/password
	 */
	public UserDomainResult[] getDomain(String login, String password) throws Exception
	{
		Call.setTransportForProtocol( "http", SingleSessionHttpTransport.class );

		UserServiceService uss = new UserServiceServiceLocator();
		UserService port = uss.getUserService(  );
		( ( Stub ) port )._setProperty( Stub.SESSION_MAINTAIN_PROPERTY, true );
		
		UserServiceResult usr = port.authenticate(login, password);
		UserDomainResult[] udrArray = port.getDomainsFromUser(usr.getUserId());
		return udrArray;
	}

	/**
	 * Get videos from webservices. You need to be connected first.
	 * 
	 * @param domainId there are domains for each account
	 * @param searchSubject
	 * @param metaValues
	 * @param beginDate
	 * @param endDate
	 * @param format
	 * @return the list of videos (AssetOGC is a object genereated by the WSDL)
	 * @throws Exception
	 */
	public List<AssetOGC> getVideos(Integer domainId, String searchSubject, MetaValueResult[] metaValues, Calendar beginDate, Calendar endDate, String format) throws Exception
	{
		SearchAssetServiceService as = new SearchAssetServiceServiceLocator();
		SearchAssetService portAS = as.getSearchAssetService();
		( ( Stub ) portAS )._setProperty( Stub.SESSION_MAINTAIN_PROPERTY, true );
		
		 AssetOGC[] list = portAS.getAssetsList(domainId, searchSubject, metaValues, beginDate, endDate, format);
		 List<AssetOGC> videos = Arrays.asList( list );
		 Collections.sort(videos);
		 return videos;
	}

	/**
	 * get video from its ID
	 */
	public AssetPlayer getVideo(int videoId) throws Exception
	{
		SearchAssetServiceService as = new SearchAssetServiceServiceLocator();
		SearchAssetService portAS = as.getSearchAssetService();
		( ( Stub ) portAS )._setProperty( Stub.SESSION_MAINTAIN_PROPERTY, true );

		AssetPlayer ap = portAS.getAssetPlayer( videoId );
		return ap;
	}
}