package com.qingmei2.sample_androidtest.m_mvp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * Created by QingMei on 2017/6/27.
 * desc:
 */

public class AssestsReader {

    public static String readFile(String path) {
        File file = new File(path);
        String content = file2String(file,"UTF-8");
        return content;
    }

    /**
     * 文件转换为字符串
     *
     * @param f             文件
     * @param charset 文件的字符集
     * @return 文件内容
     */
    public static String file2String(File f, String charset) {
        String result = null;
        try {
            result = stream2String(new FileInputStream(f), charset);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 文件转换为字符串
     *
     * @param in            字节流
     * @param charset 文件的字符集
     * @return 文件内容
     */
    public static String stream2String(InputStream in, String charset) {
        StringBuffer sb = new StringBuffer();
        try {
            Reader r = new InputStreamReader(in, charset);
            int length = 0;
            for (char[] c = new char[1024]; (length = r.read(c)) != -1;) {
                sb.append(c, 0, length);
            }
            r.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
