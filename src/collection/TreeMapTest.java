package collection;

import java.util.Objects;
import java.util.TreeMap;
//import java.util.TreeMap.Entry;

/**
 * 在使用 TreeMap 时，key 必须实现 Comparable 接口或者在构造 TreeMap 传入自定义的
 * Comparator，否则会在运行时抛出 java.lang.ClassCastException 类型的异常。
 */
public class TreeMapTest {

  public static class MyKey implements Comparable<MyKey>{

    private String name;
    private int age;

    public MyKey(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public int compareTo(MyKey o) {
      return this.age - o.age;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      MyKey myKey = (MyKey) o;
      return age == myKey.age &&
          Objects.equals(name, myKey.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, age);
    }
  }
  public static void main(String[] args) {

    new Thread().start();
    TreeMap re = new TreeMap<>();
//    re.put(new MyKey("zh",12),2);
//    re.put(new MyKey("va",15),3);
//    re.put(new MyKey("zerh",11),4);
//    re.put(new MyKey("er",13),1);
//
//
//    re.forEach((k,v)->{
//      System.out.println(k +":" +v);
//    });
  }


//  private void fixAfterInsertion(Entry<K,V> x) {
//    x.color = RED;
//
//    while (x != null && x != root && x.parent.color == RED) {
//      if (parentOf(x) == leftOf(parentOf(parentOf(x)))) { //父节点是左子节点
//        Entry<K,V> y = rightOf(parentOf(parentOf(x))); //叔叔节点
//        if (colorOf(y) == RED) { //叔叔节点是红色              --情况1
//          setColor(parentOf(x), BLACK); //父节点设置黑色
//          setColor(y, BLACK); //叔叔节点设置黑色
//          setColor(parentOf(parentOf(x)), RED); //祖父节点设为红色
//          x = parentOf(parentOf(x));// 设置位祖父节点继续
//        } else { //叔叔节点是黑色
//          if (x == rightOf(parentOf(x))) { //节点是右子节点    --情况2
//            x = parentOf(x); //设置为父节点
//            rotateLeft(x); //左旋
//          }
//         //父节点是红色叔叔节点是黑色当前节点是左子节点
//          setColor(parentOf(x), BLACK);                     --情况3
//          setColor(parentOf(parentOf(x)), RED);
//          rotateRight(parentOf(parentOf(x)));
//        }
//      } else {
//        Entry<K,V> y = leftOf(parentOf(parentOf(x)));
//        if (colorOf(y) == RED) {
//          setColor(parentOf(x), BLACK);
//          setColor(y, BLACK);
//          setColor(parentOf(parentOf(x)), RED);
//          x = parentOf(parentOf(x));
//        } else {
//          if (x == leftOf(parentOf(x))) {
//            x = parentOf(x);
//            rotateRight(x);
//          }
//          setColor(parentOf(x), BLACK);
//          setColor(parentOf(parentOf(x)), RED);
//          rotateLeft(parentOf(parentOf(x)));
//        }
//      }
//    }
//    root.color = BLACK;
//  }


//  /** From CLR */
//  private void rotateLeft(Entry<K,V> p) {
//    if (p != null) {
//      Entry<K,V> r = p.right;
//      p.right = r.left;//右子节点的左子节点变为当前节点的右子节点
//      if (r.left != null)
//        r.left.parent = p;
//      r.parent = p.parent;
//      if (p.parent == null)
//        root = r;
//      else if (p.parent.left == p)
//        p.parent.left = r;
//      else
//        p.parent.right = r;
//      r.left = p;
//      p.parent = r;
//    }
//  }


  /** From CLR */
//  private void rotateRight(Entry<K,V> p) {
//    if (p != null) {
//      Entry<K,V> l = p.left;
//      p.left = l.right;
//      if (l.right != null) l.right.parent = p;
//      l.parent = p.parent;
//      if (p.parent == null)
//        root = l;
//      else if (p.parent.right == p)
//        p.parent.right = l;
//      else p.parent.left = l;
//      l.right = p;
//      p.parent = l;
//    }
//  }

}
