# Optional

## 创建Options对象的方法

```java
Optional.of(T t);//t非null
Optional.ofNullable(T t);//t可以为null
```

## 使用Optional避免空指针

```java
public class Girl{
    private String name;
}
public class Boy{
    private Girl girl;
}

public String getGirlName(Boy boy) {
    return boy.getGirl().getName();
}

@Test
public void test3() {
    Boy boy = new Boy();
    String girlName = getGirlName(boy);
    //会报 空指针
    System.out.println(girlName);
}
//普通的优化
public String getGirlNamePro(Boy boy) {
    if (boy != null) {
        Girl girl = boy.getGirl();
        if (girl != null) {
            return girl.getName();
        }
    }
    return null;
}

//使用Optional避免空指针
public String getGirlName2(Boy boy) {
    Optional<Boy> optionalBoy = Optional.ofNullable(boy);
    Boy boy1 = optionalBoy.orElse(new Boy());
    Girl girl = boy1.getGirl();
    Optional<Girl> optionalGirl = Optional.ofNullable(girl);
    return optionalGirl.orElse(new Girl("lining")).getName();
}

@Test
public void test4() {
    String girlName = getGirlName2(null);
    System.out.println(girlName);
}
```

## 获取Optional内的对象

```java
T get();//确定的情况
T orElse(T t);
isPresnet();//判断是否有值。
```



