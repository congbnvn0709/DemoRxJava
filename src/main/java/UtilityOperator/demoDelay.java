package UtilityOperator;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class demoDelay {
    public void delayAbout(){
        Observable<String>  observable = Observable.just("cong","la","mot","sinh","vien");
        observable.delay(2, TimeUnit.SECONDS);
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe( Disposable d) {
                System.out.println("onSubscriber");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        });
    }
}
