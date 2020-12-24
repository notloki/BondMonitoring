package com.notloki.bondMonitoring;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.notloki.bondMonitoring.HttpClient;
import com.notloki.bondMonitoring.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static com.notloki.bondMonitoring.Ref.IVR_CODE;
import static com.notloki.bondMonitoring.Ref.LANG;
import static com.notloki.bondMonitoring.Ref.LAST_NAME;
import static com.notloki.bondMonitoring.Ref.PHONE;
import static com.notloki.bondMonitoring.Ref.URL;

public class HttpReq {  private static String  last = LAST_NAME.replaceAll(" ", "+");
    private static final String MY_URL = URL;
    private static final String JSON_PAYLOAD = new StringBuilder().append(last)
            .append("&").append(PHONE)
            .append("&").append(IVR_CODE)
            .append("&").append(LANG).toString();

    HttpClient httpClient = new HttpClient();
    String response = httpClient.post(MY_URL, JSON_PAYLOAD);
    JSONObject json = new JSONObject(response);


    public HttpReq() throws IOException, JSONException {

    }
}
