/**
 * @author : lvpeng01
 * @since : 2023/3/27
 **/
public class StackOverflow {

    public static void main(String[] args) {
        System.out.println("ready to over flow.");
        StackOverflow sof = new StackOverflow();
        sof.recursion();
    }

    public void recursion() {
        recursion();
    }

}
