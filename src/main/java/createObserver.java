import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class createObserver {

    public static void createObser() {
        Observable<Integer> ob = Observable.just(10, 20, 30, 40, 50, 60);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
            // khi 1 ngoại lệ được ném ra thì onError sẽ bắt nó
            @Override
            public void onError(Throwable e) {
                System.out.println(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        };
        ob.subscribe(observer);
    }
}
