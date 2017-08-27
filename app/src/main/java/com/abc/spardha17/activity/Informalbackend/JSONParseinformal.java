package com.abc.spardha17.activity.Informalbackend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinav on 8/23/2017.
 */

public class JSONParseinformal {

    public static String[] urls;
    public static String[] events;
    public static String[] hyperlink;
    private JSONArray informals = null;


    List<informalcontainer> items ;


    private String json;

    public void ParseJSONInformal(){


    }

    public void parseJSONInformal(String json){
//        JSONObject jsonObject=null;
        this.json = json;
        try {

            informals = new JSONArray(json);


            urls = new String[informals.length()];
            events= new String[informals.length()];

            hyperlink= new String[informals.length()];
            items = new ArrayList<informalcontainer>();



            for(int i=0;i< informals.length();i++){
                informalcontainer object =  new informalcontainer();

                JSONObject jsonObject = informals.getJSONObject(i);

                events[i] = jsonObject.getString("eventname");
                urls[i] = jsonObject.getString("urlimg");
                hyperlink[i]=jsonObject.getString("url");
                object.setEventname(events[i]);
                object.setUrlimg(urls[i]);
                object.setHyperlinkimg(hyperlink[i]);
                System.out.println("link is "+hyperlink[i]);
                items.add(object);



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public List<informalcontainer> getItems()
    {
        //function to return the final populated list
        return items;
    }


}
