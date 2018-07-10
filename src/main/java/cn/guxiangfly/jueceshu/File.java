package cn.guxiangfly.jueceshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**�ļ�������
 * @author��Dyl
 * 
 */
public class File {

	/**
	 *������
	 * @throws Exception 
	 */
	public  Vector<Object>[] readData(String url) throws Exception {
		Vector<Object>[]vector = null;
		String[] list;
		InputStreamReader in = new InputStreamReader(getClass()
				.getResourceAsStream(url));
		BufferedReader reader = new BufferedReader(in);
		String line = reader.readLine();
		line = reader.readLine();//�������У���������
		if (line!=null) {
			vector=new Vector[line.split(",").length];
			for (int i = 0; i < vector.length; i++) {
				vector[i]=new Vector<Object>();
			}
		}
		while ((line=reader.readLine()) != null) {
			String []s=line.split(",");
			for (int i = 0; i < vector.length; i++) {
				vector[i].add(s[i]);
			}
		}
		in.close();
		reader.close();
		return vector;		
	}
	
	
	
	/**��ȡ����
	 * @param urlTest���ļ�·��
	 * @return
	 * @throws IOException
	 */
	public Vector<Object> getShuXing(String urlTest) throws IOException {
		Vector<Object> vector=new Vector<Object>();
		InputStreamReader in = new InputStreamReader(getClass()
				.getResourceAsStream(urlTest));
		BufferedReader reader = new BufferedReader(in);
		String string=reader.readLine();
		if (!string.equals("")) {
			String []t=string.split(",");//��������
			for (String st : t) {
				vector.add(st);
			}
		}
		in.close();
		reader.close();
		return vector;
	}



	/**���ű���predict������
	 * @param urlPredict���ļ�·��
	 * @return
	 * @throws IOException 
	 */
	public Vector<Object[]> readPredictData(String urlPredict) throws IOException {
		Vector<Object[]>vector = new Vector<Object[]>();
		InputStreamReader in = new InputStreamReader(getClass()
				.getResourceAsStream(urlPredict));
		BufferedReader reader = new BufferedReader(in);
		String line = reader.readLine();
		line = reader.readLine();//�������У���������
		while ((line=reader.readLine()) != null) {
			String []s=line.split(",");
			vector.add(s);
		}
		in.close();
		reader.close();
		return vector;		
	}
}
