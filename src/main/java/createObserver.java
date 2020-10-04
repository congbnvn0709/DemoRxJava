import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;

public class createObserver {

    public static void createObser() {
        Observable<Integer> ob = Observable.just(10, 20, 30, 40, 50, 60);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscriber");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            // khi 1 ngoại lệ được ném ra thì onError sẽ bắt nó
            @Override
            public void onError(Throwable e) {
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        };
        ob.filter(item-> item.intValue()<50).subscribe(observer);
    }

    public void stundent() {
        List<String> lstStudent = new ArrayList<>();
        lstStudent.add("chu manh cong");
        lstStudent.add("tran phu duan");
        lstStudent.add("nguyen duc khanh");
        lstStudent.add("phan huy hoang");
        lstStudent.add("dang ngoc thanh");
        lstStudent.add("chuong chau");
        lstStudent.add("chu manh cong");
        lstStudent.add("chu manh cong");

        Observable<String> observable = Observable.create(emitter -> {
            for (String i : lstStudent) {
                emitter.onNext(i);
            }
            emitter.onComplete();
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscriber");
            }

            @Override
            public void onNext( String s) {
                System.out.println("onNext"+s);
            }

            @Override
            public void onError( Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        };
//        observable.filter(item->item.contains("chu manh cong")).subscribe(observer);
        observable.distinct().subscribe(observer);
    }
}
