import java.util.Scanner;
public class Teoria_de_colas{
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);
        byte opcion = 0;
        do{
            System.out.println("\n \t Menu");
            System.out.println("1. Modelo M/M/1 ");
            System.out.println("2. Modelo M/M/1/K ");
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
                    System.out.println("Ingrese la tasa de lleggadas: ");
                    double lambda2 = lector.nextDouble();
                    System.out.println("Ingrese la tasa de servicio: ");
                    double miu2=lector.nextDouble();
                    System.out.println("Ingrese la caacidad del sistema: ");
                    int K=lector.nextInt();

                    if(K<=0){
                        System.out.println("Error: K debe ser mayor que 0");
                    }
                    double p2=lambda2/miu2;

                    double P0;
                    if(p2==1.0){
                        P0=1.0/(K+1);
                    }else{
                        P0=(1-p2)/(1-Math.pow(p2, K+1));
                    }
                    double pk=P0*Math.pow(p2, K);

                    double L;
                    if(p2==1.0){
                        L=K/2.0;
                    }else{
                      L=p2*(1-(K+1)*Math.pow(p2, K)+ K*Math.pow(p2, K+1))/((1-p2)*(1-Math.pow(p2, K+1)));  
                    }
                    double lambdaEf = lambda2*(1-pk);

                    //siguientes calculos
                    double w1=L/lambdaEf;
                    double Lq2=L-(lambdaEf/miu2);
                    double Wq2=Lq2/lambdaEf;

                    //resultados
                    System.out.println("Resultados");
                    System.out.println("Utilizacion del sistema: "+p2);
                    System.out.println("Probabilidad de que el sistema este vacio: "+P0);
                    System.out.println("Probabilidad de que el sistema este lleno: "+pk);
                    System.out.println("Numero promedio de clientes en el sistema: "+L);
                    System.out.println("Tiempo total en el sistema: "+w1);
                    break;

                case 3:
                    System.out.println("Ingrese la tasa de llegadas: ");
                    double lambda3=lector.nextDouble();
                    System.out.println("Ingrese la tasa de servicio: ");
                    double miu3=lector.nextDouble();
                    System.out.println("Ingrese el numero de servidores: ");
                    int c=lector.nextInt();

                    double p3=lambda3/(c*miu3);
                    if (p3>=1){
                    System.out.println("El sistema es inestable: ");
                    break; 
                       }
                    double suma= 0;
                    for (int n =0;n<c;n++){
                        double termino = Math.pow(lambda3/miu3, n);
                        long factorial = 1;
                        for(int i=1;i<=n;i++){
                            factorial *=i;

                        }
                        suma += termino/factorial;
                    }
                    long factorialC=1;
                    for(int i=1;i<=c;i++){
                        factorialC *=i;
                    }
                    double ultimoTermino = Math.pow(lambda3/niu3, c)/(factorialC*(1-p3));

                    double p0_c = 1.0/(suma+ultimoTermino);

                    double pC =(Math.pow(lambda3/niu3, c) / factorialC)*p0_c/(1-p3);

                    double Lq3=(pC*p3)/(1-p3);
                    double Wq3=Lq3/lambda3;
                    double W3 = Wq3+(1/miu3);
                    double L3 = lambda3*W3;



                    break;
            }

        }while (opcion!=4);
        System.out.println("Saliendo...");

    }
}