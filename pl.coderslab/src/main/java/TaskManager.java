import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class TaskManager {
    public static void main(String[] args) {
        String[] arr = {"test1","test2"};
        arr = ArrayUtils.add(arr,"test3");
        System.out.println(Arrays.toString(arr));
    }
}
