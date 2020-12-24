package com.notloki.bondMonitoring;

import java.io.IOException;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;

public interface HttpClientInterface {
public abstract String post(String url, String json) throws IOException;
}
