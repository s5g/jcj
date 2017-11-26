#include "jcj.h"

float add(float a, float b) {
    __android_log_print(ANDROID_LOG_VERBOSE, TAG, "%f + %f = %f", a, b, a + b);
    return a + b;
}
