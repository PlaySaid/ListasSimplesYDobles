package presentation;

import domain.model.HistorialDoble;
import domain.model.HistorialSimple;

import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- Generador de Contraseñas --");
        Random random = new Random();

        // Crear listas de historial
        HistorialSimple historialSimple = new HistorialSimple();
        HistorialDoble historialDoble = new HistorialDoble();

        boolean continuar = true;

        while (continuar) {
            // Pide la cantidad de digitos de contraseña.
            String entrada = JOptionPane.showInputDialog(
                    "Ingresa la longitud de la contraseña (min 8 - max 50):",
                    "8"
            );

            if (entrada == null) break; // cancelar

            int longitud;

            // En caso de no ingresar un numero valido, salta un error.
            try {
                longitud = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Debes ingresar un número entero.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                continue; // vuelve a pedir la longitud
            }

            // Ventana de error al poner un numero menor que 8.
            if (longitud < 8) {
                JOptionPane.showMessageDialog(null, "La longitud debe ser mayor o igual a 8", "Error", JOptionPane.ERROR_MESSAGE);
                continue;

                // Ventana de error al poner un numero mayor que 50.
            } else if (longitud > 50) {
                JOptionPane.showMessageDialog(null, "La longitud debe ser menor o igual a 50", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Array para guardar la contraseña.
            char[] contrasena = new char[longitud];

            // Arreglos de caracteres.
            char[] mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            char[] minusculas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            char[] numeros = "0123456789".toCharArray();
            char[] simbolos = "!@#$%^&*()_+-=[]{}/|°¬'~`".toCharArray();

            // asegura un caracter de cada tipo
            contrasena[0] = mayusculas[random.nextInt(mayusculas.length)];
            contrasena[1] = minusculas[random.nextInt(minusculas.length)];
            contrasena[2] = numeros[random.nextInt(numeros.length)];
            contrasena[3] = simbolos[random.nextInt(simbolos.length)];

            // une todos los arreglos en un solo string
            String todos = new String(mayusculas) + new String(minusculas)
                    + new String(numeros) + new String(simbolos);
            char[] caracteres = todos.toCharArray();

            // completa el resto de la contraseña
            for (int i = 4; i < longitud; i++) {
                contrasena[i] = caracteres[random.nextInt(caracteres.length)];
            }

            // mezcla los caracteres para que no quede predecible
            for (int i = 0; i < contrasena.length; i++) {
                int j = random.nextInt(contrasena.length);
                char temp = contrasena[i];
                contrasena[i] = contrasena[j];
                contrasena[j] = temp;
            }

            String contrasenaFinal = new String(contrasena);

            // mostrar la contraseña generada
            JOptionPane.showMessageDialog(null, "Contraseña generada:\n"
                    + contrasenaFinal, "Exito", JOptionPane.INFORMATION_MESSAGE);

            // guardar en los historiales
            historialSimple.addLast(contrasenaFinal);
            historialDoble.addLast(contrasenaFinal);

            // preguntar si quiere generar otra contraseña
            int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres tu generar otra contraseña?", "Continuar",
                    JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) continuar = false;
        }

        // mostrar historiales en consola
        System.out.println("=== Historial Simple ===");
        historialSimple.printList();

        System.out.println("\n=== Historial Doble (Hacia adelante) ===");
        historialDoble.printListForward();

        System.out.println("\n=== Historial Doble (Hacia atrás) ===");
        historialDoble.printListBackward();
    }
}
