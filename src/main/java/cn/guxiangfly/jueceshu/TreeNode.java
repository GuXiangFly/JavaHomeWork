package cn.guxiangfly.jueceshu;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TreeNode {
	private Object nodeName;//�ڵ�����
	private List<Object> splitShuXing; // ����������
	private ArrayList<TreeNode> sonNode;//���������ӽڵ�
	private Vector<Object> shuXing;//����
	
	public TreeNode() {
		sonNode=new ArrayList<TreeNode>();
	}
	public Vector<Object> getShuXing() {
		return shuXing;
	}
	public void setShuXing(Vector<Object> shuXing) {
		this.shuXing = shuXing;
	}
	public Object getNodeName() {
		return nodeName;
	}
	public void setNodeName(Object nodeName) {
		this.nodeName = nodeName;
	}
	public List<Object> getSplitShuXing() {
		return splitShuXing;
	}
	public void setSplitShuXing(List<Object> splitShuXing) {
		this.splitShuXing = splitShuXing;
	}
	
	
	public ArrayList<TreeNode> getSonNode() {
		return sonNode;
	}

	public void addSonNode(TreeNode sonNode2) {
		this.sonNode.add(sonNode2);
	}
	
	
	
	
}
