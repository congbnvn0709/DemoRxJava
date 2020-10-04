import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

// su khac nhau giua map va flat-map:
// map dung de chuyen doi 1 item -> item khac

public class demoOperatorMap {
//    public List<String> getColorList() {
//        ArrayList<String> colors = new ArrayList<>();
//        colors.add("red");
//        colors.add("green");
//        colors.add("blue");
//        colors.add("pink");
//        colors.add("brown");
//        return colors;
//    }
//
//    Single<List<Integer>> listSingle = Observable.fromIterable(getColorList()).map(item -> item.length()).toList();

    public void powElement(){
        int arr[]={1,2,3,4,6};
//        Observable<Integer> observable = Observable.fromArray(arr).map(i).toList();
    }
}
