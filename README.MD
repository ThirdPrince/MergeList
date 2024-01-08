# 合并两个List并去重的方法总结

## 方法一：使用 HashSet

```
public static List<Integer> method01ByHashSet(List<Integer> l1, List<Integer> l2){
    List<Integer> all = new ArrayList();
    all.addAll(l1);
    all.addAll(l2);
    Set<Integer> set = new HashSet<>(all);
    List<Integer> result = new ArrayList<>(set);
    return result;
}
```
通过将两个List合并为一个新的List。
利用 HashSet 的唯一性去重。
将去重后的元素重新放入一个 ArrayList 中返回。
## 方法二：使用 Stream API
```
public static List<Integer> method02ByStream(List<Integer> l1, List<Integer> l2){
    Stream<Integer> stream1 = l1.stream();
    Stream<Integer> stream2 = l2.stream();
    List<Integer> result = Stream.concat(stream1, stream2)
                                 .distinct()
                                 .collect(Collectors.toList());
    return result;
}
```
使用 Java 8 引入的 Stream API。
通过 concat 方法将两个 List 的 Stream 连接。
使用 distinct 方法去除重复元素。
通过 collect 方法转回 List。
方法三：使用 Map 和 Collectors.toMap

```
public static List<Integer> method03ByMap(List<Integer> l1, List<Integer> l2){
    List<Integer> listAll = new ArrayList<>(l1);
    listAll.addAll(l2);
    Map<Integer, Integer> map = listAll.stream()
                                      .collect(Collectors.toMap(Integer::intValue, Function.identity(), (first, second) -> second));
    return new ArrayList<>(map.keySet());
}
```
使用 Collectors.toMap 将 List 的元素转为 Map 的键，实现自动去重。
将 Map 的键转为 List 返回。
这三种方法都是有效的，具体选择取决于项目需求和个人偏好。确保项目环境支持 Java 8 特性，以选择合适的方法。












