package test;

import org.junit.Test;
import sort.Insertion;
import sort.Merge;
import sort.Shell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class SortCompare {

    //调用不同的测试方法，完成测试
    public Integer[] loadarray() throws IOException {

        //1.创建一个ArrayList集合，保存读取出来的整数
        ArrayList<Integer> list = new ArrayList<>();

        //2.创建缓存读取流BufferedReader，读取数据，并存储到ArrayList中；

        //不知道为什么找不到文件？？？？？
        /*BufferedReader reader = new BufferedReader
        (new InputStreamReader(
        (SortCompare.class.getClassLoader().
        getResourceAsStream("reverse_arr.txt"))));*/

        BufferedReader reader = new BufferedReader
                (new FileReader("src/uf/reverse_arr.txt"));
        String line=null;
        while (true) {

            if (!((line = reader.readLine()) != null)) break;

            //line是字符串，把line转换成Integer，存储到集合中
            int i = Integer.parseInt(line);
            list.add(i);
        }

        reader.close();


        //3.把ArrayList集合转换成数组
        Integer[] a = new Integer[list.size()];
        list.toArray(a);

        return a;
    }




    //测试希尔排序
    @Test
    public void testShell() throws IOException {
        //1.获取执行之前的时间
        long start = System.currentTimeMillis();
        //2.执行算法代码
        Integer[] a = loadarray();
        Shell.sort(a);
        //3.获取执行之后的时间
        long end = System.currentTimeMillis();
        //4.算出程序执行的时间并输出
        System.out.println("希尔排序执行的时间为："+(end-start)+"毫秒");

    }

    //测试插入排序
    @Test
    public  void testInsertion() throws IOException {
        //1.获取执行之前的时间
        long start = System.currentTimeMillis();
        //2.执行算法代码
        Integer[] a = loadarray();
        Insertion.sort(a);
        //3.获取执行之后的时间
        long end = System.currentTimeMillis();
        //4.算出程序执行的时间并输出
        System.out.println("插入排序执行的时间为："+(end-start)+"毫秒");
    }

    //测试归并排序
    @Test
    public  void testMerge() throws IOException {
        //1.获取执行之前的时间
        long start = System.currentTimeMillis();
        //2.执行算法代码
        Integer[] a = loadarray();
        Merge.sort(a);
        //3.获取执行之后的时间
        long end = System.currentTimeMillis();
        //4.算出程序执行的时间并输出
        System.out.println("归并排序执行的时间为："+(end-start)+"毫秒");
    }

}
