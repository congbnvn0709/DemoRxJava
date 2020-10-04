import io.reactivex.Observable;

public class demoTakeWhile {
    public void demo() {
        Observable<Integer> myObservable = Observable.range(0, 10);
        myObservable.takeWhile(x -> x < 5)
                .subscribe(System.out::println);
    }
    // skipWhile like takeWhile
}
