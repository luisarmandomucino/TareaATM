package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        double saldo = 10000.00;
        int intentosInvalidos = 0;
        ArrayList<String> movimientos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones del cajero:");
            System.out.println("1) Retirar dinero");
            System.out.println("2) Hacer depósitos");
            System.out.println("3) Consultar saldo");
            System.out.println("4) Quejas");
            System.out.println("5) Ver últimos movimientos");
            System.out.println("6) Transferir a cuenta BBVA");
            System.out.println("9) Salir del cajero");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("Saldo disponible: $" + saldo);
                System.out.println("Ingrese la cantidad a retirar (múltiplo de $50): ");
                double montoRetiro = scanner.nextDouble();
                if (montoRetiro % 50 == 0 && montoRetiro <= 6000 && montoRetiro <= saldo) {
                    saldo -= montoRetiro;
                    movimientos.add("Retiro de $" + montoRetiro);
                    System.out.println("¿Desea donar $200 para la graduación de ch30? (Sí/No)");
                    String donacion = scanner.next().toLowerCase();
                    if (donacion.equals("si")) {
                        saldo -= 200.00;
                        System.out.println("Gracias por tu donación.");
                    }
                } else {
                    System.out.println("Monto de retiro no válido.");
                }
            } else if (opcion == 2) {
                System.out.println("Seleccione una opción de depósito:");
                System.out.println("1) Cuenta de cheques");
                System.out.println("2) Tarjeta de Crédito");
                int opcionDeposito = scanner.nextInt();
                if (opcionDeposito == 1) {
                    System.out.println("Ingrese la cantidad a depositar en cuenta de cheques (múltiplo de $50): ");
                    double depositoCheques = scanner.nextDouble();
                    if (depositoCheques % 50 == 0) {
                        saldo += depositoCheques;
                        movimientos.add("Depósito a cuenta de cheques de $" + depositoCheques);
                        System.out.println("Depósito realizado con éxito.");
                    } else {
                        System.out.println("Monto de depósito no válido.");
                    }
                } else if (opcionDeposito == 2) {
                    System.out.println("Ingrese la cantidad a depositar en Tarjeta de Crédito:");
                    double depositoTC = scanner.nextDouble();
                    saldo -= depositoTC;
                    movimientos.add("Depósito a Tarjeta de Crédito de $" + depositoTC);
                    System.out.println("Depósito realizado con éxito.");
                } else {
                    System.out.println("Opción de depósito no válida.");
                }
            } else if (opcion == 3) {
                System.out.println("Saldo disponible: $" + saldo);
            } else if (opcion == 4) {
                System.out.println("No disponible por el momento, intente más tarde.");
            } else if (opcion == 5) {
                System.out.println("Últimos movimientos:");
                for (String movimiento : movimientos) {
                    System.out.println(movimiento);
                }
            } else if (opcion == 6) {
                System.out.println("¿Desea transferir todo su saldo disponible a su cuenta BBVA? (Sí/No)");
                String transferenciaBBVA = scanner.next().toLowerCase();
                if (transferenciaBBVA.equals("si")) {
                    System.out.println("TRANSACCION EXITOSA FOLIO 666");
                    saldo = 0.00; // Transferir todo el saldo
                    movimientos.add("Transferencia a cuenta BBVA de todo el saldo");
                } else {
                    System.out.println("NI MODO");
                }
            } else if (opcion == 9) {
                System.out.println("Gracias por utilizar nuestro cajero automático, hasta luego!");
                System.exit(0);
            } else {
                System.out.println("Opción inválida, por favor, vuelva a intentar.");
                intentosInvalidos++;
                if (intentosInvalidos >= 3) {
                    System.out.println("Demasiados intentos inválidos. Saliendo del cajero automático.");
                    System.exit(0);
                }
            }
        }
    }
}




	
