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
    TextView kangwon, seoul, kyongki, daejun, daegu, pusan, jeju;
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
                        new GetXmlTask((MainActivity) getActivity(), "강원도");
                task.execute(
                        "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=73&gridy=134");
            }
        });

        seoul = rootView.findViewById(R.id.seoul);
        seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("hack4ork", "서울 클릭");
                GetXmlTask task =
                        new GetXmlTask((MainActivity) getActivity(), "서울");
                task.execute(
                        "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=60&gridy=120");
            }
        });

        return rootView;
    }
}