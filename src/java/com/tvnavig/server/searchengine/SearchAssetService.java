/**
 * SearchAssetService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tvnavig.server.searchengine;

public interface SearchAssetService extends java.rmi.Remote {
    public com.tvnavig.server.searchengine.service.common.AssetOGC getAsset(int domainId, int id) throws java.rmi.RemoteException, com.tvnavig.server.searchengine.SearchAssetServiceException;
    public com.tvnavig.server.searchengine.service.common.AssetOGC[] getAssetsList(int domainId, java.lang.String searchSubject, com.tvnavig.server.asset.service.common.MetaValueResult[] metaValues, java.util.Calendar beginDate, java.util.Calendar endDate, java.lang.String format) throws java.rmi.RemoteException, com.tvnavig.server.searchengine.SearchAssetServiceException;
    public com.tvnavig.server.searchengine.service.common.AssetPlayer getAssetPlayer(int id) throws java.rmi.RemoteException, com.tvnavig.server.searchengine.SearchAssetServiceException;
}
