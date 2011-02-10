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
package fr.paris.lutece.plugins.parisvideo.business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.sql.DAOUtil;


/**
 * This class provides Data Access methods for ParisVideoAccount objects
 */
public class ParisVideoDAO implements IParisVideoDAO
{
    // Constants
    private static final String SQL_QUERY_NEWPK = "SELECT max( id_account ) FROM parisvideo_account ";
    private static final String SQL_QUERY_SELECTALL = "SELECT id_account, name, login, password FROM parisvideo_account";
    private static final String SQL_QUERY_INSERT = "INSERT INTO parisvideo_account ( id_account , name, login, password, date_update )  VALUES ( ?, ?, ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETEALL = "DELETE FROM parisvideo_account";
    
    /**
     * Generates a new primary key
     * @param plugin The plugin
     * @return The new primary key
     */
     private int newPrimaryKey( Plugin plugin )
     {
         DAOUtil daoUtil = new DAOUtil( SQL_QUERY_NEWPK, plugin );
         daoUtil.executeQuery(  );

         int nKey;

         if ( !daoUtil.next(  ) )
         {
             // if the table is empty
             nKey = 1;
         }

         nKey = daoUtil.getInt( 1 ) + 1;

         daoUtil.free(  );

         return nKey;
     }

     /**
     * Insert or update the record in the table.
     *
     * @param parisVideoAccount The parisVideoAccount object
     * @param plugin The plugin
     */
    public void insert( ParisVideoAccount parisVideoAccount, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin );
        int id = newPrimaryKey( plugin );
        parisVideoAccount.setId( id );
        daoUtil.setInt( 1, parisVideoAccount.getId(  ) );
        daoUtil.setString( 2, parisVideoAccount.getName(  ) );
        daoUtil.setString( 3, parisVideoAccount.getLogin(  ) );
        daoUtil.setString( 4, parisVideoAccount.getPassword(  ) );
        daoUtil.setTimestamp( 5, new Timestamp( new java.util.Date(  ).getTime(  ) ) );
        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the list of parisVideoAccounts
     *
     * @param plugin The plugin
     * @return The Collection of the parisVideoAccounts
     */
    public Collection<ParisVideoAccount> selectAll( Plugin plugin )
    {
        Collection<ParisVideoAccount> parisVideoAccountList = new ArrayList<ParisVideoAccount>(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            ParisVideoAccount parisVideoAccount = new ParisVideoAccount(  );
            parisVideoAccount.setId( daoUtil.getInt( 1 ) );
            parisVideoAccount.setName( daoUtil.getString( 2 ) );
            parisVideoAccount.setLogin( daoUtil.getString( 3 ) );
            parisVideoAccount.setPassword( daoUtil.getString( 4 ) );

            parisVideoAccountList.add( parisVideoAccount );
        }

        daoUtil.free(  );

        return parisVideoAccountList;
    }

	public void deleteAll(Plugin plugin) 
	{
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETEALL, plugin );
        daoUtil.executeUpdate(  );
        daoUtil.free(  );
	}
}