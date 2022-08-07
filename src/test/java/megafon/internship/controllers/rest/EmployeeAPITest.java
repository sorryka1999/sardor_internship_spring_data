package megafon.internship.controllers.rest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EmployeeAPITest {

    @BeforeAll
    static void loggingInToTakeJsonWebToken() throws IOException {
        HttpPost httpPost = new HttpPost( "http://localhost:8080/api/login" );

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("username", "sardor.manager@megafon.ru"));
        params.add(new BasicNameValuePair("password", "SSss1112"));
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        String forEncoding = "sardor.manager@megafon.ru:SSss1112";
        String encoded = Base64.getEncoder().encodeToString(forEncoding.getBytes());
        httpPost.setHeader("Authorization", "Basic " + encoded);

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(httpPost);
        String jsonWebToken = Arrays
                .stream(response.getHeaders("x-csrf-token"))
                .findFirst().get().getValue();

        File file = new File("JwtForEmployeeAPITest.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter("JwtForEmployeeAPITest.txt");
        fileWriter.write(jsonWebToken);
        fileWriter.close();
    }

    @Test
    public void testGetUser() throws Exception {

        File file = new File("JwtForEmployeeAPITest.txt");
        Scanner reader = new Scanner(file);
        String jsonWebToken = "";
        while (reader.hasNextLine()) {
            jsonWebToken = reader.nextLine();
        }
        reader.close();

        HttpGet httpGet = new HttpGet( "http://localhost:8080/api/employees" );
        httpGet.setHeader("X-CSRF-TOKEN", jsonWebToken);

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(httpGet);
        Assertions.assertEquals(response.getStatusLine().getStatusCode(), 200);

        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        Assertions.assertEquals("application/json", mimeType);
    }

    @AfterAll
    static void deleteJwtFile() {
        File file = new File("JwtForEmployeeAPITest.txt");
        file.delete();
    }
}
