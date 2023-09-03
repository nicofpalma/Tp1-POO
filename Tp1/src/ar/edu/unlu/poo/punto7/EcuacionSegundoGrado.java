package ar.edu.unlu.poo.punto7;

public class EcuacionSegundoGrado {
    private int a;
    private int b;
    private int c;

    private int x;

    public EcuacionSegundoGrado(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public EcuacionSegundoGrado(int a, int b, int c, int x){
        this.a = a;
        this.b = b;
        this.c = c;
        this.x = x;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public int getC(){
        return c;
    }

    public String toString(){
        String ecuacion =
                "Coeficientes:\n"
                + "a = " + a
                + "\nb = " + b
                + "\nc = " + c
                + "\n\n"
                + "Ecuación:\n"
                + "(- "+ b +" ± √(("+ b + "^2) - 4 * " + a + " * " + c + ")) / (2 * " + a +")\n";

        double discriminante = getDiscriminante();

        return getResultado(discriminante, ecuacion);
    }

    private double getDiscriminante(){
        return Math.pow(b, 2) + (-4 * a * c);
    }

    public String getY(){
        double resultadoY = ((a * Math.pow(x, 2)) + (b * x) + c);

        return  "Ecuación:\n"
                + "y = " + a + " * " + x + "^2 " + " + " + b + " * " + x + " + " + c
                + "\nResultado de y: \n"
                + "y = " + resultadoY;
    }

    private String getResultado(double discriminante, String ecuacion) {
        String resultadoX = "";
        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double x2;
        if(discriminante == 0){
            resultadoX = "x = " + x1;
        } else {
            if(discriminante < 0){
                resultadoX += "x1 = No tiene resultado en los números reales.\n" +
                        "x2 = No tiene resultado en los números reales.";
            } else {
                x2 =  (-b - Math.sqrt(discriminante)) / (2 * a);
                resultadoX = "x1 = " + x1 + "\n";
                resultadoX += "x2 = " + x2;
            }
        }
        return ecuacion +
                "\n-----------------------------\n"
                + "Resultado: \n"
                + resultadoX
                + "\n-----------------------------\n";
    }

}
