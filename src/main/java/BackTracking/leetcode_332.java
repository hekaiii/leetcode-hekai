package BackTracking;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/1/13
 */
public class leetcode_332 {
  static LinkedList<String> list = new LinkedList<>();
  static LinkedList<String> result = new LinkedList<>();
  public static List<String> findItinerary(List<List<String>> tickets) {
    tickets.sort(Comparator.comparing(o -> o.get(1)));
    int[] used = new int[tickets.size()];
    String start = "JFK";
    list.add(start);
    backTracking(tickets, used);
    return result;
  }

  private static boolean backTracking(List<List<String>> tickets, int[] used) {
    if (list.size() == tickets.size() + 1) {
      result = new LinkedList<>(list);
      return true;
    }
    for (int i = 0; i < tickets.size(); i++) {
      if (tickets.get(i).get(0).equals(list.getLast()) && used[i] == 0) {
        list.add(tickets.get(i).get(1));
        used[i] = 1;
        if (backTracking(tickets, used)) {
          return true;
        }
        used[i] = 0;
        list.removeLast();
      }
    }
    return false;
  }

  public static void main(String[] args) {
    List<List<String>> tickets = new ArrayList<>();
    tickets.add(Arrays.asList("JFK", "SFO"));
    tickets.add(Arrays.asList("JFK", "ATL"));
    tickets.add(Arrays.asList("SFO", "ATL"));
    tickets.add(Arrays.asList("ATL", "JFK"));
    tickets.add(Arrays.asList("ATL", "SFO"));
    List<String> itinerary = findItinerary(tickets);
    System.out.println(itinerary.toString());
  }
}
