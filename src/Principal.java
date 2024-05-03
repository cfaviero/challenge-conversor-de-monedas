import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        int opcion = 0;
        double numero = 0.1;
        Monedas moneda = Monedas.USD;;
        Monedas monedaACambiar = Monedas.ARS;
        String menu = """
                ************************************************************************
                ¡Bienvenid@ al Conversor de Moneda!

                1) Dólar => Peso Argentino
                2) Peso Argentino => Dólar
                3) Dólar => Real Brasileño
                4) Real Brasileño => Dólar
                5) Dólar => Peso Colombiano
                6) Peso Colombiano => Dólar

                7) Salir del Programa

                Elija una opcion válida
                ************************************************************************
                """;
        Scanner teclado = new Scanner(System.in);
        while (opcion != 7) {
            System.out.println(menu);
            opcion = teclado.nextInt();
            ConsultaAPI consulta = new ConsultaAPI();
            switch (opcion) {
                case 1:
                    System.out.println("Dólar a Peso Argentino");
                    System.out.println("Ingrese el valor que desea convertir");
                    numero = Double.valueOf(teclado.next());
                    moneda = Monedas.USD;
                    monedaACambiar = Monedas.ARS;
                    break;

                case 2:
                    System.out.println("Peso Argentino a Dólar");
                    System.out.println("Ingrese el valor que desea convertir");
                    numero = Double.valueOf(teclado.next());
                    moneda = Monedas.ARS;
                    monedaACambiar = Monedas.USD;
                    break;

                case 3:
                    System.out.println("Dólar a Real Brasileño");
                    System.out.println("Ingrese el valor que desea convertir");
                    numero = Double.valueOf(teclado.next());
                    moneda = Monedas.USD;
                    monedaACambiar = Monedas.BRL;
                    break;

                case 4:
                    System.out.println("Real Brasileño a Dólar");
                    System.out.println("Ingrese el valor que desea convertir");
                    numero = Double.valueOf(teclado.next());
                    moneda = Monedas.BRL;
                    monedaACambiar = Monedas.USD;
                    break;

                case 5:
                    System.out.println("Dólar a Peso Colombiano");
                    System.out.println("Ingrese el valor que desea convertir");
                    numero = Double.valueOf(teclado.next());
                    moneda = Monedas.USD;
                    monedaACambiar = Monedas.COP;
                    break;

                case 6:
                    System.out.println("Peso Colombiano a Dólar");
                    System.out.println("Ingrese el valor que desea convertir");
                    numero = Double.valueOf(teclado.next());
                    moneda = Monedas.COP;
                    monedaACambiar = Monedas.USD;
                    break;

                case 7:
                    System.out.println("Cerrando el programa");
                    break;

                default:
                    System.out.println("Error al ingresar la opción, intente de nuevo");
                    System.out.println(" ");
                    System.out.println(" ");

            }

            if (opcion > 0 && opcion < 7) {
                Parametro parametro = consulta.cambioMoneda(moneda, monedaACambiar, numero);
                System.out.println("El valor " + numero + "[" + moneda + "]" + "corresponde al valor final de  ==>>  " + parametro.conversion_result() + "[" + monedaACambiar + "]");
                System.out.println(" ");
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            }
        }

    }
}
