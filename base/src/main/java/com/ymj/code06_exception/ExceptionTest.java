package com.ymj.code06_exception;

/**
 * @Classname ExceptionTest
 * @Description TODO
 * @Date 2021/6/18 19:51
 * @Created by yemingjie
 */
public class ExceptionTest {
    public void tryFinally() {
        try {
            tryItOut();
        } finally {
            wrapItUp();
        }
    }

    // auxiliary methods
    public void tryItOut() { }

    public void wrapItUp() {}
}
