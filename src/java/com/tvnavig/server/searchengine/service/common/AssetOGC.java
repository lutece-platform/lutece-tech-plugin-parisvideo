/**
 * AssetOGC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tvnavig.server.searchengine.service.common;

import java.io.Serializable;

public class AssetOGC  implements Serializable, Comparable<AssetOGC> {

	private static final long serialVersionUID = 1L;

	private int assetId;

    private java.util.Calendar creationDate;

    private java.lang.String description;

    private java.lang.String[] formats;

    private com.tvnavig.server.asset.service.common.MetaValueResult[] metaValues;

    private java.lang.String previewURL;

    private java.lang.String thumbnail;

    private java.lang.String title;

    private java.lang.String videoURL;

    public AssetOGC() {
    }

    public AssetOGC(
           int assetId,
           java.util.Calendar creationDate,
           java.lang.String description,
           java.lang.String[] formats,
           com.tvnavig.server.asset.service.common.MetaValueResult[] metaValues,
           java.lang.String previewURL,
           java.lang.String thumbnail,
           java.lang.String title,
           java.lang.String videoURL) {
           this.assetId = assetId;
           this.creationDate = creationDate;
           this.description = description;
           this.formats = formats;
           this.metaValues = metaValues;
           this.previewURL = previewURL;
           this.thumbnail = thumbnail;
           this.title = title;
           this.videoURL = videoURL;
    }

    /**
     * Gets the assetId value for this AssetOGC.
     * 
     * @return assetId
     */
    public int getAssetId() {
        return assetId;
    }


    /**
     * Sets the assetId value for this AssetOGC.
     * 
     * @param assetId
     */
    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }


    /**
     * Gets the creationDate value for this AssetOGC.
     * 
     * @return creationDate
     */
    public java.util.Calendar getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the creationDate value for this AssetOGC.
     * 
     * @param creationDate
     */
    public void setCreationDate(java.util.Calendar creationDate) {
        this.creationDate = creationDate;
    }


    /**
     * Gets the description value for this AssetOGC.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this AssetOGC.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the formats value for this AssetOGC.
     * 
     * @return formats
     */
    public java.lang.String[] getFormats() {
        return formats;
    }


    /**
     * Sets the formats value for this AssetOGC.
     * 
     * @param formats
     */
    public void setFormats(java.lang.String[] formats) {
        this.formats = formats;
    }


    /**
     * Gets the metaValues value for this AssetOGC.
     * 
     * @return metaValues
     */
    public com.tvnavig.server.asset.service.common.MetaValueResult[] getMetaValues() {
        return metaValues;
    }


    /**
     * Sets the metaValues value for this AssetOGC.
     * 
     * @param metaValues
     */
    public void setMetaValues(com.tvnavig.server.asset.service.common.MetaValueResult[] metaValues) {
        this.metaValues = metaValues;
    }


    /**
     * Gets the previewURL value for this AssetOGC.
     * 
     * @return previewURL
     */
    public java.lang.String getPreviewURL() {
        return previewURL;
    }


    /**
     * Sets the previewURL value for this AssetOGC.
     * 
     * @param previewURL
     */
    public void setPreviewURL(java.lang.String previewURL) {
        this.previewURL = previewURL;
    }


    /**
     * Gets the thumbnail value for this AssetOGC.
     * 
     * @return thumbnail
     */
    public java.lang.String getThumbnail() {
        return thumbnail;
    }


    /**
     * Sets the thumbnail value for this AssetOGC.
     * 
     * @param thumbnail
     */
    public void setThumbnail(java.lang.String thumbnail) {
        this.thumbnail = thumbnail;
    }


    /**
     * Gets the title value for this AssetOGC.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this AssetOGC.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the videoURL value for this AssetOGC.
     * 
     * @return videoURL
     */
    public java.lang.String getVideoURL() {
        return videoURL;
    }


    /**
     * Sets the videoURL value for this AssetOGC.
     * 
     * @param videoURL
     */
    public void setVideoURL(java.lang.String videoURL) {
        this.videoURL = videoURL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AssetOGC)) return false;
        AssetOGC other = (AssetOGC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.assetId == other.getAssetId() &&
            ((this.creationDate==null && other.getCreationDate()==null) || 
             (this.creationDate!=null &&
              this.creationDate.equals(other.getCreationDate()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.formats==null && other.getFormats()==null) || 
             (this.formats!=null &&
              java.util.Arrays.equals(this.formats, other.getFormats()))) &&
            ((this.metaValues==null && other.getMetaValues()==null) || 
             (this.metaValues!=null &&
              java.util.Arrays.equals(this.metaValues, other.getMetaValues()))) &&
            ((this.previewURL==null && other.getPreviewURL()==null) || 
             (this.previewURL!=null &&
              this.previewURL.equals(other.getPreviewURL()))) &&
            ((this.thumbnail==null && other.getThumbnail()==null) || 
             (this.thumbnail!=null &&
              this.thumbnail.equals(other.getThumbnail()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.videoURL==null && other.getVideoURL()==null) || 
             (this.videoURL!=null &&
              this.videoURL.equals(other.getVideoURL())));
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
        _hashCode += getAssetId();
        if (getCreationDate() != null) {
            _hashCode += getCreationDate().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getFormats() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFormats());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFormats(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMetaValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMetaValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMetaValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPreviewURL() != null) {
            _hashCode += getPreviewURL().hashCode();
        }
        if (getThumbnail() != null) {
            _hashCode += getThumbnail().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getVideoURL() != null) {
            _hashCode += getVideoURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AssetOGC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://common.service.searchengine.server.tvnavig.com", "AssetOGC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assetId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "assetId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formats");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formats"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaValues");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.service.asset.server.tvnavig.com", "MetaValueResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previewURL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previewURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("thumbnail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "thumbnail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("videoURL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "videoURL"));
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

	public int compareTo(AssetOGC assetOgc) 
	{
		return assetOgc.getAssetId() - this.getAssetId();
	}

}
