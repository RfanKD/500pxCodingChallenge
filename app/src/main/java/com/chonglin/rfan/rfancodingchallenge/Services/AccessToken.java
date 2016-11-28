package com.chonglin.rfan.rfancodingchallenge.Services;

/**
 * Created by Rfan on 27/11/2016.
 */

public class AccessToken {

    private String accessToken;
    private String tokenType;

    public String getAccessToken(){
        return accessToken;
    }

    public String getTokenType (){
        // OAuth requires uppercase Authorization Http header value or token

        if (! Character.isUpperCase(tokenType.charAt(0))){
            tokenType =
                    Character
                            .toString(tokenType.charAt(0))
                            .toUpperCase().substring(1);
        }

        return tokenType;

    }


}
