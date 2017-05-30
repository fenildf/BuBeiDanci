#2017.5.29
思路:
4.
只有ScrollView不能滑动.
onTouchEvent(){
    //mDetector.onTouchEvent(ev);
    return true;
}

3. 
第一页不能上下滑动
ScrollView不能上下滑动
dispatchTouchEvent(MotionEvent ev) {
        mDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
}
2. 都不能滑动了.
onTouchEvent(){
    mDetector.onTouchEvent(ev);
    return super.onTouchEvent(ev);
    //return true;
     }
1. onTouchEvent(){
    mDetector.onTouchEvent(ev);
    return true;
}
scrollview是可以上下滑动的, 但第二页不能整页滑动.


日志:
2. 解决上下滑动不灵敏的问题, (dispatch..Event)和(onTouchEvent)都调用了mGuestureDector
1.将ScrollBy直接应用到onTouchEvent,不进行其他处理