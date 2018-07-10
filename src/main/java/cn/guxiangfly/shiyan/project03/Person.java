package cn.guxiangfly.shiyan.project03;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Table(name="Person")
public class Person {

	@Field(name = "name")
	private String name;

	@Field(name = "sex")
	private String sex;

	@Field(name = "birthPlace")
	private String birthPlace;

	@Field(name = "birthDay")
	private Date birthDay;

	public Person(String name, String sex, String birthPlace, Date birthDay) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthPlace = birthPlace;
		this.birthDay = birthDay;
	}

	public int age() {
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		return yearNow - birthDay.getYear();
	}


	@Override
	public String toString() {
		String sdate=(new SimpleDateFormat("yyyy年MM月dd日")).format(birthDay);
//		System.out.println(sdate);
		return String.format("%s,%s,%s出生于%s",
				name, sex, sdate, birthPlace);
	}
}

