import java.util.Scanner;

public class myFunction {
    String value = "";//集合值
    String name ="";//集合名
    Scanner in = new Scanner(System.in);
    public myFunction(){
        System.out.println("输入规则:");
        System.out.println("集合:直接输入元素,每个元素用','隔开");
        System.out.println("输入集合名:");
        name =in.next();
        System.out.println("输入集合:");
        value = in.next();
        System.out.println("创建成功 !");
    }
    //输出集合
    public void outTheSet(){
        System.out.print("集合"+name+": ");
        System.out.print("<");
        for (int i=0;i<value.length();i++){
            System.out.print(value.charAt(i));
        }

        System.out.println(">");
    }
}
