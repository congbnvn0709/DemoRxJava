package combining;

import io.reactivex.Observable;
import io.reactivex.Observer;

// ket hop nhieu observable thanh 1
public class demoMerge {
    public void merge(){
        Observable<Integer> observable = Observable.just(1,2,3,4,5)
                .mergeWith(Observable.just(6,7,8,9,10));
        observable.subscribe(item->{
            System.out.println(item);
        });
    }
//    public void mergDelay(){
//        Observable<String> observable1 = Observable.error(new IllegalArgumentException("loi o day"));
//        Observable<String> observable2 = Observable.just("Four", "Five", "Six");
//        Observable.mergeDelayError(observable1, observable2)
//                .subscribe(item -> System.out.println(item));
//    }
}
