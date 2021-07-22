package com.example.demo.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 10450
 * @description Xss攻击过滤器
 * @date 2021/7/21 16:35
 */
/**
 * HtmlFilter
 *
 * @author 撸小鱼
 * Created by lofish@foxmail.com on 2020-04-12
 */
/**
 * XssFilter
 *
 * @author 撸小鱼
 * Created by lofish@foxmail.com on 2020-04-12
 */
public class XssFilter implements Filter {

    /**
     * 例外urls
     */
    private List<String> excludeUrls = new ArrayList<>();

    /**
     * 例外标签
     */
    private List<String> excludeTags = new ArrayList<>();

    /**
     * 需要过滤标签
     */
    private List<String> includeTags = new ArrayList<>();

    /**
     * 开关
     */
    public boolean enabled = false;

    /**
     * 编码
     */
    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String enabledStr = filterConfig.getInitParameter("enabled");
        String excludeUrlStr = filterConfig.getInitParameter("urlPatterns");
        String excludeTagStr = filterConfig.getInitParameter("excludes");
        String includeTagStr = filterConfig.getInitParameter("includes");
        String encodingStr = filterConfig.getInitParameter("encoding");

        if (StringUtils.isNotEmpty(excludeUrlStr)) {
            String[] url = excludeUrlStr.split(",");
            Collections.addAll(this.excludeUrls, url);
        }

        if (StringUtils.isNotEmpty(excludeTagStr)) {
            String[] url = excludeTagStr.split(",");
            Collections.addAll(this.excludeTags, url);
        }

        if (StringUtils.isNotEmpty(includeTagStr)) {
            String[] url = includeTagStr.split(",");
            Collections.addAll(this.includeTags, url);
        }

        if (StringUtils.isNotEmpty(enabledStr)) {
            this.enabled = Boolean.parseBoolean(enabledStr);
        }

        if (StringUtils.isNotEmpty(encodingStr)) {
            this.encoding = encodingStr;
        }

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (handleExcludeUrls(req, resp)) {
            chain.doFilter(request, response);
            return;
        }

        try{
            XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request, encoding, excludeTags, includeTags );
//            this.printParam(xssRequest);
            chain.doFilter(xssRequest, response);
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }

    private void printParam(HttpServletRequest request){
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(stringBuilder.toString()+"-----------------");
    }

    private boolean handleExcludeUrls(HttpServletRequest request, HttpServletResponse response) {
        if (!enabled) {
            return true;
        }
        if (excludeUrls == null || excludeUrls.isEmpty()) {
            return false;
        }
        String url = request.getServletPath();
        for (String pattern : excludeUrls) {
            Pattern p = Pattern.compile("^" + pattern);
            Matcher m = p.matcher(url);
            if (m.find()) {
                return true;
            }
        }
        return false;
    }
}
