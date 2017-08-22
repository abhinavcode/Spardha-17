package com.abc.spardha17.activity;

/**
 * Created by abhinav on 8/12/2017.
 */
public class movie {
    private String name;
    private String url;
    private String content;
    public movie(String name, String url,String content) {
        this.name = name;
        this.url = url;
        this.content=content;
    }

    public movie() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content1) {
        content = content1;
    }

    public  void setName(String name1)
    {
        name = name1;
    }
    public void setUrl(String url1)
    {
        url=url1;
    }
    public String getName()
    {
        return name;
    }
    public String getUrl()
    {
        return url;
    }
}
