package cn.guxiangfly.jueceshu;

import java.util.Vector;

import static cn.guxiangfly.jueceshu.JCTree.createTree;
import static cn.guxiangfly.jueceshu.JCTree.showTree;
import static cn.guxiangfly.jueceshu.JCTree.suceessGl;

/**������
 * @author��Dyl
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//��ȡ����
		File file=new File();
		String urlTest="test.txt";
		String urlPredict="predict.txt";
		Vector<Object> shuXing=file.getShuXing(urlTest);// ��ȡ����
		Vector<Object>[] testDate=file.readData(urlTest);//��ȡ��������-������ͷ����
		Vector<Object[]> predictData=file.readPredictData(urlPredict);//��ȡ��������
		file=null;
		//����
		TreeNode rootNode= createTree(shuXing,testDate);
		//��ӡ���ṹ
		System.out.println("�������ṹ���£� ");
		showTree(rootNode,0);
		//������Եĳɹ���
		System.out.print("\n�������ĳɹ���Ϊ�� ");
		double temp=0;
		temp= suceessGl(rootNode,shuXing,predictData);
		System.out.println((float)temp*1000/10+"%");
	}
}
