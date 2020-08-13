package com.kh.myweather0812.fregment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kh.myweather0812.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BusanFregment extends Fragment {
    Button weatherStart2;
    TextView weatherInfo2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.busan_fregment, container, false);
        // fregment layout 연결
        weatherStart2 = rootView.findViewById(R.id.startWeather2);
        weatherInfo2 = rootView.findViewById(R.id.weatherInfo2);
        weatherStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXmlTaskFreg task = new GetXmlTaskFreg();
                task.execute("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=60&gridy=127");
            }
        });

        return rootView;

    }
    private class GetXmlTaskFreg extends AsyncTask<String, Void, Document> {
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
            weatherInfo2.setText(s);
        }
    }
}