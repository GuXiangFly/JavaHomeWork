package cn.guxiangfly.waibao;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Stack;

/**
 * Test
 *
 * @author guxiang
 * @date 2017/12/15
 */
public class Test {
    private int l;
    private int b;

    public Test(){
        l=2;
        b=4;

    }

    public static void main(String[] args) {
        Test at = new Test();
        while (at.l>0){
            System.out.println(--at.b+(at.l--));
        }
    }



    public int eval(String[] expr){

        Stack <Integer > nums = new Stack <>();


       for( String tok : expr) {
           if (tok.equals("*")) {
               nums.push(nums.pop() * nums.pop());
               continue;
           }
           if (tok.equals("+")) {
               nums.push(nums.pop() + nums.pop());
               continue;
           }
       }
      return nums.pop();
    }


}
