package comp1110.homework.O01;

public class BMI {
    public String name;
    public double height;
    public double weight;
    public BMI(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public double getBMI(){
        return weight/ (height*height) ;
    }

    public String toString(){
        String output = this.name+ " is "+this.height+
                "m tall and is "+this.weight+"Kg and has a BMI of "+this.getBMI()+"Kg/m^2";
        return output;
    }


}
