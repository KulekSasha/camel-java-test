package com.nix;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopier {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder(context) {
            @Override
            public void configure() throws Exception {
//                from(new FileEndpoint("target/news", new FileComponent(getContext())))
                from("file:target/news?delete=true")
                        .to("file:target/newsCopy");
            }
        });

        context.start();
        Thread.sleep(5_000L);
        context.stop();

    }
}
