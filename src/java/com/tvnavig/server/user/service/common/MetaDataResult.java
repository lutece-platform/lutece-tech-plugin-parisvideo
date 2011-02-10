/**
 * MetaDataResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tvnavig.server.user.service.common;

public class MetaDataResult  implements java.io.Serializable {
    private int metadataId;

    private java.lang.String name;

    private int type;

    private java.lang.String[] valueList;

    public MetaDataResult() {
    }

    public MetaDataResult(
           int metadataId,
           java.lang.String name,
           int type,
           java.lang.String[] valueList) {
           this.metadataId = metadataId;
           this.name = name;
           this.type = type;
           this.valueList = valueList;
    }


    /**
     * Gets the metadataId value for this MetaDataResult.
     * 
     * @return metadataId
     */
    public int getMetadataId() {
        return metadataId;
    }


    /**
     * Sets the metadataId value for this MetaDataResult.
     * 
     * @param metadataId
     */
    public void setMetadataId(int metadataId) {
        this.metadataId = metadataId;
    }


    /**
     * Gets the name value for this MetaDataResult.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this MetaDataResult.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the type value for this MetaDataResult.
     * 
     * @return type
     */
    public int getType() {
        return type;
    }


    /**
     * Sets the type value for this MetaDataResult.
     * 
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }


    /**
     * Gets the valueList value for this MetaDataResult.
     * 
     * @return valueList
     */
    public java.lang.String[] getValueList() {
        return valueList;
    }


    /**
     * Sets the valueList value for this MetaDataResult.
     * 
     * @param valueList
     */
    public void setValueList(java.lang.String[] valueList) {
        this.valueList = valueList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MetaDataResult)) return false;
        MetaDataResult other = (MetaDataResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.metadataId == other.getMetadataId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.type == other.getType() &&
            ((this.valueList==null && other.getValueList()==null) || 
             (this.valueList!=null &&
              java.util.Arrays.equals(this.valueList, other.getValueList())));
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
        _hashCode += getMetadataId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getType();
        if (getValueList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValueList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValueList(), i);
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
        new org.apache.axis.description.TypeDesc(MetaDataResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://common.service.user.server.tvnavig.com", "MetaDataResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metadataId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metadataId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valueList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
