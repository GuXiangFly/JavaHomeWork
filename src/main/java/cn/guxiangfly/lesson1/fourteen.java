package cn.guxiangfly.lesson1;

public class fourteen {
 
    static int count = 0; 
    public static void main(String[] args) { 
        int a[] = new int[12]; 
        boolean visit[] = new boolean[10];//因为只用到了a[1]-a[10]; 
        fourteen t=new fourteen();
        t.dfs(a,visit,1); 
        System.out.println(count); 
    } 
   
    void dfs(int[] a, boolean[] visit, int num) { 
        // TODO Auto-generated method stub 
        if (num==11) {          //这里是求种类数，只要满足  num=11即可
            if (judge(a)) {     //judge即是判断八个方向是否非法
                count++; 
            } 
            return; 
        } 
        for (a[num] = 0; a[num] < 10; a[num]++) { 
            if (visit[a[num]]==false) {     //boolean类型数组初始化值均为 false
                visit[a[num]]=true;          //立出访问标志
                num = num + 1; 
                dfs(a, visit, num);        //递归运行判断是否邻近允许
                num = num - 1;             //回溯算法之精髓，如果碰壁就倒退执行
                visit[a[num]]=false; 
            } 
        } 
    } 
   
    public boolean judge(int[] a) { 
        if ((a[1]==a[2]+1||a[1]==a[2]-1)|| 
                (a[1]==a[6]+1||a[1]==a[6]-1)|| 
                (a[1]==a[5]+1||a[1]==a[5]-1)|| 
                (a[1]==a[4]+1||a[1]==a[4]-1)) { 
            return false; 
        }else if ((a[2]==a[5]+1||a[2]==a[5]-1)|| 
                (a[2]==a[3]+1||a[2]==a[3]-1)|| 
                (a[2]==a[7]+1||a[2]==a[7]-1)|| 
                (a[2]==a[6]+1||a[2]==a[6]-1)) { 
            return false; 
        }else if ((a[3]==a[6]+1||a[3]==a[6]-1)|| 
                (a[3]==a[7]+1||a[3]==a[7]-1)) { 
            return false; 
        }else if ((a[4]==a[5]+1||a[4]==a[5]-1)|| 
                (a[4]==a[8]+1||a[4]==a[8]-1)|| 
                (a[4]==a[9]+1||a[4]==a[9]-1)) { 
            return false; 
        }else if ((a[6]==a[7]+1||a[6]==a[7]-1)|| 
                (a[6]==a[10]+1||a[6]==a[10]-1)|| 
                (a[6]==a[9]+1||a[6]==a[9]-1)) { 
            return false; 
        }else if (a[7]==a[10]+1||a[7]==a[10]-1) { 
            return false; 
        }else if (a[8]==a[9]+1||a[8]==a[9]-1) { 
            return false; 
        }else if (a[9]==a[10]+1||a[9]==a[10]-1) { 
            return false; 
        }else if ((a[5]==a[6]+1||a[5]==a[6]-1)|| 
                (a[5]==a[10]+1||a[5]==a[10]-1)|| 
                (a[5]==a[9]+1||a[5]==a[9]-1)|| 
                (a[5]==a[8]+1||a[5]==a[8]-1)) { 
            return false; 
        } 
        return true; 
    } 
   
}