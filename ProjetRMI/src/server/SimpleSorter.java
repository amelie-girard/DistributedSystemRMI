package server;



import java.util.Collections;
import java.util.List;

import Common.Sorter;


public class SimpleSorter implements Sorter {

  public List<String> sort(List<String> list) {

    System.out.println(this + ": receveid " + list);

    Collections.sort(list);

    System.out.println(this + ": returning " + list);
    return list;
  }

  public List<String> reverseSort(List<String> list) {

    System.out.println(this + ": receveid " + list);

    Collections.sort(list);
    Collections.reverse(list);

    System.out.println(this + ": returning " + list);
    return list;
  }

  @Override
  public String toString() {
    return "SimpleSorter " + Thread.currentThread();
  }

}
