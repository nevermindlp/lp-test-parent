package lp.cachefeign;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Base64Utils;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

/**
 * HttpClient Utilities
 *
 * @author wangsan
 */
public final class HttpClientUtils {

    public static final RequestConfig DEFAULT_REQ_CONFIG = RequestConfig.custom().setSocketTimeout(10)
            .setConnectTimeout(2).setConnectionRequestTimeout(2).build();

    private static PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();

    static {
        manager.setDefaultSocketConfig(SocketConfig.custom().setTcpNoDelay(true).build());
        manager.setMaxTotal(600); // 全并发
        manager.setDefaultMaxPerRoute(200); // 单个主机/域名的并发上限
    }

    public static Set<BasicHeader> connectionCloseHeader =
            ImmutableSet.of(new BasicHeader("Connection", "close"));

    private HttpClientUtils() {

    }

    /**
     * 把BasicNameValuePair连接为k1=v1&k2=v2&k3=v3的格式
     *
     * @param kvs 参数
     * @return string k1=v1&k2=v2&k3=v3
     */
    public static String joinParams(final Collection<BasicNameValuePair> kvs) {
        return Joiner.on("&").join(kvs);
    }

    /**
     * 构建一个url，会把第二个参数的BasicNameValuePair连接为k1=v1&k2=v2&k3=v3的格式 如果baseUri中存在‘?’符号，则使用‘&’连接baseUri和参数，否则使用‘?’
     *
     * @param baseUri url主体
     * @param kvs     参数
     * @return url string
     */
    public static String buildUrl(final String baseUri, final Collection<BasicNameValuePair> kvs) {
        Preconditions.checkArgument(StringUtils.isNotBlank(baseUri));

        if (CollectionUtils.isEmpty(kvs)) {
            return baseUri;
        }

        StringBuilder result = new StringBuilder();
        result.append(baseUri);
        if (baseUri.indexOf("?") > 0) {
            result.append('&');
        } else {
            result.append('?');
        }

        return Joiner.on("&").appendTo(result, kvs).toString();
    }

    /**
     * 使用content创建一个UTF-8格式的StringEntity
     *
     * @param content String content
     * @return UTF8 StringEntity instance
     */
    public static StringEntity newJsonStringEntity(String content) {
        return new StringEntity(content, ContentType.create("application/json", Charsets.UTF_8));
    }

    /**
     * 使用者应尽量调用一次，重复使用 CloseableHttpClient 实例
     *
     * @return CloseableHttpClient instance
     */
    public static CloseableHttpClient newHttpClient() {

        return HttpClientBuilder.create().setDefaultRequestConfig(DEFAULT_REQ_CONFIG)
                .setDefaultHeaders(connectionCloseHeader).setConnectionManager(manager).build();

    }

    public static CloseableHttpClient newHttpClient(SSLConnectionSocketFactory sslsf) {

        return HttpClientBuilder.create().setDefaultRequestConfig(DEFAULT_REQ_CONFIG)
                .setDefaultHeaders(connectionCloseHeader).setConnectionManager(manager).setSSLSocketFactory(sslsf)
                .build();

    }

    public static String executePost(CloseableHttpClient httpClient, HttpPost post) throws IOException {
        String content = null;
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post);
            content = EntityUtils.toString(response.getEntity());
        } finally {
            if (response != null) {
                response.close();
            }
        }

        return content;
    }

    public static String executeGet(CloseableHttpClient httpClient, HttpGet get) throws IOException {
        String content = null;
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            content = EntityUtils.toString(response.getEntity());
        } finally {
            if (response != null) {
                response.close();
            }
        }

        return content;
    }

    public static byte[] executeGetImage(CloseableHttpClient httpClient, HttpGet get) throws IOException {
        byte[] content = null;
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                content = EntityUtils.toByteArray(response.getEntity());
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return content;
    }

    public static String getImageBase64(CloseableHttpClient httpClient, HttpGet get) throws IOException {
        String baseStr = StringUtils.EMPTY;
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                // 文件流
                HttpEntity httpEntity = response.getEntity();
                InputStream inStream = httpEntity.getContent();
                byte[] bytes = IOUtils.toByteArray(inStream);

                if (bytes != null) {
                    baseStr = Base64Utils.encodeToString(bytes);
                }
                return baseStr;

            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return baseStr;
    }


}
