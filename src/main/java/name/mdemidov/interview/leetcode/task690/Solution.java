package name.mdemidov.interview.leetcode.task690;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/employee-importance/
 *
 * <p>690. Employee Importance
 *
 * <p>You have a data structure of employee information, which includes the employee's unique id,
 * their importance value, and their direct subordinates' id.
 *
 * <p>You are given an array of employees employees where:
 *
 * <p>employees[i].id is the ID of the ith employee. employees[i].importance is the importance value
 * of the ith employee. employees[i].subordinates is a list of the IDs of the subordinates of the
 * ith employee. Given an integer id that represents the ID of an employee, return the total
 * importance value of this employee and all their subordinates.
 *
 * <p>Example 1:
 *
 * <p>Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
 *
 * <p>Output: 11
 *
 * <p>Explanation: Employee 1 has importance value 5, and he has two direct subordinates: employee 2
 * and employee 3. They both have importance value 3. So the total importance value of employee 1 is
 * 5 + 3 + 3 = 11.
 *
 * <p>Example 2:
 *
 * <p>Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
 *
 * <p>Output: -3
 *
 * <p>Constraints:
 * <li>1 <= employees.length <= 2000
 * <li>1 <= employees[i].id <= 2000
 * <li>All employees[i].id are unique.
 * <li>-100 <= employees[i].importance <= 100
 * <li>One employee has at most one direct leader and may have several subordinates.
 * <li>id is guaranteed to be a valid employee id.
 */
public class Solution {

  private static final Solution S = new Solution();

  public static void main(String[] args) {
    List<Employee> employees1 = new ArrayList<>();
    employees1.add(new Employee(1, 5, 2, 3));
    employees1.add(new Employee(2, 3));
    employees1.add(new Employee(3, 3));
    System.out.println(S.getImportance(employees1, 1)); // 11

    List<Employee> employees2 = new ArrayList<>();
    employees2.add(new Employee(1, 2, 5));
    employees2.add(new Employee(5, -3));
    System.out.println(S.getImportance(employees2, 5)); // -3
  }

  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> map = new HashMap<>();
    for (Employee cur : employees) {
      map.put(cur.id, cur);
    }
    return dfs(id, map);
  }

  private static int dfs(int id, Map<Integer, Employee> map) {
    Employee e = map.get(id);
    int res = e.importance;
    for (int sub : e.subordinates) {
      res += dfs(sub, map);
    }
    return res;
  }

  private static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    Employee(int id, int importance, int... subs) {
      this.id = id;
      this.importance = importance;
      subordinates = new ArrayList<>();
      for (int s : subs) {
        subordinates.add(s);
      }
    }
  }
}
