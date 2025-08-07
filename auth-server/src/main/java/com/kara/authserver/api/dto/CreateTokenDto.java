package com.kara.authserver.api.dto;

public class CreateTokenDto {
    private String userName;
    private String password;
  //  private String grant_type ="password";
  //  private String client_id ="trendly-auth";
   // private String client_secret ="9A4XISA2PlQHrMV7TLbg3EubK8RbuZ2R";
  //  private String scope ="openid";

    public CreateTokenDto() {
    }

    public CreateTokenDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
