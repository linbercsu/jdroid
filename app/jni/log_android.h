/*
 * log.h
 *
 *  Created on: 2014-10-16
 *      Author: lin
 */

#ifndef LOG_H_
#define LOG_H_

#include <android/log.h>

#define  LOG(pri, tag, ...)  __android_log_print(pri,(tag),__VA_ARGS__)

#define  LOGv(tag, ...) LOG(ANDROID_LOG_VERBOSE, (tag), __VA_ARGS__);
#define  LOGd(tag, ...) LOG(ANDROID_LOG_DEBUG, (tag), __VA_ARGS__);
#define  LOGi(tag, ...) __android_log_print(ANDROID_LOG_INFO,(tag),__FILE__);LOG(ANDROID_LOG_INFO, (tag), __VA_ARGS__);
#define  LOGw(tag, ...) LOG(ANDROID_LOG_WARN, (tag), __VA_ARGS__);
#define  LOGe(tag, ...) LOG(ANDROID_LOG_ERROR, (tag), __VA_ARGS__);
#define  LOGa(tag, ...) LOG(ANDROID_LOG_FATAL, (tag), __VA_ARGS__);



#endif /* LOG_H_ */
