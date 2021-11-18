# Lambda

* 举例 

  ```java
  Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2)
  ```

* 格式

  -> : lambda操作符 或 箭头操作符

  ->左边： lambda形参列表

  ->右边：lambda体

* lambda表达式的使用

  ​	总结：lambda形参只有一个时，可以省略括号。数据类型可以省略（类型推断）；lambda体只有一条执行语句，可以省略大括号和return。

  * 无参，无返回值

    ~~~java
    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Lambda!");
        }
    };
    r1.run();
    
    System.out.println("***********");
    
    Runnable r2 = () -> System.out.println("Lambda2!");
    r2.run();
    ~~~

  * 需要一个参数，但是没有返回值

    ```java
    Consumer<String> consumer1 = new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    };
    consumer1.accept("Lambda!");
    
    Consumer<String> consumer2 = (String s) -> {
        System.out.println(s);
    };
    //Consumer<String> consumer2 = System.out::println;
    consumer2.accept("Lambda2!");
    ```

  * 数据类型可以省略，编译器可以推断得出，称为：类型推断

    ```java
    Consumer<String> consumer1 = new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    };
    consumer1.accept("Lambda!");
    
    Consumer<String> consumer2 = (s) -> {
        System.out.println(s);
    };
    consumer2.accept("Lambda2!");
    ```

  * lambda只需一个参数的时候，参数的小括号可以省略

    ```java
    Consumer<String> consumer2 = s -> {
        System.out.println(s);
    };
    ```

  * lambda需要两个或两个以上的参数时，多条语句，并且有返回值

    ```java
    Comparator<Integer> comparator1 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };
    int compare1 = comparator1.compare(12, 11);
    System.out.println(compare1);
    
    Comparator<Integer> comparator2 = (o1, o2) -> {
        return o1.compareTo(o2);
    };
    int compare2 = comparator2.compare(12,13);
    System.out.println(compare2)
    ```

  * lambda体只有一条语句时，return 与大括号可以省略

    ```java
    Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);
    ```

  

* lambda表达式的本质： 作为函数式接口的实例

* 接口的要求，函数式接口。

##  函数式接口

* 如果一个接口中，只声明了一个抽象方法，则这个接口就是一个函数式接口。

* @FunctionalInterface注解可以检验这个接口是否是一个函数式接口。

* 用匿名实现类表示的现在都可以用Lambda表达式来写

* java.util.function包下定义了Java8丰富的函数式接口。

  * Consumer<T> 消费型接口  有参无返回

    ```java
    @Test
    public void test1() {
        happyTime(500, money -> System.out.println("消费" + money + "元"));
    }
    
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }
    ```

    

  * Supplier<T> 供给型无参有返回

  * Function<T> 有参有返回

  * Predicate<T> 有参返回boolean 

    ```java
    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京","天津","普京","南京");
        List<String> list2 = filterString(list, s -> s.contains("京"));
        for (String s : list2) {
            System.out.println(s);
        }
    }
    
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
    ```

    
