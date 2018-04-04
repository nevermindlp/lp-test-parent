#include <jni.h>
#include "lp_jni_hello_HelloJNI.h"
#include <stdio.h>

JNIEXPORT jstring JNICALL Java_lp_jni_hello_HelloJNI_hello(JNIEnv *env, jobject obj, jstring s1) {
    jstring s2  = (*env)->NewStringUTF(env, "hello ");

    jbyte *s1x  = (*env)->GetStringUTFChars(env, s1, NULL);
    jbyte *s2x  = (*env)->GetStringUTFChars(env, s2, NULL);

    char *sall  = malloc(strlen(s1x) + strlen(s2x) + 1);
    strcpy(sall, s1x);
    strcat(sall, s2x);

    jstring retval = (*env)->NewStringUTF(env, sall);

    (*env)->ReleaseStringUTFChars(env, s1, s1x);
    (*env)->ReleaseStringUTFChars(env, s2, s2x);
    free(sall);
    return retval;
}

JNIEXPORT void JNICALL Java_lp_jni_hello_HelloJNI_print(JNIEnv *env, jobject obj){
    printf("jni say hello");
    return;
}