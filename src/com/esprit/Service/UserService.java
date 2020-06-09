/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.esprit.Entities.User;
import com.esprit.myapp.Session;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author HP
 */
public class UserService {

    User user = new User();

    public void login(String username, String password) {
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/pi/web/app_dev.php/mobile/login?username=" + username + "&password=" + password;
        con.setUrl(url);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            if (!response.trim().contains("NOPE")) {
                try {
                    JSONParser j = new JSONParser();
                    Map<String, Object> userLog = j.parseJSON(new CharArrayReader(response.toCharArray()));
                    user.setId(Float.valueOf(userLog.get("id").toString()).intValue());
                    user.setUsername(userLog.get("username").toString());
                    user.setEmail(userLog.get("email").toString());
                    Session.setUser(user);
                    Session.setCnx(true);
                } catch (IOException ex) {
                }
            } else {
                Dialog.show("Conf", "invalid credentials", "ok", null);
                Session.setCnx(false);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void Register(String username, String email, String password) {
        ConnectionRequest con = new ConnectionRequest();

        String url = "http://localhost:8080/pi/web/app_dev.php/users/new?username=" + username + "&email=" + email + "&password=" + password;
        System.out.println(url);
        con.setUrl(url);
        NetworkManager.getInstance().addToQueueAndWait(con);

        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);

        });
    }

    public void update(String username, String email, String password) {
        ConnectionRequest con = new ConnectionRequest();

        String url = "http://localhost:8080/pi/web/app_dev.php/users/update?username=" + username + "&email=" + email + "&password=" + password;
        con.setUrl(url);
        NetworkManager.getInstance().addToQueueAndWait(con);

        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);

        });
    }

    public void bloque(String username) {
        ConnectionRequest con = new ConnectionRequest();

        String url = "http://localhost:8080/pi/web/app_dev.php/users/bloque?username=" + username;
        con.setUrl(url);
        NetworkManager.getInstance().addToQueueAndWait(con);

        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);

        });
    }
}
