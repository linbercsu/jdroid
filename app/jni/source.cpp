/*
 * source.cpp
 *
 *  Created on: 2014-10-15
 *      Author: lin
 */

#include "com_example_lin_jdroid_MyActivity.h"
#include "log_android.h"

#define  LOG_TAG    "HelloJni"

jstring Java_com_example_lin_jdroid_MyActivity_getStringFromJni
  (JNIEnv * env, jobject){

	LOGi(LOG_TAG, "IT IS IN C.");
//	 __android_log_print(ANDROID_LOG_INFO, __FILE__, "Your params is null");
	return env->NewStringUTF("this is a sample.");

}

