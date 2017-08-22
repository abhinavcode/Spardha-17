package com.abc.spardha17.activity.OurTeamCard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.abc.spardha17.activity.JSONParse.names;
import static com.abc.spardha17.activity.JSONParse.urls;

/**
 * Created by abhinav on 8/15/2017.
 */

public class JSONParseteam {
    public static String[] name;
    public static String[] url;
    public static String[] designation;
    public static String[] fb;
    public static String[] contact;

    private JSONArray team = null;


    List<DataContacts> data ;


    private String json;

    public void ParseJSONteam(){


    }

    public void parseJSONteam(String json){
//        JSONObject jsonObject=null;
        this.json = json;
        try {

            team = new JSONArray(json);


            name = new String[team.length()];
            url = new String[team.length()];
            designation= new String[team.length()];
            fb=new String[team.length()];
            contact=new String[team.length()];
            data = new ArrayList<DataContacts>();



            for(int i=0;i< team.length();i++){
                DataContacts data_object =  new DataContacts();

                JSONObject jsonObject = team.getJSONObject(i);

                names[i] = jsonObject.getString("name");
                urls[i] = jsonObject.getString("url");
                designation[i]=jsonObject.getString("post");
                fb[i]=jsonObject.getString("fb");
                contact[i]=jsonObject.getString("contact");
                data_object.setNameofperson(names[i]);
                data_object.setImageURL(urls[i]);
                data_object.setDesignation(designation[i]);
                data_object.setFb(fb[i]);
                data_object.setContact(contact[i]);
                data.add(data_object);



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public List<DataContacts> getData()
    {
        //function to return the final populated list
        return data;
    }

}
