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
                    System.out.println("Ingrese la tasa de llegadas (λ): ");
                    double lambda = lector.nextDouble();
                    System.out.println("Ingrese la tasa del servicio (μ): ");
                    double miu = lector.nextDouble();

                    double p = lambda/miu;
                    double Lq = Math.pow(lambda, 2)/(miu*(miu-lambda));
                    double Wq = Lq/lambda;
                    double W = (Wq+(1/miu));

                    System.out.println("Resultados");
                    System.out.println("Utilizacion de sistema (P): "+ p);
                    System.out.println("Numero promedio de clientes en el sistema (Lq): "+Lq);
                    System.out.println("Tiempo de promedio de espera en la cola (Wq): "+Wq);
                    System.out.println("Tiempo total en el sistema (W): "+W);
                    break;

                    case 2:

                    break;

                    case 3:

                    break;
            }

        }while (opcion!=4);
        System.out.println("Saliendo...");

    }
}