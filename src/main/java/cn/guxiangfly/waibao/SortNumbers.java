package AlgorithmsDesign;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * VIC
 * 01/07/2018
 */
public class SortNumbers {
	public static void main(String[] args) {
		System.out.println("how much nums you want to sort: ");
		Scanner input=new Scanner(System.in);
		BigInteger []arr=new BigInteger[input.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("input num"+(i+1)+": ");
			arr[i]=input.nextBigInteger();
		}
		System.out.println();
		System.out.println(getMaxSum(arr));
	}

	public static String getMaxSum(BigInteger[] nums) {
		if (nums == null) {
			return "";
		}
		String [] numsStr=new String[nums.length];
		int i=0;
		for(BigInteger num:nums) {
			numsStr[i++]=num+"";
		}
		Arrays.sort(numsStr,new Comparator<String>() {//javase6之后出现的一个内置比较器的写法
			public int compare(String str1, String str2) {
				String temp1=str1+str2;
				String temp2=str2+str1;

				/**
				 * Arrays工具类内置的比较器，如果 temp1 对比 temp2 大 那么temp1.compareTo
				 * (temp2)返回 1  会将 temp1 放在树的右边 temp2放在树的左边
				 * -temp1.compareTo(temp2)返回 -1 会将 temp1 放在树的左边 temp2放在树的右边
				 * 算法按树的结构进行遍历， 导致结果为 逆序
				 */
				return (-temp1.compareTo(temp2));//没看懂为什么要减号
			}
		});

		StringBuilder sbBuilder=new StringBuilder();
		for(String s:numsStr)
			sbBuilder.append(s);
		return sbBuilder.toString();
	}
}
