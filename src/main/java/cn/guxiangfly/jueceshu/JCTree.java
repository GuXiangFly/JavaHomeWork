package cn.guxiangfly.jueceshu;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * ������
 * @author:Dyl
 * 
 */
public class JCTree {

	/**
	 * ����������
	 * @param shuXing������
	 * @param testData����������
	 * @return
	 */
	public static TreeNode createTree(Vector<Object> shuXing,
			Vector<Object>[] testData) {
		int maxGainIndex = -1;// ��¼����������
		double gain = 0;
		double maxGain = 0;
		TreeNode fatherNode = new TreeNode();
		fatherNode.setShuXing(shuXing);// ��������
		// ������
		for (int i = 0; i < shuXing.size() - 1; i++) {
			gain = Gain.infoD(testData, shuXing.size() - 1)
					- Gain.infoSX(testData, i, shuXing.size() - 1);// ĳһ�е�info
			if (maxGain < gain) {
				maxGainIndex = i;
				maxGain = gain;
			}
		}
		if (maxGainIndex == -1) {
			return null;
		}
		Vector<Object> splitSX = Gain.getSX(testData, maxGainIndex);
		fatherNode.setNodeName(shuXing.get(maxGainIndex));
		fatherNode.setSplitShuXing(splitSX);// �����ֵ���з�������

		// ����ӽڵ�
		for (int i = 0; i < splitSX.size(); i++) {
			Vector<Object>[] splitData = splitData(testData, maxGainIndex,
					splitSX.get(i));// //////////////////maxGainIndexû����
			Vector<Object> lastRow = Gain
					.getSX(splitData, splitData.length - 1);// �õ����һ�е�����
			TreeNode sonNode = new TreeNode();
			if (lastRow.size() == 1) {// ȫΪһ�����ԣ�unacc��acc��good��vgood���������������
				sonNode.setNodeName(lastRow.get(0));
			} else {
				Vector<Object> newShuXing = new Vector<Object>();
				// ���´����µ����Լ�,ɾ����������Լ�
				for (Object ob : shuXing) {
					if (!ob.toString().equals(
							shuXing.get(maxGainIndex).toString())) {
						newShuXing.add(ob);
					}
				}
				// System.out.println(newShuXing);
				Vector<Object>[] newDataSet = new Vector[splitData.length - 1];
				int t = 0;
				for (int j = 0; j < splitData.length; j++) {
					if (j == maxGainIndex) {
						continue;
					}
					newDataSet[t++] = (Vector<Object>) splitData[j].clone();
				}
				// // System.out.println(newDataSet[0].size());
				sonNode = createTree(newShuXing, newDataSet);// �ӽڵ������չ������
			}
			if (sonNode != null) {
				fatherNode.addSonNode(sonNode);
			}
		}
		return fatherNode;
	}

	/**
	 * �������Է����
	 * @param testData
	 * @param maxGainIndex
	 * @param object
	 * @return
	 */
	private static Vector<Object>[] splitData(Vector<Object>[] testData,
			int maxGainIndex, Object object) {
		Vector<Object>[] splitBiao = new Vector[testData.length];
		for (int i = 0; i < splitBiao.length; i++) {
			splitBiao[i] = new Vector<Object>();
		}
		for (int i = 0; i < testData[maxGainIndex].size(); i++) {// i��
			Object object2 = testData[maxGainIndex].get(i);
			if (object2.toString().equals(object.toString())) {
				for (int j = 0; j < splitBiao.length; j++) {
					splitBiao[j].add(testData[j].get(i));
				}
			}
		}
		return splitBiao;
	}

	/**
	 * ��ӡ������
	 * @param rootNode
	 */
	public static void showTree(TreeNode rootNode, int ceng) {
		System.out.println(rootNode.getNodeName());
		List<Object> splitShuXing = rootNode.getSplitShuXing();
		ArrayList<TreeNode> sonNode = rootNode.getSonNode();
		if (splitShuXing != null) {// ���û�з�֧
			for (int i = 0; i < splitShuXing.size(); i++) {
				for (int j = 0; j <= ceng; j++)
					System.out.print("     ");
				System.out.print(splitShuXing.get(i) + "-->");
				showTree(sonNode.get(i), (ceng + 1));
			}
		}
	}

	/**
	 * ����ɹ��ʣ�����ӡ�����
	 * @param rootNode
	 * @param shuXing
	 * @param predictData
	 */
	public static double suceessGl(TreeNode rootNode, Vector<Object> shuXing,
			Vector<Object[]> predictData) {
		int sucess = 0;
		for (int i = 0; i < predictData.size(); i++) {
			Object object = getResult(rootNode, shuXing, predictData.get(i));//uacc ,acc, good,vgood
			if (object.toString().equals(
					predictData.get(i)[(predictData.get(i).length-1)].toString())) {
				sucess++;
			}
		}
		return (double) sucess / predictData.size();

	}

	/**
	 * ͨ�����ڵ㿪ʼ���ʣ��ó�ÿһ����¼�Ľ��
	 * @param rootNode
	 * @param shuXing
	 * @param objects
	 * @return
	 */
	private static Object getResult(TreeNode rootNode, Vector<Object> shuXing,
			Object[] eachRow) {
			if (rootNode.getSonNode().size()==0) {
				return rootNode.getNodeName();
			}
			Object nodeName=rootNode.getNodeName();
			int index=shuXing.indexOf(nodeName);
			Object splitSX=eachRow[index];
			int sxIndex=0;
			for (int i = 0; i < rootNode.getSplitShuXing().size(); i++) {
				Object temp =rootNode.getSplitShuXing().get(i);
				if (splitSX.toString().equals(temp.toString())) {
					sxIndex=i;
				}
			}
		return getResult(rootNode.getSonNode().get(sxIndex),shuXing,eachRow);
	}

}
