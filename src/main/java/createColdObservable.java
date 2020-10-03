import io.reactivex.Observable;

import static java.lang.Thread.sleep;

public class createColdObservable {
    public static void createColdObser() {
        Observable<Integer> ob = Observable.just(1, 2, 3, 4, 5, 6, 9);

        ob.subscribe(item -> {
            System.out.println("item 1: " + item);
        });

        // pause(5000);

        ob.subscribe(item -> {
            System.out.println("item 2: " + item);
        });
    }

    public static void pause(int duration) {
        try {
            sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void coldRandom(){
        Observable<Double> observable = Observable.create(observer->{
            observer.onNext(Math.random());
        });
        observable.subscribe(item->{
            System.out.println(item);
        });
        observable.subscribe(item1->{
            System.out.println(item1);
        });
    }
}
