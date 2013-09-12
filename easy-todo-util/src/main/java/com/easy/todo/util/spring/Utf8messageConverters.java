package com.easy.todo.util.spring;

import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-9-4
 * Time: 下午4:20
 */
public class Utf8messageConverters extends StringHttpMessageConverter {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private boolean writeAcceptCharset = false;

}
