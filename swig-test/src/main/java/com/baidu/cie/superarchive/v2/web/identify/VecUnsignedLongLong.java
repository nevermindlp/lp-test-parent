/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.1.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.baidu.cie.superarchive.v2.web.identify;

public class VecUnsignedLongLong extends java.util.AbstractList<java.math.BigInteger> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected VecUnsignedLongLong(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(VecUnsignedLongLong obj) {
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
        SearchDocModuleJNI.delete_VecUnsignedLongLong(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public VecUnsignedLongLong(java.math.BigInteger[] initialElements) {
    this();
    reserve(initialElements.length);

    for (java.math.BigInteger element : initialElements) {
      add(element);
    }
  }

  public VecUnsignedLongLong(Iterable<java.math.BigInteger> initialElements) {
    this();
    for (java.math.BigInteger element : initialElements) {
      add(element);
    }
  }

  public java.math.BigInteger get(int index) {
    return doGet(index);
  }

  public java.math.BigInteger set(int index, java.math.BigInteger e) {
    return doSet(index, e);
  }

  public boolean add(java.math.BigInteger e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, java.math.BigInteger e) {
    modCount++;
    doAdd(index, e);
  }

  public java.math.BigInteger remove(int index) {
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

  public VecUnsignedLongLong() {
    this(SearchDocModuleJNI.new_VecUnsignedLongLong__SWIG_0(), true);
  }

  public VecUnsignedLongLong(VecUnsignedLongLong other) {
    this(SearchDocModuleJNI.new_VecUnsignedLongLong__SWIG_1(VecUnsignedLongLong.getCPtr(other), other), true);
  }

  public long capacity() {
    return SearchDocModuleJNI.VecUnsignedLongLong_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    SearchDocModuleJNI.VecUnsignedLongLong_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return SearchDocModuleJNI.VecUnsignedLongLong_isEmpty(swigCPtr, this);
  }

  public void clear() {
    SearchDocModuleJNI.VecUnsignedLongLong_clear(swigCPtr, this);
  }

  public VecUnsignedLongLong(int count, java.math.BigInteger value) {
    this(SearchDocModuleJNI.new_VecUnsignedLongLong__SWIG_2(count, value), true);
  }

  private int doSize() {
    return SearchDocModuleJNI.VecUnsignedLongLong_doSize(swigCPtr, this);
  }

  private void doAdd(java.math.BigInteger x) {
    SearchDocModuleJNI.VecUnsignedLongLong_doAdd__SWIG_0(swigCPtr, this, x);
  }

  private void doAdd(int index, java.math.BigInteger x) {
    SearchDocModuleJNI.VecUnsignedLongLong_doAdd__SWIG_1(swigCPtr, this, index, x);
  }

  private java.math.BigInteger doRemove(int index) {
    return SearchDocModuleJNI.VecUnsignedLongLong_doRemove(swigCPtr, this, index);
  }

  private java.math.BigInteger doGet(int index) {
    return SearchDocModuleJNI.VecUnsignedLongLong_doGet(swigCPtr, this, index);
  }

  private java.math.BigInteger doSet(int index, java.math.BigInteger val) {
    return SearchDocModuleJNI.VecUnsignedLongLong_doSet(swigCPtr, this, index, val);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    SearchDocModuleJNI.VecUnsignedLongLong_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}