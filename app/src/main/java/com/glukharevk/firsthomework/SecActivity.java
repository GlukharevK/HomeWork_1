package com.glukharevk.firsthomework;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;



    public class SecActivity extends ActionBarActivity {

       // private ArrayList<Map<String, Object>> data;
       // private Map<String, Object> m;
        //private ListAdapter adapter;
       // private List<String> data2;


        private final int n = 1000;
        private String[] basis = {"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь",
                "девять", "десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                "семнадцать", "восемьнадцать", "девятнадцать", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
                "семьдесят", "восемьдесят", "девяносто", "сто", "двести", "триста", "четыреста", "патьсот", "шестьсот", "семьсот", "восемьсот",
                "девятьсот", "тысяча"};

        private String[] name = new String[n];
        ArrayList<StringItems> stringItems = new ArrayList<StringItems>();
        ListAdapter listAdapter;

        int val = 0;
        int buf = 0;
        int deg = 0;
        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = false;
        boolean test12 = false;



        final String ATTRIBUTE_NAME_TEXT = "text";
        final String ATTRIBUTE_NAME_IMAGE = "image";


        int img = R.drawable.ic_launcher;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sec);
            fillData();
            listAdapter = new ListAdapter(this, stringItems);
            for (int i = 0; i < name.length; i++) {
                 stringItems.add(new StringItems(name[i], R.drawable.ic_launcher));

            }
            ListView lvMain = (ListView) findViewById(R.id.lvSimple);
            lvMain.setAdapter(listAdapter);
        }







        public void fillData(){
            int val = 0;
            int buf = 0;
            int deg = 0;
            boolean test1 = false;
            boolean test2 = false;
            boolean test3 = false;
            boolean test12 = false;

            {
                for (int i = 1; i < n + 1; i++) {
                    buf = i;
                    while (buf != 0) {

                        val += (int) buf % 10 * Math.pow(10, deg);
                        deg++;
                        buf /= 10;

                        if (val <= 10 && val > 0 && !test1) {
                            name[i - 1] = (String) basis[val - 1];
                            test1 = true;
                        }
                        if (val <= 20 && val > 10 && !test12) {
                            name[i - 1] = (String) basis[val - 1];
                            test12 = true;
                        } else if (val > 20 && val <= 100 && !test2) {
                            if (name[i - 1] != null)
                                name[i - 1] = (String) (basis[17 + val / 10] + " " + name[i - 1]);
                            else name[i - 1] = (String) (basis[17 + val / 10]);
                            test2 = true;
                        } else if (val > 100 && val <= 1000 && !test3) {
                            if (name[i - 1] != null)
                                name[i - 1] = (String) (basis[26 + val / 100] + " " + name[i - 1]);
                            else name[i - 1] = (String) (basis[26 + val / 100]);
                            test3 = true;
                        }
                    }

                    buf = 0;
                    val = 0;
                    deg = 0;
                    test1 = test2 = test12 = test3 = false;
                }
            }



        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu_sec, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }



}
