/* 機位:
   學號:411631327
   姓名:邱振營
*/
import java.util.Random;

public class Fin2 {

    public static void main(String[] args)  {
        Random random = new Random();
        Shape[] arr = new Shape[3];
        arr[0] = new Square("411", 5);
        arr[1] = new Cube("631", 2);
        arr[2] = new Square("327", random.nextInt(4) + 1);
        Shape max = arr[0];
        for(Shape arrs: arr){
            System.out.println(arrs.toString());
            if(arrs instanceof Square)
                ((Square) arrs).enlarge(2);
        }
        for(Shape arrs: arr){
            if(arrs instanceof Square)
                System.out.println(((Square) arrs).toString() + " area = " + ((Square) arrs).getArea());
        }
        for(Shape arrs: arr){
            if(arrs instanceof Cube)
                System.out.println(((Cube) arrs).toString() + " area = " + ((Cube) arrs).getArea() + " vol = " + ((Cube) arrs).getVol());
        }
        System.out.println("面積最大：");
        for(Shape arrs: arr){
            if(arrs.compareTo(max) == 1){
                max = arrs;
            }
        }
        System.out.println(max.toString());
        
    }
}
interface Area{
    double getArea();
}
abstract class Shape implements Comparable<Shape>, Area{
    @Override
    public int compareTo(Shape other){
        if(this.getArea() > other.getArea())
            return 1;
        else if(this.getArea() < other.getArea())
            return -1;
        else 
            return 0;
    }
}
abstract class TwoD extends Shape{
    private String name;
    public TwoD(String n){
        this.name = n;
    }
    @Override
    public String toString(){
        return "TwoD name = " + this.name;
    }
}
class Square extends TwoD{
    private double length;
    public Square(String n, double len){
        super(n);
        this.length = len;
    }
    public void enlarge(double d){
        this.length = this.length * d;
    }
    @Override
    public String toString(){
        return super.toString() + " length = " + length;
    }
    public double getArea(){
        return this.length * this.length;
    }
}
abstract class ThreeD extends Shape{
    private String id;
    public ThreeD(String i){
        this.id = i;
    }
    @Override
    public String toString(){
        return "ThreeD id= " + this.id;
    }
    abstract public double getVol();
}
class Cube extends ThreeD{
    private double length;
    public Cube(String i, double len){
        super(i);
        this.length = len;
    }
    @Override
    public String toString(){
        return super.toString() + " length = " + this.length;
    }
    public double getArea(){
        return 6 * this.length * this.length;
    }
    public double getVol(){
        return this.length * this.length * this.length;
    }
}