package com.nix;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilderRss extends RouteBuilder {

    public void configure() {

        String rssUrl = "http://k.img.com.ua/rss/ru/all_news2.0.xml";

        from("rss:" + rssUrl)
                .marshal().rss()
                .process(ex -> {
                    Message in = ex.getIn();

                })
//                .setBody(xpath("/rss/channel/item/title", String.class))
                .to("log:com.rout");
    }


    public static class MyMsg {
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}


