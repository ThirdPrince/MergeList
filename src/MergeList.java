import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 合并两个List并去掉重复的元素
 *
 */
public class MergeList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,3,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,5,6));
        System.out.println(method01ByHashSet(list1, list2));
    }

    /**
     * 使用HashSet
     * @param l1
     * @param l2
     * @return
     */
    public static List<Integer> method01ByHashSet(List<Integer> l1, List<Integer> l2){

        List<Integer> all = new ArrayList();
        all.addAll(l1);
        all.addAll(l2);
        Set<Integer> set = new HashSet<>(all);
        List<Integer> result = new ArrayList<>(set);
        return  result;
    }

    public static List<Integer> method02ByStream(List<Integer> l1,List<Integer> l2){
        Stream<Integer> stream1 = l1.stream();
        Stream<Integer> stream2 = l2.stream();
        List result = Stream.concat(stream1,stream2).distinct().collect(Collectors.toList());
        return result;

    }

    public static List<Integer> method03ByMap(List<Integer> l1,List<Integer> l2){
        List<Integer> listAll = new ArrayList<>(l1);
        listAll.addAll(l2);
        Map<Integer,Integer> map = listAll.stream().collect(Collectors.toMap(Integer::intValue, Function.identity(),(first,second)->second));
        return new ArrayList<>(map.keySet());
    }
}
