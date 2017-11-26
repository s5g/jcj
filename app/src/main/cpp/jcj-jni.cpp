#include <jni.h>
#include "jcj.h"

extern "C"

JNIEXPORT jfloat JNICALL
Java_com_example_jcj_MainActivity_add(JNIEnv *env, jobject /* this */ obj, jfloat a, jfloat b)
{
    return add(a, b);
}
