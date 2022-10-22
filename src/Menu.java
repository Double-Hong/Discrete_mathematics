import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    ArrayList<mySet> s = new ArrayList<>();
    ArrayList<myRelationship> r = new ArrayList<>();
    ArrayList<String> wrong = new ArrayList<>();
    int number = 0;

    public Menu() {
        mySet firstSet = new mySet("A");
        s.add(firstSet);
    }

    public void showMenu() {
        while (true) {
            System.out.println("1-----显示当前集合");
            System.out.println("2-----创建一个集合");
            System.out.println("3-----删除一个集合");
            System.out.println("4-----构建关系");
            System.out.println("5-----展示关系");
            System.out.println("6-----判断关系是否为函数");
            System.out.println("0-----退出");
            int select = in.nextInt();
            switch (select) {
                case 1: {
                    showAllSet();
                    break;
                }
                case 2: {
                    mySet newSet = new mySet();
                    checkSameName(newSet);
                    break;
                }
                case 3: {
                    deleteTheSet();
                    break;
                }
                case 4: {
                    System.out.println("4");
                    showAllSet();
                    createRelationship();
                    break;
                }
                case 5: {
                    if (r.size() == 0) {
                        System.out.println("目前没有关系");
                    } else {
                        for (int i = 0; i < r.size(); i++) {
                            r.get(i).showRelation();
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println(r.size());
                    if (r.size() == 0) {
                        System.out.println("目前没有关系");
                    } else {
                        for (int i = 0; i < r.size(); i++) {
                            r.get(i).showRelation();
                        }
                    }
                    System.out.println("输入关系id以判断");
                    int select2 = in.nextInt();
                    if (findRelationshipById(select2) == null) {
                        System.out.println("没有关系" + select2);
                    } else {
                        if (judgeItFunction(findRelationshipById(select2))) {
                            System.out.println("是函数");
                        } else {
                            System.out.println("不是函数");
                            for (int i = 0; i < wrong.size(); i++) {
                                System.out.println(wrong.get(i));
                            }
                        }
                    }
                    break;
                }
                case 0: {
                    return;
                }
            }
            try {
                System.out.println("---------");
                System.out.println();
                System.out.println("按回车继续");
                System.out.println();
                new BufferedReader(new InputStreamReader(System.in)).readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    //判断关系中的元素是否为两个集合中的元素
    public boolean checkItElementRight(myRelationship r) {
        boolean flag1 = false, flag2 = false;
        for (int i = 0; i < r.relation.size() - 1; i = i + 2) {
            for (int j = 0; j < r.set1.set.size(); j++) {
                if (Objects.equals(r.relation.get(i).value, r.set1.set.get(j).value)) {
                    flag1 = true;
                    break;
                }
                if (j == r.set1.set.size() - 1) {
                    String newWrong = "";
                    flag1 = false;
                    newWrong = r.relation.get(i).value + "不在集合" + r.set1.name + "中";
                    wrong.add(newWrong);
                    break;
                }
            }
        }
        for (int i = 1; i < r.relation.size(); i = i + 2) {
            for (int j = 0; j < r.set2.set.size(); j++) {
                if (Objects.equals(r.relation.get(i).value, r.set2.set.get(j).value)) {
                    flag2 = true;
                    break;
                }
                if (j == r.set2.set.size() - 1) {
                    String newWrong = "";
                    flag2 = false;
                    newWrong = r.relation.get(i).value + "不在集合" + r.set2.name + "中";
                    wrong.add(newWrong);
                    break;
                }
            }
        }
        return (flag1 && flag2);
    }

    //判断关系是否为函数
    public boolean judgeItFunction(myRelationship r) {
        if (checkItElementRight(r)) {
            return true;
        } else {
            return false;
        }
    }

    //通过id找关系
    public myRelationship findRelationshipById(int id) {
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).id == id) {
                return r.get(i);
            }
        }
        return null;
    }

    //构建关系
    public void createRelationship() {
        System.out.println("请输入构建关系的两个集合,输入集合名即可: ");
        String A, B;
        A = in.next();
        B = in.next();
        if (findSetByName(A) == null || findSetByName(B) == null) {
            System.out.println("集合" + A + "或集合" + B + "不存在");
            return;
        }
        mySet set1 = findSetByName(A);
        mySet set2 = findSetByName(B);
        set1.outTheSet();
        set2.outTheSet();
        myRelationship myRelation = new myRelationship(set1, set2, r.size() + 1);
        myRelation.writeRelation();
        r.add(myRelation);
    }

    //通过集合名字找集合
    public mySet findSetByName(String name) {
        for (int i = 0; i < s.size(); i++) {
            if (Objects.equals(s.get(i).name, name)) {
                return s.get(i);
            }
        }
        return null;
    }

    //删除一个集合
    public void deleteTheSet() {
        boolean flag = false;
        showAllSet();
        System.out.println("请输入要删除的集合名: ");
        String name = in.next();
        for (int i = 0; i < s.size(); i++) {
            if (Objects.equals(name, s.get(i).name)) {
                flag = true;
                s.remove(i);
                System.out.println("删除成功 ! ! !");
                break;
            }
        }
        if (!flag) {
            System.out.println("没有集合" + name);
        }
    }

    //显示所有集合
    public void showAllSet() {
        if (s.size() == 0) {
            System.out.println("当前没有集合");
        } else {
            System.out.println("当前集合数: " + s.size());
            for (int i = 0; i < s.size(); i++) {
                s.get(i).outTheSet();
            }
        }
    }

    //检查集合名是否相同
    public void checkSameName(mySet newSet) {
        boolean flag = true;
        for (int i = 0; i < s.size(); i++) {
            if (Objects.equals(s.get(i).name, newSet.name)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            s.add(newSet);
            System.out.println("创建成功 !");
        } else {
            System.out.println("集合名已重复 ! !");
        }
    }
}
