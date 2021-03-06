/**
 * UserGroupandMetaDataResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tvnavig.server.user.service.common;

public class UserGroupandMetaDataResult  implements java.io.Serializable {
    private com.tvnavig.server.user.service.common.MetaDataResult[] metaDataList;

    private com.tvnavig.server.user.service.common.UserGroupResult[] userGroupList;

    public UserGroupandMetaDataResult() {
    }

    public UserGroupandMetaDataResult(
           com.tvnavig.server.user.service.common.MetaDataResult[] metaDataList,
           com.tvnavig.server.user.service.common.UserGroupResult[] userGroupList) {
           this.metaDataList = metaDataList;
           this.userGroupList = userGroupList;
    }


    /**
     * Gets the metaDataList value for this UserGroupandMetaDataResult.
     * 
     * @return metaDataList
     */
    public com.tvnavig.server.user.service.common.MetaDataResult[] getMetaDataList() {
        return metaDataList;
    }


    /**
     * Sets the metaDataList value for this UserGroupandMetaDataResult.
     * 
     * @param metaDataList
     */
    public void setMetaDataList(com.tvnavig.server.user.service.common.MetaDataResult[] metaDataList) {
        this.metaDataList = metaDataList;
    }


    /**
     * Gets the userGroupList value for this UserGroupandMetaDataResult.
     * 
     * @return userGroupList
     */
    public com.tvnavig.server.user.service.common.UserGroupResult[] getUserGroupList() {
        return userGroupList;
    }


    /**
     * Sets the userGroupList value for this UserGroupandMetaDataResult.
     * 
     * @param userGroupList
     */
    public void setUserGroupList(com.tvnavig.server.user.service.common.UserGroupResult[] userGroupList) {
        this.userGroupList = userGroupList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserGroupandMetaDataResult)) return false;
        UserGroupandMetaDataResult other = (UserGroupandMetaDataResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metaDataList==null && other.getMetaDataList()==null) || 
             (this.metaDataList!=null &&
              java.util.Arrays.equals(this.metaDataList, other.getMetaDataList()))) &&
            ((this.userGroupList==null && other.getUserGroupList()==null) || 
             (this.userGroupList!=null &&
              java.util.Arrays.equals(this.userGroupList, other.getUserGroupList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMetaDataList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMetaDataList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMetaDataList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUserGroupList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserGroupList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUserGroupList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserGroupandMetaDataResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://common.service.user.server.tvnavig.com", "UserGroupandMetaDataResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaDataList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaDataList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.service.user.server.tvnavig.com", "MetaDataResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.service.user.server.tvnavig.com", "UserGroupResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
