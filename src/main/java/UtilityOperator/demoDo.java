package UtilityOperator;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class demoDo {
    public void demoDoOnNext() {
        Observable.just("A", "B", "C", "D", "E", "F")
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println("doOnNext: " + s);
                    }
                })
                .subscribe();
    }

    /* doOnSubscribe(), doOnUnSubscribe(), doOnEach()  */
    public void demoDos() {
        Observable.range(1, 5)
                .doOnEach(new Observer<Integer>() {

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Complete is called");
                    }



                    @Override
                    public void onSubscribe( Disposable d) {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onNext(Integer value) {
                        System.out.println("onNext: " + value);
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) {
                        System.out.println("onUnSubscribe is called");
                    }
                })
                .subscribe();
    }
}
