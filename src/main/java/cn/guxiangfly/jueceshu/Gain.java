package cn.guxiangfly.jueceshu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 * ����
 * @author��Dyl
 */
public class Gain {

	/**
	 * D����ֵ
	 * @param testData����������
	 * @param index���±�
	 * @return��infoD
	 */
	public static double infoD(Vector<Object>[] testData, int index) {
		double infoD = 0;
		Map<Object, Integer> mapCount = SXCount(testData, index);// ͳ���¸�������µĸ�������
		int size = testData[index].size();// ���һ�еĴ�С
		Object[] ob = mapCount.keySet().toArray();
		for (int i = 0; i < ob.length; i++) {
			double pi = (double) mapCount.get(ob[i]) / size;
			infoD += (-1) * pi * Math.log(pi) / Math.log(2);
//			System.out.println("info:"+infoD);
		}
		return infoD;
	}

	/**
	 * ͳ���¸�������µĸ�������
	 * @param testData����������
	 * @param index���±�
	 * @return
	 */
	private static Map<Object, Integer> SXCount(Vector<Object>[] testData,
			int index) {
		Vector<Object> Item = testData[index];
		Map<Object, Integer> mapCount = new HashMap<Object, Integer>();
		for (int i = 0; i < Item.size(); i++) {
			Object object = Item.get(i);
			if (mapCount.containsKey(object)) {
				mapCount.put(object, mapCount.get(object) + 1);// һ��Map�в��ܰ�����ͬ��key��ÿ��keyֻ��ӳ��һ��value
			} else {
				mapCount.put(object.toString(), 1);
			}
		}
		return mapCount;
	}

	/**
	 * �õ���i���µ�����
	 * @param i:��i��
	 * @param testData
	 * @return
	 */
	public static Vector<Object> getSX(Vector<Object>[] testData, int i) {
		Vector<Object> objects = new Vector<Object>();
		Vector<Object> list = testData[i];
		for (int j = 0; j < list.size(); j++) {
			Object o = list.get(j);
			if (!objects.contains(o)) {
				objects.add(o);
			}
		}
		return objects;
	}

		/**��ָ�����ϵ���Ϣ��
		 * @param ob1
		 * @param index1
		 * @param index2
		 * @return:��ͬ���Ե���ֵ
		 */
	public static double infoSX(Vector<Object>[] ob1, int index1, int index2) {
			Map<Object, Integer> map = SXCount(ob1, index1);
			Vector<Object> value1 = getSX(ob1, index1);
			double infoX= 0.000;
			for (int i = 0; i < value1.size(); i++) {
				Map<Object, Integer> temp = new HashMap<Object, Integer>();
				Object object1 = value1.get(i);
				for (int j = 0; j < ob1[index1].size(); j++) {
					Object object2 = ob1[index1].get(j);
					if (object1.toString().equals(object2.toString())) {
						Object object3 = ob1[index2].get(j);
						if (temp.containsKey(object3)) {
							temp.put(object3, temp.get(object3) + 1);
						} else {
							temp.put(object3, 1);
						}
					}
				}
				double[] pi = new double[temp.size()];
				Object[] tt = temp.keySet().toArray();
				for (int j = 0; j < pi.length; j++) {
					pi[j] = (double) temp.get(tt[j]) / map.get(object1);
				}
				double item = 0;
				for (int j = 0; j < pi.length; j++) {
					if (pi[j] == 0) {
						pi[j] = 1;
					}
					item += (double) pi[j] * Math.log(pi[j]) / Math.log(2);
				}
				infoX+= (double) map.get(object1) / ob1[index1].size() * (-1 * (item));
			}
			return infoX;		
		}
}
