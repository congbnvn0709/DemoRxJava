import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;


public class createObservableWithFrom {
    public static void createWithFrom() {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Observable<Integer> ob = Observable.fromIterable(ls);
        ob.subscribe(item -> {
            System.out.println("list integer with from " + item);
        });
    }
}
