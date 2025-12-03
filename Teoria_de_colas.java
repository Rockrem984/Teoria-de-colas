import java.util.Scanner;
public class Teoria_de_colas{
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);
        byte opcion = 0;
        do{
            System.out.println("\n \t Menu");
            System.out.println("1. Modelo M/M/1 ");
            System.out.println("2. Modelo M/M/2 ");
            System.out.println("3. Modelo M/M/3 ");
            System.out.println("4. Salir ");
            System.out.println("Opcion ");
            opcion = lector.nextByte();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese la tasa de llegadas: ");
                    double lambda = lector.nextDouble();
                    System.out.println("Ingrese la tasa del servicio: ");
                    double miu = lector.nextDouble();

                    double p = lambda/miu;
                    double Lq = Math.pow(lambda, 2)/(miu*(miu-lambda));
                    double Wq = Lq/lambda;
                    double W = (Wq+(1/miu));
            }

        }while (opcion!=4);
        System.out.println("Saliendo...");

    }
}