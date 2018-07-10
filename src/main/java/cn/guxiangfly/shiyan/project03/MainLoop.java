package cn.guxiangfly.shiyan.project03;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class  MainLoop{

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthgu = sdf.parse("1997-3-3");
		Date birthliu
				= sdf.parse("1996-3-11");

		Person guxiang = new Person("顾翔", "男", "无锡", birthgu);

		Person liuming = new Person("刘明", "男", "无锡", birthliu);
		System.out.println(guxiang);
		System.out.println(liuming);

		Class<Person> clazz = Person.class;
		java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
		for (java.lang.reflect.Field f : fields) {
                   System.out.println("Person字段上的注解有：" + f.getAnnotation(Field.class));
		}


		Annotation[] classAnnotation = Person.class.getAnnotations();
		for (Annotation ann : classAnnotation) {
			Class annotationType = ann.annotationType();
			System.out.println("Person类上的注解有: " + ann.annotationType());
		}

	}
}