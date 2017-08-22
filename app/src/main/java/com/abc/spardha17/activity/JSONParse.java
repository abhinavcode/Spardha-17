package com.abc.spardha17.activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinav on 8/12/2017.
 */
public class JSONParse {

    //Declare the arrays of fields you require
    public static String[] names;
    public static String[] urls;
    public static String[] content;
    private JSONArray movies = null;


    List<movie> Movies ;


    private String json;

    public void ParseJSON(){


    }

    protected void parseJSON(String json){
//        JSONObject jsonObject=null;
        this.json = json;
        try {

            movies = new JSONArray(json);


            names = new String[movies.length()];
            urls = new String[movies.length()];
            content= new String[movies.length()];
            Movies = new ArrayList<movie>();



            for(int i=0;i< movies.length();i++){
                movie movie_object =  new movie();

                JSONObject jsonObject = movies.getJSONObject(i);

                names[i] = jsonObject.getString("name");
                urls[i] = jsonObject.getString("url");
                content[i]=jsonObject.getString("content");
                movie_object.setName(names[i]);
                movie_object.setUrl(urls[i]);
                movie_object.setContent(content[i]);
                Movies.add(movie_object);



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    List<movie> getMovies()
    {
        //function to return the final populated list
        return Movies;
    }


}