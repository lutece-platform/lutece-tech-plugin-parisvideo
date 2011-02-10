/**
 * UserServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tvnavig.server.user;

public interface UserServiceService extends javax.xml.rpc.Service {
    public java.lang.String getUserServiceAddress();

    public com.tvnavig.server.user.UserService getUserService() throws javax.xml.rpc.ServiceException;

    public com.tvnavig.server.user.UserService getUserService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
