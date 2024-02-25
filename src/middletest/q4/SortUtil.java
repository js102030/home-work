package middletest.q4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortUtil {

    private SortUtil() {}

    public static <T> List<T> mergeSort(List<T> list, Comparator<T> comparator) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<T> left = new ArrayList<>(list.subList(0, mid));
        List<T> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left, comparator);
        right = mergeSort(right, comparator);

        return merge(left, right, comparator);
    }

    private static <T> List<T> merge(List<T> left, List<T> right, Comparator<T> comparator) {
        List<T> merged = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (comparator.compare(left.get(0), right.get(0)) <= 0) {
                merged.add(left.remove(0));
            } else {
                merged.add(right.remove(0));
            }
        }

        merged.addAll(left);
        merged.addAll(right);

        return merged;
    }
}