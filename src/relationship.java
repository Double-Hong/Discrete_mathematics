import java.util.ArrayList;
import java.util.Scanner;

public class relationship {

    int id;
    mySet set1;
    mySet set2;
    ArrayList<myElement> relation = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    public relationship() {

    }

    public relationship(mySet set1, mySet set2, int id) {
        this.set1 = set1;
        this.set2 = set2;
        this.id = id;
    }

    //写入关系
    public void writeRelation() {
        System.out.println("输入关系格式: ");
        System.out.println("每个关系两端要用'<'和'>'关系之间用空格隔开,输入回车结束");
        String rel = in.nextLine();
        StringBuilder l = new StringBuilder();
        for (int i = 0; i < rel.length(); i++) {
            if (rel.charAt(i) == ',' || rel.charAt(i) == '>') {
                myElement e = new myElement(l.toString());
                relation.add(e);
                l = new StringBuilder();
            } else if (rel.charAt(i) != '<' && rel.charAt(i) != ' ') {
                l.append(rel.charAt(i));
            }
        }
        System.out.println("构建关系成功 ! ! !");
    }

    //展示关系
    public void showRelation() {
        System.out.println("关系" + id);
        System.out.println("集合" + set1.name + "与集合" + set2.name + "的关系");
        System.out.print("< ");
        for (int i = 0; i <= relation.size() - 2; i = i + 2) {
            System.out.print("<" + relation.get(i).value + "," + relation.get(i + 1).value + ">");
            if (i != relation.size() - 2) {
                System.out.print(",");
            }
        }
        System.out.print(" >");
        System.out.println();
    }
}
