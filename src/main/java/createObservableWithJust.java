import io.reactivex.Observable;

public class createObservableWithJust {
    public void createWithJust() {
        //just limited by 10 argument
        Observable<Integer> ob = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ob.subscribe(item -> {
        System.out.println("List item with just " + item);
    });
    }
}
