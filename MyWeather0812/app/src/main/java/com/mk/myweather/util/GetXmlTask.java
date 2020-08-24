package com.mk.myweather.util;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.mk.myweather.activity.MainActivity;
import com.mk.myweather.activity.WeatherActivity;
import com.mk.myweather.activity.WeatherView;
import com.mk.myweather.model.MyWeather;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class GetXmlTask extends AsyncTask<String, Void, Document> {
    Document doc = null;
    ArrayList<MyWeather> weatherArrList = new ArrayList<>();
    MainActivity mainActivity;
    String city;

    public GetXmlTask(MainActivity mainActivity, String city) {
        this.mainActivity = mainActivity;
        this.city = city;
    }

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
        } catch (Exception e) {
            Log.d("GetXmlTask", "xml에러: " + e.getMessage());
        }
        return doc;
    }

    // 작업쓰레드 종료후 처리 (UI 쓰레드)
    @SuppressLint("DefaultLocale")
    @Override
    protected void onPostExecute(Document document) {
        super.onPostExecute(document);

        String s = "";
        NodeList nodeList = doc.getElementsByTagName("data");
        Calendar cal = Calendar.getInstance();
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH) + 1;
        int date = cal.get(cal.DATE);
        String strDate = null;

        for (int i = 0; i < nodeList.getLength(); i++) {
            s += "" + i + ":";
            Node node = nodeList.item(i);
            Element fstElmnt = (Element) node;
            // 날짜 : 2020년 8월 13일
            // 시간, 날씨, 온도, 습도, 강수확률,

            NodeList day = fstElmnt.getElementsByTagName("day");
            Element dayElement = (Element) day.item(0);
            day = dayElement.getChildNodes();
            switch (day.item(0).getNodeValue()) {
                case "0": // 오늘
                    strDate = String.format("%d년 %d월 %d일",
                            year, month, date);
                    Log.d("onPostExecute", "오늘날짜: " + strDate);
                    break;
                case "1": // 내일
                    strDate = String.format("%d년 %d월 %d일",
                            year, month, date + 1);
                    Log.d("onPostExecute", "내일날짜: " + strDate);
                    break;
                case "2": // 모레
                    strDate = String.format("%d년 %d월 %d일",
                            year, month, date + 2);
                    Log.d("onPostExecute", "모레날짜: " + strDate);
                    break;
            }
            s += "날짜 = " + strDate + ", ";

            NodeList hourList = fstElmnt.getElementsByTagName("hour");
            Element hourElement = (Element) hourList.item(0);
            hourList = hourElement.getChildNodes();
            String time = hourList.item(0).getNodeValue();
            s += "시간 = " + time + " ,";

            NodeList tempList = fstElmnt.getElementsByTagName("temp");
            Element tempElement = (Element) tempList.item(0);
            tempList = tempElement.getChildNodes();
            String temp = tempList.item(0).getNodeValue();
            s += "온도℃ = " + temp + " ,";

            NodeList rehList = fstElmnt.getElementsByTagName("reh");
            Element rehElement = (Element) rehList.item(0);
            rehList = rehElement.getChildNodes();
            String humi = rehList.item(0).getNodeValue();
            s += "습도% = " + humi + " ,";

            NodeList popList = fstElmnt.getElementsByTagName("pop");
            Element popElement = (Element) popList.item(0);
            popList = popElement.getChildNodes();
            String pop = popList.item(0).getNodeValue();
            s += "강수확률% = " + pop + " ,";

            NodeList weatherList = fstElmnt.getElementsByTagName("wfKor");
            Element weatherElement = (Element) weatherList.item(0);
            weatherList = weatherElement.getChildNodes();
            String weather = weatherList.item(0).getNodeValue();
            s += "날씨 = " + weather + "\n";
            weatherArrList.add(new MyWeather(strDate, time, temp, humi,
                    pop, weather));
        }
        //weatherInfo.setText(s);
//            for (int i=0; i<weatherArrList.size(); i++) {
//                Log.d("onPostExecute", "날짜: "+
//                        weatherArrList.get(i).getDate());
//                Log.d("onPostExecute", "시간: "+
//                        weatherArrList.get(i).getTime());
//                Log.d("onPostExecute", "온도: "+
//                        weatherArrList.get(i).getTemp());
//                Log.d("onPostExecute", "습도: "+
//                        weatherArrList.get(i).getHumi());
//                Log.d("onPostExecute", "강수확률: "+
//                        weatherArrList.get(i).getPop());
//                Log.d("onPostExecute", "날씨: "+
//                        weatherArrList.get(i).getWeather());
//                Log.d("onPostExecute", "----------------------------");
//            }

        Intent intent = new Intent(mainActivity,
                WeatherView.class);
        intent.putExtra("MyWeather", weatherArrList);
        intent.putExtra("city", city);
        mainActivity.startActivity(intent);
    }
}