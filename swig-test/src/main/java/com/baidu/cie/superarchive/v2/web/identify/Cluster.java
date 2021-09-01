/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.1.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.baidu.cie.superarchive.v2.web.identify;

public class Cluster {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Cluster(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Cluster obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        SearchDocModuleJNI.delete_Cluster(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setCluster_id(long value) {
    SearchDocModuleJNI.Cluster_cluster_id_set(swigCPtr, this, value);
  }

  public long getCluster_id() {
    return SearchDocModuleJNI.Cluster_cluster_id_get(swigCPtr, this);
  }

  public void setCluster_feature(Vecfloat value) {
    SearchDocModuleJNI.Cluster_cluster_feature_set(swigCPtr, this, Vecfloat.getCPtr(value), value);
  }

  public Vecfloat getCluster_feature() {
    long cPtr = SearchDocModuleJNI.Cluster_cluster_feature_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Vecfloat(cPtr, false);
  }

  public void setPic_list(VecUnsignedLongLong value) {
    SearchDocModuleJNI.Cluster_pic_list_set(swigCPtr, this, VecUnsignedLongLong.getCPtr(value), value);
  }

  public VecUnsignedLongLong getPic_list() {
    long cPtr = SearchDocModuleJNI.Cluster_pic_list_get(swigCPtr, this);
    return (cPtr == 0) ? null : new VecUnsignedLongLong(cPtr, false);
  }

  public void setCluster_title_id(java.math.BigInteger value) {
    SearchDocModuleJNI.Cluster_cluster_title_id_set(swigCPtr, this, value);
  }

  public java.math.BigInteger getCluster_title_id() {
    return SearchDocModuleJNI.Cluster_cluster_title_id_get(swigCPtr, this);
  }

  public void setDoc_id(long value) {
    SearchDocModuleJNI.Cluster_doc_id_set(swigCPtr, this, value);
  }

  public long getDoc_id() {
    return SearchDocModuleJNI.Cluster_doc_id_get(swigCPtr, this);
  }

  public Cluster() {
    this(SearchDocModuleJNI.new_Cluster(), true);
  }

}