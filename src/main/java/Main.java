import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();
        int arr[]={45,85,89,98,7868,6645,954};
        SegmentTree obj= new SegmentTree(arr);
        try{
            obj.build_tree(1, 0, arr.length - 1);
        }
        catch (Exception ex ){
            ex.toString();
        }
        var result =obj.getResult();


    }
}
