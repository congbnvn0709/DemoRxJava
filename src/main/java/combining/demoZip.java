package combining;

import io.reactivex.Observable;

public class demoZip {
    public void zip(){
        Observable<String> firstNames = Observable.just("chu manh cong", "tran xuan vu", "khac viet");
        Observable<Integer> lastNames = Observable.just(5454878, 1564545, 549498);
        firstNames.zipWith(lastNames, (first, last) -> first + " " + last)
                .subscribe(item -> System.out.println(item));
    }
}
