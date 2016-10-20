package com.java8.example;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by liuguo on 2016/9/1.
 */
public class Base64Example {

    public static void main(String[] args) {

        final String text = "Base64 finally in java8";
        final String encoded = Base64
                .getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println("encoded = [" + encoded + "]"); //encoded = [QmFzZTY0IGZpbmFsbHkgaW4gamF2YTg=]

        final String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        System.out.println("decoded = [" + decoded + "]"); //decoded = [Base64 finally in java8]
    }
}
