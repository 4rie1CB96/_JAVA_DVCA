/**
 *  Crear una clase CuentaBancaria con atributos como número de cuenta y saldo. Debe tener métodos para:
        Depositar.
        Retirar.
        Consultar saldo.
  Extras: 
    Manejar que no se pueda retirar más de lo que hay.
 */

package ProyectoExtra;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class CuentaBancaria {
    private int numeroCuenta;
    private float saldo;

    public CuentaBancaria(int numeroCuenta, float saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(float monto) {
        saldo += monto;
        System.out.println("Depósito realizado.");
    }

    public void retirar(float monto) {
        if (monto > saldo) {
            System.out.println("Saldo insufieciente para retirar.");
        } else {
            saldo -= monto;
            System.out.println("Retiro realizado.");
        }
    }

    public float consultarSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
}

public class ProyectoExtra_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean flag = true;
        boolean x;
        boolean cunetaActiva = false;

        CuentaBancaria cuenta = null;
        clear();
        while (flag) {
            try {
                menu();
                int option = sc.nextInt();
                sc.nextLine();

                clear();

                switch (option) {
                    case 0 -> {
                        if (!cunetaActiva) {
                            subOpciones();
                            option = sc.nextInt();
                            sc.nextLine();

                            clear();

                            switch (option) {
                                case 1 -> {
                                    System.out.print("\nIngrese saldo inicial: ");
                                    float saldoInicial = sc.nextFloat();
                                    sc.nextLine();

                                    int numeroCuenta = rand.nextInt(1000, 9999);
                                    cuenta = new CuentaBancaria(numeroCuenta, saldoInicial);
                                    cunetaActiva = true;
                                    System.out.println("\nCuenta creada con número: " + numeroCuenta);
                                }
                                case 2 -> {
                                    int numeroCuenta = rand.nextInt(1000, 9999);
                                    cuenta = new CuentaBancaria(numeroCuenta, 0);
                                    cunetaActiva = true;
                                    System.out.println("Cuenta creada con número: " + numeroCuenta);
                                }
                            }
                        } else {
                            clear();
                            System.out.println("Ya existe una cuenta bancaria activa.");
                            System.out.println(
                                    "Numero de Cuenta [" + cuenta.getNumeroCuenta() + "]" + " con Saldo: "
                                            + String.format("%.2f", cuenta.consultarSaldo()));
                        }
                    }

                    case 1 -> {
                        x = cuentaCreada(cuenta);
                        if (x) {
                            System.out.print("\nIngrese monto a depositar: ");
                            float montoDeposito = sc.nextFloat();
                            sc.nextLine();
                            cuenta.depositar(montoDeposito);
                            System.out.println("Saldo actual: " + String.format("%.2f", cuenta.consultarSaldo()));
                        }
                    }

                    case 2 -> {
                        x = cuentaCreada(cuenta);
                        if (x) {
                            System.out.print("Ingrese monto a retirar: ");
                            float montoRetiro = sc.nextFloat();
                            sc.nextLine();
                            cuenta.retirar(montoRetiro);
                            System.out.println("Saldo actual: " + String.format("%.2f", cuenta.consultarSaldo()));
                        }
                    }
                    case 3 -> {
                        x = cuentaCreada(cuenta);
                        if (x) {
                            System.out.println("Saldo actual: " + String.format("%.2f", cuenta.consultarSaldo()));
                        }
                    }
                    case 4 -> {
                        flag = false;
                        sc.close();
                        System.out.println("Programa finalizado.");
                    }
                    default -> System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nError: opción no válida.\n");
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }

    private static void menu() {
        System.out.println("Seleccione una opción:");
        System.out.println("0. Crear cuenta bancaria");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Salir");
    }

    private static void subOpciones() {
        System.out.println("1. Con saldo inicial");
        System.out.println("2. Sin saldo inicial");
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static boolean cuentaCreada(Object cuenta) {
        if (cuenta == null) {
            clear();
            System.out.println("\nPrimero debe crear una cuenta bancaria.");
            return false;
        } else {
            return true;
        }
    }
}
