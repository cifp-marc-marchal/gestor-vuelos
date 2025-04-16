import org.gestorvuelos.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al gestor de vuelos");
        GestorVuelos gestorVuelos = new GestorVuelos();
        GestorReservas gestorReservas = new GestorReservas();
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1. Agregar vuelo");
            System.out.println("2. Consultar vuelos disponibles por día");
            System.out.println("3. Consultar vuelos disponibles por semana");
            System.out.println("4. Reservar vuelo");
            System.out.println("5. Consultar reservas de un usuario");
            System.out.println("6. Cancelar reserva");
            System.out.println("7. Crear usuario");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el identificador del vuelo: ");
                    String idVuelo = teclado.next();
                    System.out.print("Ingrese el origen del vuelo: ");
                    String origen = teclado.next();
                    System.out.print("Ingrese el destino del vuelo: ");
                    String destino = teclado.next();
                    System.out.print("Ingrese la fecha del vuelo (dd/MM/yyyy): ");
                    String fechaStr = teclado.next();
                    LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.print("Ingrese la hora del vuelo (HH:mm): ");
                    String hora = teclado.next();
                    System.out.print("Ingrese el número de asientos del vuelo: ");
                    int asientos = teclado.nextInt();
                    Vuelo vuelo = new Vuelo(idVuelo, origen, destino, fecha, hora, asientos, asientos);
                    gestorVuelos.addVuelo(vuelo);
                    break;
                case 2:
                    System.out.print("Ingrese la fecha para consultar vuelos (dd/MM/yyyy): ");
                    String fechaConsultaStr = teclado.next();
                    LocalDate fechaConsulta = LocalDate.parse(fechaConsultaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Vuelo[] vuelosDia = gestorVuelos.consultarVolsPerDia(fechaConsulta);
                    mostrarVuelos(vuelosDia);
                    break;
                case 3:
                    System.out.print("Ingrese la fecha para consultar vuelos de la semana (dd/MM/yyyy): ");
                    String fechaSemanaStr = teclado.next();
                    LocalDate fechaSemana = LocalDate.parse(fechaSemanaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Vuelo[] vuelosSemana = gestorVuelos.consultarVolsPerSetmana(fechaSemana);
                    mostrarVuelos(vuelosSemana);
                    break;
                case 4:
                    System.out.print("Ingrese el DNI del usuario: ");
                    String dniUsuario = teclado.next();
                    Usuario usuario = gestorUsuarios.getUsuario(dniUsuario);
                    if (usuario == null) {
                        System.out.println("Usuario no encontrado");
                    } else {
                        System.out.print("Ingrese el identificador del vuelo: ");
                        String idVueloReserva = teclado.next();
                        Vuelo vueloReserva = gestorVuelos.getVuelo(idVueloReserva);
                        if (vueloReserva == null) {
                            System.out.println("Vuelo no encontrado");
                        } else {
                            System.out.print("Ingrese el número de pasajeros: ");
                            int pasajeros = teclado.nextInt();
                            if (gestorReservas.ferReserva(vueloReserva, usuario, pasajeros)) {
                                System.out.println("Reserva realizada correctamente");
                            } else {
                                System.out.println("La reserva no ha podido ser realizada");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el identificador del usuario: ");
                    String idUsuario = teclado.next();
                    Usuario user = gestorUsuarios.getUsuario(idUsuario);
                    if (user == null) {
                        System.out.println("Usuario no encontrado");
                    } else {
                        Reserva[] reservas = gestorReservas.getReservesPerUsuari(user);
                        if (reservas != null && reservas.length > 0) {
                            System.out.println("Reservas del usuario:");
                            for (Reserva reserva : reservas) {
                                System.out.println("--------------------------------");
                                System.out.println(reserva.toString());
                                System.out.println("--------------------------------");
                            }
                        } else {
                            System.out.println("No hay reservas para este usuario");
                        }
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el identificador de la reserva a cancelar: ");
                    int idReservaACancelar = teclado.nextInt();
                    if (gestorReservas.cancelarReserva(idReservaACancelar, gestorVuelos)) {
                        System.out.println("Reserva cancelada correctamente");
                    } else {
                        System.out.println("No se pudo cancelar la reserva");
                    }
                    break;
                case 7:
                    System.out.print("Ingrese el DNI del nuevo usuario: ");
                    String dniNuevoUsuario = teclado.next();
                    System.out.print("Ingrese el nombre del nuevo usuario: ");
                    String nombreNuevoUsuario = teclado.next();
                    System.out.print("Ingrese el apellido1 del nuevo usuario: ");
                    String apellido1NuevoUsuario = teclado.next();
                    System.out.print("Ingrese el apellido2 del nuevo usuario: ");
                    String apellido2NuevoUsuario = teclado.next();
                    System.out.print("Ingrese el email del nuevo usuario: ");
                    String emailNuevoUsuario = teclado.next();
                    System.out.print("Ingrese la contraseña del nuevo usuario: ");
                    String passwordNuevoUsuario = teclado.next();
                    System.out.print("Ingrese el teléfono del nuevo usuario: ");
                    String telefonoNuevoUsuario = teclado.next();
                    gestorUsuarios.addUsuario(new Usuario(dniNuevoUsuario, nombreNuevoUsuario, apellido1NuevoUsuario, apellido2NuevoUsuario, emailNuevoUsuario, passwordNuevoUsuario, telefonoNuevoUsuario));
                    System.out.println("Usuario creado correctamente");
                    break;
                case 8:
                    // Salir
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 8);
    }

    private static void mostrarVuelos(Vuelo[] vuelos) {
        if (vuelos != null && vuelos.length > 0) {
            System.out.println("Vuelos disponibles:");
            for (Vuelo vuelo : vuelos) {
                System.out.println("--------------------------------");
                System.out.println(vuelo.toString());
                System.out.println("--------------------------------");
            }
        } else {
            System.out.println("No hay vuelos disponibles");
        }
    }
}