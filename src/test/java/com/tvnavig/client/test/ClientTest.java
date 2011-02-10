package com.tvnavig.client.test;

import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import com.tvnavig.server.searchengine.service.common.AssetOGC;
import com.tvnavig.server.user.service.common.UserDomainResult;

import fr.paris.lutece.plugins.parisvideo.service.ParisvideoService;

/**
 * Le webservice ParisTV n'est accessible que depuis l'intranet
 * ce test unitaire n'a donc aucune chance de fonctionner depuis Continuum depuis internet
 */
public class ClientTest extends TestCase
{
	//http://v01-vnavig.apps.paris.mdp
	private final String LOGIN = "flex";
	private final String PASSWORD = "flex";
	
	public void testTest() throws Exception
	{ 
		ParisvideoService videoService = new ParisvideoService();
		UserDomainResult[] udrArray = videoService.getDomain(LOGIN, PASSWORD);
		
		UserDomainResult firstUserDomain = udrArray[0];
		
		List<AssetOGC> list = videoService.getVideos(firstUserDomain.getId(), null, null, null, null, null);
		assertTrue(list.size()>0);
		
		List<AssetOGC> list2 = videoService.getVideos(firstUserDomain.getId(), "velib", null, null, null, null);
		assertTrue(list2.size()>0);

		Calendar beginDate = Calendar.getInstance();
		beginDate.set(2009, 04-1, 01);
//		beginDate.add ( Calendar.DAY_OF_YEAR, -100 );
		Calendar endDate = Calendar.getInstance();
		List<AssetOGC> list3 = videoService.getVideos(firstUserDomain.getId(), null, null, beginDate, endDate, null);
		assertTrue(list3.size()>0);
	}
}