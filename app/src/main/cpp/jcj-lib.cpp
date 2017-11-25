#include <jni.h>

extern "C"

JNIEXPORT jfloat JNICALL
Java_com_example_jcj_MainActivity_add(JNIEnv *env, jobject /* this */ obj, jfloat a, jfloat b)
{
    return a + b;
}
