import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    ArrayList<myFunction> f = new ArrayList<>();
    int number = 0;

    public void showMenu() {
        while (true) {
            System.out.println("1-----显示当前集合");
            System.out.println("2-----创建一个集合");
            System.out.println("3-----删除一个集合");
            System.out.println("0-----退出");
            int select = in.nextInt();
            switch (select) {
                case 1: {
                    if (f.size() == 0) {
                        System.out.println("当前没有集合");
                    } else {
                        System.out.println("当前集合数: "+f.size());
                        f.get(0).outTheSet();
                    }
                    break;
                }
                case 2: {
                    myFunction newf = new myFunction();
                    checkSameName(newf);
                    break;
                }
                case 3: {
                    System.out.println("3");
                    break;
                }
                case 0: {
                    return;
                }
            }
            try {
                System.out.println("---------");
                System.out.println("按回车继续");
                new BufferedReader(new InputStreamReader(System.in)).readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void checkSameName(myFunction newf){//检查集合名是否相同
        boolean flag=true;
        for (int i=0;i<f.size();i++){
            if (Objects.equals(f.get(i).name, newf.name)){
                flag=false;
            }
        }
        if (flag)
        {
            f.add(newf);
            System.out.println("创建成功 !");
        }
        else {
            System.out.println("集合名已重复 ! !");
        }
    }

}
