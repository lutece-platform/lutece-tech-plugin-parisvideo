/**
 * UserService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tvnavig.server.user;

public interface UserService extends java.rmi.Remote {
    public void isAlive() throws java.rmi.RemoteException;
    public com.tvnavig.server.user.service.common.UserServiceResult authenticate(java.lang.String login, java.lang.String password) throws java.rmi.RemoteException, com.tvnavig.server.user.UserServiceException;
    public com.tvnavig.server.user.service.common.UserDomainResult[] getDomainsFromUser(int userId) throws java.rmi.RemoteException, com.tvnavig.server.user.UserServiceException;
    public com.tvnavig.server.user.service.common.UserGroupandMetaDataResult getGroupsandMetaDatasFromDomain(int domainId) throws java.rmi.RemoteException, com.tvnavig.server.user.UserServiceException;
}
