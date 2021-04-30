package org.rabbit.jp0.practise.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JAVA8新特性之StreamAPI简单练习 https://blog.csdn.net/K_520_W/article/details/83032889
 */
public class StreamAPIExcersize {
    public static void main(String[] args) {
        test1();
        testEmployees();
        testTransaction();
    }
    /**
    给定一个数字列表，如何返回一个由每个数的平方构成的数字列表呢？
        例如：给定[1,2,3,4,5]，返回[1,4,9,16,25]
     */
    public static void test1() {
        int[] arrays = new int[]{1,2,3,4,5};
        Arrays.stream(arrays).map(i-> i*i).forEach(System.out::println);
    }

    /**
     * 怎样使用map和reduce方法数一数流中有多少个Employee呢？
     */
    public static void testEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee("ABC", 10),
                new Employee("BCD", 50),
                new Employee("XXX", 100),
                new Employee("MMM", 30),
                new Employee("MMM", 30),
                new Employee("BCD", 50)
        );

       int count = employees.stream().map(e -> 1).reduce(Integer::sum).get();
       System.out.println("Employee count:" + count);
    }

    public static void testTransaction() {
        List<Transaction> transactions0 = getTransactionList();
        //找出2020年发生的所有交易， 并按交易额排序（从低到高）
        System.out.println("---------------020年发生的所有交易， 并按交易额排序（从低到高）:");
        transactions0.stream().filter(t -> t.year == 2020).sorted((t1, t2) -> t1.value - t2.value).forEach(System.out::println);

        transactions0 = getTransactionList();
        //交易员都在哪些不同的城市工作过？
        System.out.println("---------------交易员都在哪些不同的城市工作过？:");
        transactions0.stream().map(t -> t.trade.city).distinct().forEach(System.out::println);

        //查找所有来自Beijing的交易员，并按姓名排序
        System.out.println("---------------查找所有来自Beijing的交易员，并按姓名排序:");
        transactions0.stream().map(t -> t.trade).filter(t -> t.city == "Beijing")
                .map(t -> t.name)
                .distinct().sorted().forEach(System.out::println);

        //返回所有交易员的姓名字符串，按字母顺序排序，结果: ------112334aaaaaaddddddeeeeeerrrrrrtttttt
        System.out.println("---------------返回所有交易员的姓名字符串，按字母顺序排序:");
        String connectedNameChars = transactions0.stream().map(t -> t.trade.name)
                .flatMap(name -> name.chars().mapToObj(c -> (char) c))
                .sorted((c1, c2) -> c1.compareTo(c2))
                .map(c -> c.toString())
                .collect(Collectors.joining());
        System.out.println(connectedNameChars);

        //有没有交易员是在Beijing工作的？
        boolean exists = transactions0.stream().anyMatch(t -> t.trade.city == "Beijing");
        System.out.println("---------------有没有交易员是在Beijing工作的:" + exists);

        //打印生活在Beijing的交易员的所有交易额
        int totalV = transactions0.stream().filter(t -> t.trade.city == "Beijing").map(t -> t.value)
                .reduce(Integer::sum).get();
        System.out.println("---------------在Beijing工作的交易员成交总金额:" + totalV);

        //所有交易中，最高的交易额是多少
        //int maxV = transactions0.stream().map(t -> t.value).reduce(Integer::max).get();
        int maxV = transactions0.stream().map(t -> t.value).max(Integer::compareTo).get();
        System.out.println("---------------所有交易中，最高的交易额是:" + maxV);

        //找到交易额最小的交易
        Transaction minTransaction = transactions0.stream().min( (t1, t2) -> Integer.compare(t1.value, t2.value)).get();
        System.out.println("---------------交易额最小的交易:" + minTransaction);

    }

    private static List<Transaction>  getTransactionList() {
        Trade trade1 = new Trade("trade-1", "Beijing");
        Trade trade2 = new Trade("trade-2", "Zhuhai");
        Trade trade3 = new Trade("trade-3", "Beijing");
        Trade trade4 = new Trade("trade-4", "GuangZhou");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(trade1, 2020, 100),
                new Transaction(trade2, 2021, 200),
                new Transaction(trade3, 2019, 100),
                new Transaction(trade3, 2020, 300),
                new Transaction(trade4, 2020, 200),
                new Transaction(trade1, 2021, 600));

        return transactions;
    }

    static class Employee {
        String name;
        int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class Trade {
        String name;
        String city;

        public Trade(String name, String city) {
            this.name = name;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Trade{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
    static class Transaction {
        Trade trade;
        int year;
        int value;

        public Transaction(Trade trade, int year, int value) {
            this.trade = trade;
            this.year = year;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "trade=" + trade +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }
}
