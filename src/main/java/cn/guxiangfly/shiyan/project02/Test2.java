package cn.guxiangfly.shiyan.project02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test2 {
	public static void main (String[] args){
		Map<String,String> user=new HashMap<String,String>();
		System.out.println("下面是集合的所有元素：");
		user.put("id","1");
		user.put("name","guxiang");
		user.put("sex","男");
		user.put("ade","20");
		user.put("love","coding");
		for(Iterator<Map.Entry<String, String>> iter = user.entrySet().iterator(); iter.hasNext();){
			Map.Entry entry=(Map.Entry) iter.next();
			System.out.println("键："+entry.getKey()+"-->值"+entry.getValue());
		}
		System.out.println(user.size());
		System.out.println(user.get("age"));
		user.remove("age");
		System.out.println("删除操作后，集合的大小为"+user.size());
	}
}
