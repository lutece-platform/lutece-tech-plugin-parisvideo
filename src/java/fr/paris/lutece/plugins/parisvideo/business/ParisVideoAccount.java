/*
 * Copyright (c) 2002-2014, Mairie de Paris
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
 *  3. Neither the description of 'Mairie de Paris' nor 'Lutece' nor the descriptions of its
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
package fr.paris.lutece.plugins.parisvideo.business;



/**
 * This class represents business object InsertAjax
 */
public class ParisVideoAccount
{
    public static final String RESOURCE_TYPE = "PARISVIDEO";
    private int _nId;
	private String _strName;
    private String _strLogin;
    private String _strPassword;
    
    public int getId() 
    {
		return _nId;
	}
    
	public void setId(int id) 
	{
		_nId = id;
	}

	public String getName() 
	{
		if(_strName == null)
			return "";
		else
			return _strName;
	}

	public void setName(String name) 
	{
		_strName = name;
	}
	
	public String getLogin() 
	{
		if(_strLogin== null)
			return "";
		else
			return _strLogin;
	}
	
	public void setLogin(String login) 
	{
		_strLogin = login;
	}

	public String getPassword() 
	{
		if(_strPassword == null)
			return "";
		else
			return _strPassword;
	}

	public void setPassword(String password) 
	{
		_strPassword = password;
	}
}
