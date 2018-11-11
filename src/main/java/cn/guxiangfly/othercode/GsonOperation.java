package cn.guxiangfly.othercode;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 11/10/18
 * @desc : JavaHomeWork
 */
public class GsonOperation {
    public static void main(String args[]) {

        String zh_str = "{\"name\":\"BeJson\",\"url\":\"http://www.bejson.com\",\"page\":88,\"isNonProfit\":true," +
                "\"address\":{\"street\":\"�Ƽ�԰·.\",\"city\":\"��������\",\"country\":\"�й�\"}," +
                "\"links\":[{\"name\":\"Google\",\"url\":\"http://www.google.com\"}]}";
        Gson zh_gson=new Gson();
        Root root = zh_gson.fromJson(zh_str,new TypeToken<Root>(){}.getType());
        ArrayList<Links> link =  root.getLinks();
        for (Links links : link) {
            System.out.println(links.getName()+" "+links.getUrl());
        }

    }
}





 class Root {
    private ArrayList<Links> links;
    public ArrayList getLinks() {
        return links;
    }
    public Root(ArrayList links) {
        this.links = links;
    }
}


 class Links {
    private String  url;
    private String name;

    public Links(String url, String name) {
        this.url = url;
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}