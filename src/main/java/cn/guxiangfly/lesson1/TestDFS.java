package cn.guxiangfly.lesson1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * TestDFS
 *
 * @author guxiang
 * @date 2017/10/11
 */
public class TestDFS {

    //跳跃方向
    static int[][] dir =
            {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    //判断是否可以跳跃
    static boolean[][] tags = new boolean[3][4];

    static int count = 0;

    static int[][] arr = new int[3][4];

    static boolean vis[] = new boolean[10];

    public static void main(String[] args) {


        for (boolean[] tag : tags) {
            Arrays.fill(tag,true);
        }
        tags[0][0] = false;
        tags[2][3] = false;

        //初始化为0
       // Arrays.fill(arr, 0);
        for (int[] arr2 : arr) {
            Arrays.fill(arr2,0);
        }
        Arrays.fill(vis,false);
        DFS(0);
        System.out.println(count);
    }



    public static void DFS(int num){



        int row = num/4;
        int column = num%4;

        if (row>2){
            check();
            return;
        }

        if (tags[row][column]){
            for(int i = 0; i < 10; i ++)
                if(!vis[i])
                {
                    vis[i] = true;
                    arr[row][column] = i;
                    DFS(num + 1);
                    vis[i] = false;
                }
        }else {
            DFS(num+1);
        }
    }


    public static void check() {
        boolean flag = false;
        //遍历矩阵
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (!tags[i][j]) {
                    continue;
                }

                //风骚走8方
                for (int k = 0; k < 8; k++) {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    ///越界判断
                    if (x >= 0 && x <= 2 && y >= 0 && y <= 3 && tags[x][y]) {
                        ///左右、上下或对角有数相邻
                        if (Math.abs(arr[i][j] - arr[x][y]) == 1)
                            flag = true;
                    }
                }
            }
        }
        if (!flag) {
            count++;
        }
    }
}
