
import io.reactivex.Observable;

public class createHotObservable {
    double random = Math.random();
    public void createHotObser(){
        Observable<Double> observable = Observable.create(emitter -> {
            emitter.onNext(random);
        });
        observable.subscribe(item->{
            System.out.println(item);
        });
        observable.subscribe(item1->{
            System.out.println(item1);
        });
    }
}
