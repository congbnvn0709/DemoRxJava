import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;


public class createObservableWithFrom {
    // skip nguoc voi take:
    // skip bo qua n muc dau tien duoc phat ra boi observable
    // from: chuyen 1 so object or data structure sang Observable
    public static void createWithFrom() {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Observable<Integer> ob = Observable.fromIterable(ls);
        ob.skip(2).subscribe(item -> {
            System.out.println("list integer with from " + item);
        });
    }
}
