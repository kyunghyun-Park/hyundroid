package com.mk.myweather.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mk.myweather.R;
import com.mk.myweather.activity.MainActivity;
import com.mk.myweather.util.GetXmlTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WeatherFragment extends Fragment {
    TextView kangwon;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment_weather,
                        container, false);

        // fragment layout 연결
        kangwon = rootView.findViewById(R.id.kangwon);
        kangwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("hack4ork", "강원도 클릭");
                GetXmlTask task =
                        new GetXmlTask((MainActivity) getActivity());
                task.execute(
                        "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=73&gridy=134");
            }
        });

        return rootView;
    }

    private class GetXmlTaskFrag extends AsyncTask<String, Void, Document> {
        Document doc = null;

        // 작업쓰레드 영역
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
            }
            catch (Exception e) {
                Log.d("GetXmlTask","xml에러: " + e.getMessage());
            }
            return doc;
        }

        // 작업쓰레드 종료후 처리 (UI 쓰레드)
        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            String s = "";
            NodeList nodeList = doc.getElementsByTagName("data");

            for (int i=0; i<nodeList.getLength(); i++) {
                s += "" + i + ": 날씨 정보: ";
                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;

                NodeList tempList = fstElmnt.getElementsByTagName("temp");
                Element nameElement = (Element) tempList.item(0);
                tempList = nameElement.getChildNodes();
                s += "온도 = " + tempList.item(0).getNodeValue() + " ,";

                NodeList weatherList = fstElmnt.getElementsByTagName("wfKor");
                Element weatherElement = (Element) weatherList.item(0);
                weatherList = weatherElement.getChildNodes();
                s += "날씨 = " + weatherList.item(0).getNodeValue() + "\n";
            }
            //showWeather.setText(s);
        }
    }
}