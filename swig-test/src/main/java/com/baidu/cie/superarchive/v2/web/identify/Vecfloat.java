/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.1.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.baidu.cie.superarchive.v2.web.identify;

public class Vecfloat extends java.util.AbstractList<Float> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Vecfloat(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Vecfloat obj) {
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
        SearchDocModuleJNI.delete_Vecfloat(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Vecfloat(float[] initialElements) {
    this();
    reserve(initialElements.length);

    for (float element : initialElements) {
      add(element);
    }
  }

  public Vecfloat(Iterable<Float> initialElements) {
    this();
    for (float element : initialElements) {
      add(element);
    }
  }

  public Float get(int index) {
    return doGet(index);
  }

  public Float set(int index, Float e) {
    return doSet(index, e);
  }

  public boolean add(Float e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, Float e) {
    modCount++;
    doAdd(index, e);
  }

  public Float remove(int index) {
    modCount++;
    return doRemove(index);
  }

  protected void removeRange(int fromIndex, int toIndex) {
    modCount++;
    doRemoveRange(fromIndex, toIndex);
  }

  public int size() {
    return doSize();
  }

  public Vecfloat() {
    this(SearchDocModuleJNI.new_Vecfloat__SWIG_0(), true);
  }

  public Vecfloat(Vecfloat other) {
    this(SearchDocModuleJNI.new_Vecfloat__SWIG_1(Vecfloat.getCPtr(other), other), true);
  }

  public long capacity() {
    return SearchDocModuleJNI.Vecfloat_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    SearchDocModuleJNI.Vecfloat_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return SearchDocModuleJNI.Vecfloat_isEmpty(swigCPtr, this);
  }

  public void clear() {
    SearchDocModuleJNI.Vecfloat_clear(swigCPtr, this);
  }

  public Vecfloat(int count, float value) {
    this(SearchDocModuleJNI.new_Vecfloat__SWIG_2(count, value), true);
  }

  private int doSize() {
    return SearchDocModuleJNI.Vecfloat_doSize(swigCPtr, this);
  }

  private void doAdd(float x) {
    SearchDocModuleJNI.Vecfloat_doAdd__SWIG_0(swigCPtr, this, x);
  }

  private void doAdd(int index, float x) {
    SearchDocModuleJNI.Vecfloat_doAdd__SWIG_1(swigCPtr, this, index, x);
  }

  private float doRemove(int index) {
    return SearchDocModuleJNI.Vecfloat_doRemove(swigCPtr, this, index);
  }

  private float doGet(int index) {
    return SearchDocModuleJNI.Vecfloat_doGet(swigCPtr, this, index);
  }

  private float doSet(int index, float val) {
    return SearchDocModuleJNI.Vecfloat_doSet(swigCPtr, this, index, val);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    SearchDocModuleJNI.Vecfloat_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
