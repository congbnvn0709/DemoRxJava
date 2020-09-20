import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import javafx.animation.PauseTransition;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        //cách 1:
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                runIt();
//            }
//        });
//        Thread thread = new Thread(Main::runIt);
//        thread.run();
        createObservableWithJust();
        createObservableWithFrom();
        createObservableUsingCreate();
        createObser();
        createColdObserble();
        createHotAndConnectableObservable();
        createObservableError();
        createErrorUsingCallable();
        createObserbleUsingEmpty();
        createObserbleUsingNever();
        createObservableUsingRange();
        createObservableByDefer();
    }
    public static void createObservableWithJust() {
        // just limited by 10 argument
        Observable<Integer> ob = Observable.just(1, 2, 3, 4, 5,6,7,8,9);
        ob.subscribe(item -> {
            System.out.println("List item with just " + item);
        });
    }

    public static void createObservableWithFrom() {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Observable<Integer> ob = Observable.fromIterable(ls);
        ob.subscribe(item -> {
            System.out.println("list integer with from " + item);
        });
    }

    public static void createObservableUsingCreate() {
        Observable<Integer> ob = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(1);
            emitter.onNext(1);
            emitter.onNext(1);
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onComplete();
        });
        ob.subscribe(item ->
                        System.out.println(item),
                error -> System.out.println("error: " + error.getLocalizedMessage()),
                () -> System.out.println("completed")
        );
    }
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

    public static void createColdObserble() {
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
    // vd ve cold Observable : dữ liệu được tạo ra bên trong Observable

    //publish: convert any observable to connectibleObservable
    // ConeectableObservable can convert coldObservable to hotObservable 
    public static void createHotAndConnectableObservable() {
        Integer[] integers = {1, 2, 3, 4, 6, 8, 9};
        ConnectableObservable<Integer> observable = Observable.just(1, 2, 3, 4, 5)
                // The operator transforms it to a hot observable
                .publish();

        observable.subscribe(item -> {
            System.out.println("observer 1: " + item);
        });
        //Process the observable
        observable.connect();
    }

    public static void createObservableError() {
        // nếu sử dụng new Exception thì error bắn ra sẽ giống nhau
        Observable<Integer> ob = Observable.error(new Exception("Exception"));
        ob.subscribe(System.out::println, error -> {
            System.out.println("error hascode: " + error.hashCode());
        });
        ob.subscribe(System.out::println, error -> {
            System.out.println("error1 hascode: " + error.hashCode());
        });
    }

    public static void createErrorUsingCallable() {
        // sử dụng callable khi kết thúc 1 Exception sẽ tạo ra 1 Exception mới
        Observable ob1 = Observable.error(() -> {
            System.out.println("create new Exception");
            return new Exception(" Exception");
        });
        ob1.subscribe(System.out::println, error -> {
            System.out.println("Error using Callable " + error.hashCode());
        });
        ob1.subscribe(System.out::println, error -> {
            System.out.println("Error1 using Callable " + error.hashCode());
        });
    }
    //create an Observable that emits no items but terminates normally
    public static void createObserbleUsingEmpty(){
        Observable ob = Observable.empty();
        ob.subscribe(System.out::println,System.out::println,()->{
            System.out.println("Completed");
        });
    }
    //create an Observable that emits no items and does not terminate
    public static void createObserbleUsingNever(){
        // Observer keeps waitting for the emission so that
        Observable ob =  Observable.never();
        ob.subscribe(System.out::println,System.out::println,()->{
            System.out.println("Conpleted to run");
        });
        pause(3000);
    }
    // create Observable by các số nguyên có điểm bắt đầu và độ dài của dãy
    public static  void createObservableUsingRange(){
        Observable<Integer> ob = Observable.range(0,20).repeat(1);
        ob.subscribe(System.out::println);
    }
    static  int start=0;
    static  int count=5;
    public  static  void createObservableByDefer(){
        Observable<Integer> ob = Observable.defer(() -> {
            System.out.println("Observable is created with : "+start+"count: "+ count);
           return  Observable.range(start,count);
        });
        ob.subscribe(item->{
            System.out.println(item);
        });
        count=8;
        ob.subscribe(item->{
            System.out.println(item);
        });
    }
    public static void callable(){

}}
