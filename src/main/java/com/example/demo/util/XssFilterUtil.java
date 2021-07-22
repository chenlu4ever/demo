package com.example.demo.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author 10450
 * @description TODO
 * @date 2021/7/21 16:46
 */
public class XssFilterUtil {

        /**
         * 默认使用relaxed()
         * 允许的标签: a, b, blockquote, br, caption, cite, code, col, colgroup, dd, dl, dt, em, h1, h2, h3, h4, h5, h6, i, img, li, ol, p, pre, q, small, strike, strong, sub, sup, table, tbody, td, tfoot, th, thead, tr, u, ul。结果不包含标签rel=nofollow ，如果需要可以手动添加。
         */
        private Whitelist whiteList;


        /**
         * 配置过滤化参数,不对代码进行格式化
         */
        private Document.OutputSettings outputSettings;


        private XssFilterUtil() {
        }

        /**
         * 静态创建HtmlFilter方法
         * @param whiteList 白名单标签
         * @param pretty 是否格式化
         * @return HtmlFilter
         */
        public static XssFilterUtil create(Whitelist whiteList, boolean pretty) {
            XssFilterUtil filter = new XssFilterUtil();
            if (whiteList == null) {
                filter.whiteList = Whitelist.relaxed();
            }
            filter.outputSettings = new Document.OutputSettings().prettyPrint(pretty);
            return filter;
        }

        /**
         * 静态创建HtmlFilter方法
         * @return HtmlFilter
         */
        public static XssFilterUtil create() {
            return create(null, false);
        }

        /**
         * 静态创建HtmlFilter方法
         * @param whiteList 白名单标签
         * @return HtmlFilter
         */
        public static XssFilterUtil create(Whitelist whiteList) {
            return create(whiteList, false);
        }

        /**
         * 静态创建HtmlFilter方法
         * @param excludeTags 例外的特定标签
         * @param includeTags 需要过滤的特定标签
         * @param pretty      是否格式化
         * @return HtmlFilter
         */
        public static XssFilterUtil create(List<String> excludeTags, List<String> includeTags, boolean pretty) {
            XssFilterUtil filter = create(null, pretty);
            //要过滤的标签
            if (includeTags != null && !includeTags.isEmpty()) {
                String[] tags = (String[]) includeTags.toArray(new String[0]);
                filter.whiteList.removeTags(tags);
            }
            //例外标签
            if (excludeTags != null && !excludeTags.isEmpty()) {
                String[] tags = (String[]) excludeTags.toArray(new String[0]);
                filter.whiteList.addTags(tags);
            }
            return filter;
        }


        /**
         * 静态创建HtmlFilter方法
         * @param excludeTags 例外的特定标签
         * @param includeTags 需要过滤的特定标签
         * @return HtmlFilter
         */
        public static XssFilterUtil create(List<String> excludeTags, List<String> includeTags) {
            return create( includeTags, excludeTags, false );
        }

        /**
         * @param content 需要过滤内容
         * @return 过滤后的String
         */
        public String clean(String content) {
            return Jsoup.clean(content, "", this.whiteList, this.outputSettings);

        }

        public static void main(String[] args) throws FileNotFoundException, IOException {
            String text = "{\"userName\":\"<script>alert(3)</script>\",\"password\":\"aaaaa888@\",\"loginId\":\"test20210721\",\"telephone\":\"18622220304\"}";
            System.out.println(XssFilterUtil.create().clean(text));
        }


}
