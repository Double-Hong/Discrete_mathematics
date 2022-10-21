import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class mySet {
    String name;
    ArrayList<myElement> set = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public mySet() {
        System.out.println("输入规则:");
        System.out.println("集合:直接输入元素,每个元素用空格或者回车隔开,输入'00'结束");
        System.out.println("输入集合名:(集合名需唯一)");
        name = in.next();
        System.out.println("输入集合:");
        String select = in.next();
        while (!Objects.equals(select, "00")) {
            myElement e = new myElement(select);
            set.add(e);
            select = in.next();
        }
    }

    //输出集合
    public void outTheSet() {
        System.out.print("集合" + name + ": ");
        System.out.print("<");
        for (int i = 0; i < set.size(); i++) {
            if (i != set.size() - 1) {
                System.out.print(",");
                System.out.print(set.get(i).value);
            }
        }
        System.out.println(">");
    }
}
