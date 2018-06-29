package com.starlightfinancial.springsecuritydemocsdn.globalconfig;

import org.hibernate.dialect.MySQL55Dialect;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/26 10:48
 * @Modified By:
 */
public class MySQL55DialectUtf8 extends MySQL55Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
