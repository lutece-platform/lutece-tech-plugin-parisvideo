/**
 * AssetPlayer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tvnavig.server.searchengine.service.common;

public class AssetPlayer  implements java.io.Serializable {
    private java.lang.String htmlEmbed;

    private java.lang.String thumbnail;

    public AssetPlayer() {
    }

    public AssetPlayer(
           java.lang.String htmlEmbed,
           java.lang.String thumbnail) {
           this.htmlEmbed = htmlEmbed;
           this.thumbnail = thumbnail;
    }


    /**
     * Gets the htmlEmbed value for this AssetPlayer.
     * 
     * @return htmlEmbed
     */
    public java.lang.String getHtmlEmbed() {
        return htmlEmbed;
    }


    /**
     * Sets the htmlEmbed value for this AssetPlayer.
     * 
     * @param htmlEmbed
     */
    public void setHtmlEmbed(java.lang.String htmlEmbed) {
        this.htmlEmbed = htmlEmbed;
    }


    /**
     * Gets the thumbnail value for this AssetPlayer.
     * 
     * @return thumbnail
     */
    public java.lang.String getThumbnail() {
        return thumbnail;
    }


    /**
     * Sets the thumbnail value for this AssetPlayer.
     * 
     * @param thumbnail
     */
    public void setThumbnail(java.lang.String thumbnail) {
        this.thumbnail = thumbnail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AssetPlayer)) return false;
        AssetPlayer other = (AssetPlayer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.htmlEmbed==null && other.getHtmlEmbed()==null) || 
             (this.htmlEmbed!=null &&
              this.htmlEmbed.equals(other.getHtmlEmbed()))) &&
            ((this.thumbnail==null && other.getThumbnail()==null) || 
             (this.thumbnail!=null &&
              this.thumbnail.equals(other.getThumbnail())));
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
        if (getHtmlEmbed() != null) {
            _hashCode += getHtmlEmbed().hashCode();
        }
        if (getThumbnail() != null) {
            _hashCode += getThumbnail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AssetPlayer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://common.service.searchengine.server.tvnavig.com", "AssetPlayer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("htmlEmbed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "htmlEmbed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("thumbnail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "thumbnail"));
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
