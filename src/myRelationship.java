import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class myRelationship {

    int id;
    mySet set1;
    mySet set2;
    ArrayList<myElement> relation = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    public myRelationship() {

    }

    //检查X是否唯一
    boolean checkXAlone() {
        for (int i = 2; i < relation.size() - 1; i = i + 2) {
            for (int j = 0; j < i; j = j + 2) {
                if (Objects.equals(relation.get(i).value, relation.get(j).value)) {
                    String newWrong = "";
                    newWrong = relation.get(i).value + "对应多个值";
                    Menu.wrong.add(newWrong);
                    return false;
                }
            }
        }
        return true;
    }

    public myRelationship(mySet set1, mySet set2, int id) {
        this.set1 = set1;
        this.set2 = set2;
        this.id = id;
    }

    //写入关系
    public void writeRelation() {
        System.out.println("每个关系两端要用'<'和'>'关系之间用空格隔开,输入回车结束");
        System.out.println("输入示例:");
        System.out.println("<a,2> <b,3> <c,4>");
        System.out.println();
        System.out.println("输入关系格式: ");
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
        System.out.print("关系" + id + ": ");
        System.out.println("集合" + set1.name + "与集合" + set2.name + "的关系");
        System.out.print("{ ");
        for (int i = 0; i <= relation.size() - 2; i = i + 2) {
            System.out.print("<" + relation.get(i).value + "," + relation.get(i + 1).value + ">");
            if (i != relation.size() - 2) {
                System.out.print(",");
            }
        }
        System.out.print(" }");
        System.out.println();
    }
}
