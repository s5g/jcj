#ifndef JCJ_H
#define JCJ_H

#include <android/log.h>

#define TAG "JCJ-C"

#define LOGV(fmt, ...) __android_log_print(ANDROID_LOG_VERBOSE, TAG, fmt, ##__VA_ARGS__)
#define LOGD(fmt, ...) __android_log_print(ANDROID_LOG_DEBUG, TAG, fmt, ##__VA_ARGS__)
#define LOGI(fmt, ...) __android_log_print(ANDROID_LOG_INFO, TAG, fmt, ##__VA_ARGS__)
#define LOGW(fmt, ...) __android_log_print(ANDROID_LOG_WARNING, TAG, fmt, ##__VA_ARGS__)
#define LOGE(fmt, ...) __android_log_print(ANDROID_LOG_ERROR, TAG, fmt, ##__VA_ARGS__)

extern float add(float a, float b);

#endif // JCJ_H
