package com.kh.myweather0812;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WeatherActivity extends AppCompatActivity {
    TextView weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        setTitle("날씨 정보");

        weatherInfo = (TextView) findViewById(R.id.weatherInfo);
        Button weatherStart = (Button) findViewById(R.id.startWeather);
        weatherStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXmlTask task = new GetXmlTask();
                task.execute("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=89&gridy=90");
            }
        });
    }

    private class GetXmlTask extends AsyncTask<String, Void, Document> {
        Document doc = null;

        //작업쓰레드 영역
        @Override
        protected Document doInBackground(String... strings) {
            URL url;
            try {
                url = new URL(strings[0]);
                DocumentBuilderFactory dbf =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Log.d("GetXmlTask", "xml 에러: " + e.getMessage());
            }
            return doc;
        }

        //작업쓰레드 종료 후 처리
        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            String s = "";
            NodeList nodeList = doc.getElementsByTagName("data");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;

                NodeList hourList = fstElmnt.getElementsByTagName("hour");
                Element hourElement = (Element) hourList.item(0);
                hourList = hourElement.getChildNodes();
                s += hourList.item(0).getNodeValue() + "시  날씨 정보: ";

                NodeList tempList = fstElmnt.getElementsByTagName("temp");
                Element nameElement = (Element) tempList.item(0);
                tempList = nameElement.getChildNodes();
                s += "온도 = " + tempList.item(0).getNodeValue() + " ,";

                NodeList weatherList = fstElmnt.getElementsByTagName("wfKor");
                Element weatherElement = (Element) weatherList.item(0);
                weatherList = weatherElement.getChildNodes();
                s += "날씨 = " + weatherList.item(0).getNodeValue() + "\n";
            }
            weatherInfo.setText(s);
        }
    }
}