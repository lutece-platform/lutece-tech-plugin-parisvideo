/*
 * Copyright (c) 2002-2017, Mairie de Paris
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
/**
 * SearchAssetServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tvnavig.server.searchengine;

public class SearchAssetServiceServiceLocator extends org.apache.axis.client.Service implements com.tvnavig.server.searchengine.SearchAssetServiceService {

    public SearchAssetServiceServiceLocator() {
    }


    public SearchAssetServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SearchAssetServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SearchAssetService
    private java.lang.String SearchAssetService_address = "http://v01-adminvnavig-rec7.apps.paris.mdp/tvnavig/default/services/OGCSearchAssetService";

    public java.lang.String getSearchAssetServiceAddress() {
        return SearchAssetService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SearchAssetServiceWSDDServiceName = "SearchAssetService";

    public java.lang.String getSearchAssetServiceWSDDServiceName() {
        return SearchAssetServiceWSDDServiceName;
    }

    public void setSearchAssetServiceWSDDServiceName(java.lang.String name) {
        SearchAssetServiceWSDDServiceName = name;
    }

    public com.tvnavig.server.searchengine.SearchAssetService getSearchAssetService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SearchAssetService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSearchAssetService(endpoint);
    }

    public com.tvnavig.server.searchengine.SearchAssetService getSearchAssetService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.tvnavig.server.searchengine.SearchAssetServiceSoapBindingStub _stub = new com.tvnavig.server.searchengine.SearchAssetServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSearchAssetServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSearchAssetServiceEndpointAddress(java.lang.String address) {
        SearchAssetService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.tvnavig.server.searchengine.SearchAssetService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.tvnavig.server.searchengine.SearchAssetServiceSoapBindingStub _stub = new com.tvnavig.server.searchengine.SearchAssetServiceSoapBindingStub(new java.net.URL(SearchAssetService_address), this);
                _stub.setPortName(getSearchAssetServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SearchAssetService".equals(inputPortName)) {
            return getSearchAssetService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://searchengine.server.tvnavig.com", "SearchAssetServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://searchengine.server.tvnavig.com", "SearchAssetService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SearchAssetService".equals(portName)) {
            setSearchAssetServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
