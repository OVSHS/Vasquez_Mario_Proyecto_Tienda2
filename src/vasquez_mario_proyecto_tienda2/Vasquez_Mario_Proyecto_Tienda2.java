/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vasquez_mario_proyecto_tienda2;

import java.util.Scanner;

/**
 *
 * @author TYT
 */
public class Vasquez_Mario_Proyecto_Tienda2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" Tienda de productos ");
        Scanner lea = new Scanner(System.in);

        // Variables para manejar el dinero en caja y opciones del menú
        double cajatotal = 0;
        int menu = 0;
        int opcion = 0;
        // Variables para ventas
        int cobroventas = 0;
        int tempfacturaAzucar = 0;
        int tempfacturaMaiz = 0;
        int tempfacturaAvena = 0;
        int tempfacturaTrigo = 0;
        // Variables para manejar el inventario de productos
        int stockazucar = 0, stockavena = 0, stocktrigo = 0, stockmaiz = 0;
        int facturaAvena = 0, facturaAzucar = 0, facturaTrigo = 0, facturaMaiz = 0;
        // Variable para la cantidad vendida en cada venta
        int cantidadventa = 0;
        // Variables para manejar totales y reportes
        double pagototal = 0;
        double mayorventa = 0;
        double mayorcompra = 0;
        int contadordeventa = 0;
        int contadorcompras = 0;
        int montodeproveedor = 0;
        int subtotalazucar = 0, subtotalavena = 0, subtotaltrigo = 0, subtotalmaiz = 0;
        String productoMayorVenta = "";
        double cantidadmayorventa = 0;  // Cambiado a double para reflejar el dinero generado por la venta
        String productomayorgasto = "";
        double gastomayorcompra = 0;  // Cambiado a double para reflejar el dinero gastado en la compra
        // Variables para reportes de volumen de ventas y compras
        double volumen_ventas = 0, volumen_compras = 0, valorcomopra = 0, valorventas = 0;
        double totalefectivoganado = 0;
        // Variables para identificar el producto más vendido
        String productoestrella = "";
        String puesto1 = "", puesto2 = "", puesto3 = "", puesto4 = "", puesto5 = "";
        // Nombres de productos
        String producto1 = "Azucar", producto2 = "Avena", producto3 = "Trigo", producto4 = "Maiz";
        double sobrante = 0;

        while (menu != 6) {
            System.out.println("\nMenu principal ");
            System.out.println("1 Abrir Caja");
            System.out.println("2 Ventas");
            System.out.println("3 Compras");
            System.out.println("4 Reportes");
            System.out.println("5 Cierre De Caja ");
            System.out.println("6 Salir del Sistema");
            System.out.print("\nElija una de las siguientes opciones: ");
            opcion = lea.nextInt();

            // Se valida para que el usuario ingrese una opcion correcta
                while (opcion < 1 || opcion > 6) {
                      System.out.println("Opcion no valida, por favor intentelo de nuevo");
                      System.out.print("Elija una de las siguientes opciones: ");
                      opcion = lea.nextInt();
                  }

                  if (opcion == 1) {
                      System.out.println("Ingrese la cantidad de dinero que desea almacenar:");
                      double dinero = lea.nextDouble();
                      cajatotal += dinero;
                      System.out.println("En la caja hay: " + cajatotal);
                  }

                  if (opcion == 2) {
                      if (cajatotal == 0) {
                          System.out.println("Por favor abra caja primero");
                      } else {
                          if (stockazucar <= 0 && stockavena <= 0 && stocktrigo <= 0 && stockmaiz <= 0) {
                              System.out.println("-------------------------------------------------------------------------|");
                              System.out.println("No hay inventario para vender, por favor ingresar a compras");
                              System.out.println("-------------------------------------------------------------------------|");
                          } else {
                              int ventas = 0;
                              cobroventas = 0;
                              tempfacturaAzucar = 0;
                              tempfacturaMaiz = 0;
                              tempfacturaAvena = 0;
                              tempfacturaTrigo = 0;

                              double impuesto = 0, descuento = 0, subtotal = 0;
                              int usuario = 0;

                              while (ventas == 0) {
                                  System.out.println(" Articulos " +
                                          "\n Codigo  " + " Producto " + " Precio Venta " + " Precio Compra" +
                                          "\n   1 " + "      Azucar" + "      Lps. 30 " + "  Lps. 25" +
                                          "\n   2 " + "       Avena" + "           25 " + "       20,22" +
                                          "\n   3 " + "       Trigo" + "           32 " + "       30" +
                                          "\n   4 " + "        Maiz" + "           20 " + "       19");
                                  System.out.println("Ingrese tipo de cliente (A, B, C):");
                                  String cliente = lea.next().toUpperCase();

                                  while (!(cliente.equals("A") || cliente.equals("B") || cliente.equals("C"))) {
                                      System.out.println("Tipo de cliente incorrecto. Inténtelo nuevamente");
                                      cliente = lea.next().toUpperCase();
                                  }

                                  switch (cliente) {
                                      case "A":
                                          while (usuario == 0) {
                                              System.out.println("===== Cliente Tipo A===== ");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("Codigo       | Productos | Venta                    | ");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("    1        |  Azucar    | Lps 30 ");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("    2        |  Avena     | Lps 25");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("    3        |  Trigo     | Lps 32");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("    4        |  Maiz      | Lps 20");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("Ingrese el numero de los articulos que desea comprar");
                                              String codigoproducto = lea.next();

                                              while (!(codigoproducto.equals("1") || codigoproducto.equals("2") || codigoproducto.equals("3") || codigoproducto.equals("4"))) {
                                                  System.out.println("Codigo de producto no valido. Intente nuevamente.");
                                                  codigoproducto = lea.next();
                                              }
                                              if (codigoproducto.equals("1")) {
                                                  System.out.println("Actualmente con azucar tenemos: " + stockazucar);
                                                  System.out.println("Ingrese la cantidad que desea comprar: ");
                                                  cantidadventa = lea.nextInt();
                                                  while (cantidadventa < 0) {
                                                      System.out.println("Solo puede ingresar numeros positivos");
                                                      System.out.println("Ingrese la cantidad que desea comprar ");
                                                      cantidadventa = lea.nextInt();
                                                  }
                                                  if (cantidadventa <= stockazucar) {
                                                      stockazucar = stockazucar - cantidadventa;
                                                      cobroventas = cantidadventa * 30;
                                                      tempfacturaAzucar += cantidadventa;
                                                      facturaAzucar += cantidadventa;
                                                  } else {
                                                      System.out.println("No hay suficiente Stock para vender");
                                                  }
                                              }
                                              if (codigoproducto.equals("2")) {
                                                  System.out.println("Actualmente con avena tenemos: " + stockavena);
                                                  System.out.println("Ingrese la cantidad que desea comprar: ");
                                                  cantidadventa = lea.nextInt();
                                                  while (cantidadventa < 0) {
                                                      System.out.println("Solo puede ingresar numeros positivos");
                                                      System.out.println("Ingrese la cantidad que desea comprar ");
                                                      cantidadventa = lea.nextInt();
                                                  }
                                                  if (cantidadventa <= stockavena) {
                                                      stockavena = stockavena - cantidadventa;
                                                      cobroventas = cantidadventa * 25;
                                                      tempfacturaAvena += cantidadventa;
                                                      facturaAvena += cantidadventa;
                                                  } else {
                                                      System.out.println("No hay suficiente Stock para vender");
                                                  }
                                              }
                                              if (codigoproducto.equals("3")) {
                                                  System.out.println("Actualmente con Trigo tenemos: " + stocktrigo);
                                                  System.out.println("Ingrese la cantidad que desea comprar: ");
                                                  cantidadventa = lea.nextInt();
                                                  while (cantidadventa < 0) {
                                                      System.out.println("Solo puede ingresar numeros positivos");
                                                      System.out.println("Ingrese la cantidad que desea comprar ");
                                                      cantidadventa = lea.nextInt();
                                                  }
                                                  if (cantidadventa <= stocktrigo) {
                                                      stocktrigo = stocktrigo - cantidadventa;
                                                      cobroventas = cantidadventa * 32;
                                                      tempfacturaTrigo += cantidadventa;
                                                      facturaTrigo += cantidadventa;
                                                  } else {
                                                      System.out.println("No hay suficiente Stock para vender");
                                                  }
                                              }
                                              if (codigoproducto.equals("4")) {
                                                  System.out.println("Actualmente con Maiz tenemos: " + stockmaiz);
                                                  System.out.println("Ingrese la cantidad que desea comprar: ");
                                                  cantidadventa = lea.nextInt();
                                                  while (cantidadventa < 0) {
                                                      System.out.println("Solo puede ingresar numeros positivos");
                                                      System.out.println("Ingrese la cantidad que desea comprar ");
                                                      cantidadventa = lea.nextInt();
                                                  }
                                                  if (cantidadventa <= stockmaiz) {
                                                      stockmaiz = stockmaiz - cantidadventa;
                                                      cobroventas = cantidadventa * 20;
                                                      tempfacturaMaiz += cantidadventa;
                                                      facturaMaiz += cantidadventa;
                                                  } else {
                                                      System.out.println("No hay suficiente Stock para vender");
                                                  }
                                              }
                                              System.out.println("Desea continuar comprando? (SI o NO)");
                                              String desicion = lea.next().toUpperCase();
                                              if (desicion.equals("NO")) {
                                                  usuario = 1;
                                                  ventas = 1;
                                              }
                                          }
                                          break;

                                      case "B":

                                          while (usuario == 0) {
                                              System.out.println("===== Cliente Tipo B===== ");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("Codigo       | Productos | Venta                    | ");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("    1        |  Azucar    | Lps 30 ");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("    2        |  Avena     | Lps 25");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("    3        |  Trigo     | Lps 32");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("Ingrese el numero del articulo que desea comprar");
                                              String codigoproducto = lea.next();

                                              while (!(codigoproducto.equals("1") || codigoproducto.equals("2") || codigoproducto.equals("3"))) {
                                                  System.out.println("Codigo de producto no valido. Intente nuevamente.");
                                                  codigoproducto = lea.next();
                                              }
                                              if (codigoproducto.equals("1")) {
                                                  System.out.println("Actualmente con azucar tenemos: " + stockazucar);
                                                  System.out.println("Ingrese la cantidad que desea comprar: ");
                                                  cantidadventa = lea.nextInt();

                                                  while (cantidadventa <= 0) {
                                                      System.out.println("Solo puede ingresar numeros positivos");
                                                      System.out.println("Ingrese la cantidad que desea comprar ");
                                                      cantidadventa = lea.nextInt();
                                                  }
                                                  if (cantidadventa <= stockazucar) {
                                                      stockazucar = stockazucar - cantidadventa;
                                                      cobroventas = cantidadventa * 30;
                                                      tempfacturaAzucar += cantidadventa;
                                                      facturaAzucar += cantidadventa;
                                                  } else {
                                                      System.out.println("No hay suficiente Stock para vender");
                                                  }
                                              }
                                              if (codigoproducto.equals("2")) {
                                                  System.out.println("Actualmente con avena tenemos: " + stockavena);
                                                  System.out.println("Ingrese la cantidad que desea comprar: ");
                                                  cantidadventa = lea.nextInt();
                                                  while (cantidadventa <= 0) {
                                                      System.out.println("Solo puede ingresar numeros positivos");
                                                      System.out.println("Ingrese la cantidad que desea comprar ");
                                                      cantidadventa = lea.nextInt();
                                                  }
                                                  if (cantidadventa <= stockavena) {
                                                      stockavena = stockavena - cantidadventa;
                                                      cobroventas = cantidadventa * 25;
                                                      tempfacturaAvena += cantidadventa;
                                                      facturaAvena += cantidadventa;
                                                  } else {
                                                      System.out.println("No hay suficiente Stock para vender");
                                                  }
                                              }
                                              if (codigoproducto.equals("3")) {
                                                  System.out.println("Actualmente con Trigo tenemos: " + stocktrigo);
                                                  System.out.println("Ingrese la cantidad que desea comprar: ");
                                                  cantidadventa = lea.nextInt();

                                                  while (cantidadventa <= 0) {
                                                      System.out.println("Solo puede ingresar numeros positivos");
                                                      System.out.println("Ingrese la cantidad que desea comprar ");
                                                      cantidadventa = lea.nextInt();
                                                  }
                                                  if (cantidadventa <= stocktrigo) {
                                                      stocktrigo = stocktrigo - cantidadventa;
                                                      cobroventas = cantidadventa * 32;
                                                      tempfacturaTrigo += cantidadventa;
                                                      facturaTrigo += cantidadventa;
                                                  } else {
                                                      System.out.println("No hay suficiente Stock para vender");
                                                  }
                                              }
                                              System.out.println("Desea continuar comprando? (SI o NO)");
                                              String desicion = lea.next().toUpperCase();
                                              if (desicion.equals("NO")) {
                                                  usuario = 1;
                                                  ventas = 1;
                                              }
                                          }
                                          break;

                                      case "C":

                                          while (usuario == 0) {
                                              System.out.println("===== Cliente Tipo C===== ");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("Codigo       | Productos | Venta                    | ");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("    4        |  Maiz      | Lps 20");
                                              System.out.println("-------------------------------------------------------|");
                                              System.out.println("Ingrese el codigo del articulos que desea comprar");
                                              String codigoproducto = lea.next();
                                              while (!codigoproducto.equals("4")) {
                                                  System.out.println("Codigo de producto no valido. Intente nuevamente.");
                                                  codigoproducto = lea.next();
                                              }
                                              if (codigoproducto.equals("4")) {
                                                  System.out.println("Actualmente con Maiz tenemos: " + stockmaiz);
                                                  System.out.println("Ingrese la cantidad que desea comprar: ");
                                                  cantidadventa = lea.nextInt();
                                                  while (cantidadventa <= 0) {
                                                      System.out.println("Solo puede ingresar numeros positivos");
                                                      System.out.println("Ingrese la cantidad que desea comprar ");
                                                      cantidadventa = lea.nextInt();
                                                  }
                                                  if (cantidadventa <= stockmaiz) {
                                                      stockmaiz = stockmaiz - cantidadventa;  
                                                      cobroventas = cantidadventa * 20;  
                                                      tempfacturaMaiz += cantidadventa;  
                                                      facturaMaiz += cantidadventa;  
                                                  } else {
                                                      System.out.println("No hay suficiente Stock para vender");
                                                  }
                                              }
                                              System.out.println("Desea continuar comprando? (SI o NO)");
                                              String desicion = lea.next().toUpperCase();
                                              if (desicion.equals("NO")) {
                                                  usuario = 1;
                                                  ventas = 1;
                                              }
                                          }
                                          break;
                                          //Descuento
                                  }
                                  subtotal = tempfacturaAvena * 25 + tempfacturaAzucar * 30 + tempfacturaTrigo * 32 + tempfacturaMaiz * 20;
                                  if (subtotal >= 1000 && subtotal < 5000) {
                                      descuento = subtotal * 0.05;
                                  } else if (subtotal >= 5000) {
                                      descuento = subtotal * 0.10;
                                  }
                                  impuesto = subtotal * 0.07;
                                  pagototal = subtotal - descuento + impuesto;

                                  volumen_ventas += pagototal;  // Se acumula el volumen total de ventas
                                  cajatotal += pagototal;

                                  if (pagototal > mayorventa) {
                                      mayorventa = pagototal;
                                  }
                                  if (tempfacturaAzucar > 0) {
                                      productoMayorVenta = "Azucar";
                                      cantidadmayorventa = tempfacturaAzucar * 30;
                                  } else if (tempfacturaAvena > 0) {
                                      productoMayorVenta = "Avena";
                                      cantidadmayorventa = tempfacturaAvena * 25;
                                  } else if (tempfacturaTrigo > 0) {
                                      productoMayorVenta = "Trigo";
                                      cantidadmayorventa = tempfacturaTrigo * 32;
                                  } else if (tempfacturaMaiz > 0) {
                                      productoMayorVenta = "Maiz";
                                      cantidadmayorventa = tempfacturaMaiz * 20;
                                  }

                                  System.out.println("==============================Factura=================================");
                                  System.out.println(" Cantidad en kg|   Nombre del producto   | Precio Unitario | Subtotal|");
                                  if (tempfacturaAzucar >= 1) {
                                      System.out.println("     " + tempfacturaAzucar + "kg      |          Azucar         |        30       |   " + 30 * tempfacturaAzucar + "    |");
                                  }
                                  if (tempfacturaAvena >= 1) {
                                      System.out.println("     " + tempfacturaAvena + "kg      |          Avena          |        25       |   " + 25 * tempfacturaAvena + "    |");
                                  }
                                  if (tempfacturaTrigo >= 1) {
                                      System.out.println("     " + tempfacturaTrigo + "kg      |          Trigo          |        32       |   " + 32 * tempfacturaTrigo + "    |");
                                  }
                                  if (tempfacturaMaiz >= 1) {
                                      System.out.println("     " + tempfacturaMaiz + "kg      |          Maiz           |        20       |   " + 20 * tempfacturaMaiz + "    |");
                                  }

                                  System.out.printf("======================================================================");
                                  System.out.printf("\nSubtotal: %.2f Lps%n", subtotal);
                                  System.out.printf("Descuento: %.2f Lps%n", descuento);
                                  System.out.printf("Impuesto: %.2f Lps%n", impuesto);
                                  System.out.printf("Total a pagar: %.2f Lps%n", pagototal);

                                  contadordeventa++;
                              }
                          }
                      }
                  }
                  if (opcion == 3) {
                      if (cajatotal == 0) {
                          System.out.println("Por favor abra caja primero");
                      } else {
                          System.out.println("===== Inventario=====");
                          System.out.println("-------------------------------------------------------|");
                          System.out.println("Codigo       | Productos  | Inventario                    | ");
                          System.out.println("-------------------------------------------------------|");
                          System.out.println("    1        |  Azucar    | " + stockazucar + "kg");
                          System.out.println("-------------------------------------------------------|");
                          System.out.println("    2        |  Avena     | " + stockavena + "kg");
                          System.out.println("-------------------------------------------------------|");
                          System.out.println("    3        |  Trigo     | " + stocktrigo + "kg");
                          System.out.println("-------------------------------------------------------|");
                          System.out.println("    4        |  Maiz      | " + stockmaiz + "kg");
                          System.out.println("-------------------------------------------------------|");

                          System.out.println("Ingrese tipo de comprador(A,B,C)");
                          String comprador = lea.next().toUpperCase();

                          while (!(comprador.equals("A") || comprador.equals("B") || comprador.equals("C"))) {
                              System.out.println("Tipo de comprador incorrecto, intentelo nuevamente");
                              comprador = lea.next().toUpperCase();
                          }

                          switch (comprador) {
                              case "A":
                                  System.out.println("===== Comprador Tipo A===== ");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("Codigo       | Productos | Venta                    | ");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("    1        |  Azucar    | Lps 25 ");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("    4        |  Maiz      | Lps 18");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("Ingrese el codigo a comprar:  ");
                                  String codigoproducto = lea.next().toUpperCase();
                                  while (!(codigoproducto.equals("1") || codigoproducto.equals("4"))) {
                                      System.out.println("Codigo de producto incorrecto, intente nuevamente");
                                      codigoproducto = lea.next();
                                  }
                                  if (codigoproducto.equals("1")) {
                                      System.out.println("Ingrese la cantidad de Azucar a comprar: ");
                                      int cantidad = lea.nextInt();
                                      montodeproveedor = cantidad * 25;

                                      if (montodeproveedor > cajatotal) {
                                          System.out.println("-------------------------------------------");
                                          System.out.println("No hay suficiente dinero en caja");
                                          System.out.println("-------------------------------------------");
                                          System.out.println("Cantidad en caja: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("La cantidad que falto para realizar la compra fue: " + (montodeproveedor - cajatotal));
                                          System.out.println("-------------------------------------------");
                                      } else {
                                          stockazucar += cantidad;
                                          cajatotal -= montodeproveedor;
                                          volumen_compras += montodeproveedor; // Se acumula el volumen total de compras
                                          System.out.println("-------------------------------------------");
                                          System.out.println("El total de su compra fue: " + montodeproveedor);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("En la caja ahora hay: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                          if(montodeproveedor > mayorcompra){ 
                                           mayorcompra = montodeproveedor;
                                           productomayorgasto = "Azucar";
                                           gastomayorcompra = montodeproveedor;                                            
                                           }
                                      }

                                  } else if (codigoproducto.equals("4")) {
                                      System.out.println("Ingrese la de Maiz cantidad a comprar: ");
                                      int cantidad = lea.nextInt();
                                      montodeproveedor = cantidad * 18;
                                      if(montodeproveedor > mayorcompra){ 
                                        mayorcompra = montodeproveedor;
                                       }

                                      if (montodeproveedor > cajatotal) {
                                          System.out.println("-------------------------------------------");
                                          System.out.println("No hay suficiente dinero en caja");
                                          System.out.println("-------------------------------------------");
                                          System.out.println("Cantidad en caja: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("La cantidad que falto para realizar la compra fue: " + (montodeproveedor - cajatotal));
                                          System.out.println("-------------------------------------------");
                                      } else {
                                          stockmaiz += cantidad;
                                          cajatotal -= montodeproveedor;
                                          volumen_compras += montodeproveedor; // Se acumula el volumen total de compras
                                          System.out.println("-------------------------------------------");
                                          System.out.println("El total de su compra fue: " + montodeproveedor);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("En la caja ahora hay: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                           if(montodeproveedor > mayorcompra){ 
                                           mayorcompra = montodeproveedor;
                                           productomayorgasto = "Maiz";
                                           gastomayorcompra = montodeproveedor;                                            
                                           }
                                      }
                                  }
                                  contadorcompras++;
                                  break;

                              case "B":
                                  System.out.println("===== Comprador Tipo B===== ");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("Codigo       | Productos | Venta                    | ");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("    2        |  Avena     | Lps 20");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("    3        |  Trigo     | Lps 30");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("Ingrese el codigo a comprar");
                                  codigoproducto = lea.next().toUpperCase();
                                  while (!(codigoproducto.equals("2") || codigoproducto.equals("3"))) {
                                      System.out.println("Codigo de producto no valido, intente nuevamente");
                                      codigoproducto = lea.next();
                                  }
                                  if (codigoproducto.equals("2")) {
                                      System.out.println("Ingrese la cantidad de Avena a comprar: ");
                                      int cantidad = lea.nextInt();
                                      montodeproveedor = cantidad * 20;
                                      if(montodeproveedor > mayorcompra){ 
                                       mayorcompra = montodeproveedor;
                                      }
                                      if (montodeproveedor > cajatotal) {
                                          System.out.println("-------------------------------------------");
                                          System.out.println("No hay suficiente dinero en caja");
                                          System.out.println("-------------------------------------------");
                                          System.out.println("Cantidad en caja: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("La cantidad que falto para realizar la compra fue: " + (montodeproveedor - cajatotal));
                                          System.out.println("-------------------------------------------");
                                      } else {
                                          stockavena += cantidad;
                                          cajatotal -= montodeproveedor;
                                          volumen_compras += montodeproveedor; // Se acumula el volumen total de compras
                                          System.out.println("-------------------------------------------");
                                          System.out.println("El total de su compra fue: " + montodeproveedor);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("En la caja ahora hay: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                           if(montodeproveedor > mayorcompra){ 
                                           mayorcompra = montodeproveedor;
                                           productomayorgasto = "Avena";
                                           gastomayorcompra = cantidad;                                            
                                           }
                                      }
                                  } else if (codigoproducto.equals("3")) {
                                      System.out.println("Ingrese la cantidad de Trigo a comprar: ");
                                      int cantidad = lea.nextInt();
                                      montodeproveedor = cantidad * 30;
                                      if(montodeproveedor > mayorcompra){ 
                                           mayorcompra = montodeproveedor;
                                      }
                                      if (montodeproveedor > cajatotal) {
                                          System.out.println("-------------------------------------------");
                                          System.out.println("No hay suficiente dinero en caja");
                                          System.out.println("-------------------------------------------");
                                          System.out.println("Cantidad en caja: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("La cantidad que falto para realizar la compra fue: " + (montodeproveedor - cajatotal));
                                          System.out.println("-------------------------------------------");
                                      } else {
                                          stocktrigo += cantidad;
                                          cajatotal -= montodeproveedor;
                                          volumen_compras += montodeproveedor; // Se acumula el volumen total de compras
                                          System.out.println("-------------------------------------------");
                                          System.out.println("El total de su compra fue: " + montodeproveedor);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("En la caja ahora hay: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                           if(montodeproveedor > mayorcompra){ 
                                           mayorcompra = montodeproveedor;
                                           productomayorgasto = "Trigo";
                                           gastomayorcompra = montodeproveedor;                                            
                                           }
                                      }
                                  }
                                  contadorcompras++;
                                  break;

                              case "C":

                                  System.out.println("===== Comprador Tipo C===== ");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("Codigo       | Productos | Venta                    | ");
                                  System.out.println("-------------------------------------------------------|");
                                  System.out.println("    2        |  Avena     | Lps 22");
                                  System.out.println("-------------------------------------------------------|");
                                  codigoproducto = lea.next().toUpperCase();
                                  while (!codigoproducto.equals("2")) {
                                      System.out.println("Codigo de producto no valido. Intente nuevamente.");
                                      codigoproducto = lea.next();
                                  }
                                  if (codigoproducto.equals("2")) {
                                      System.out.println("Ingrese la cantidad de Avena a comprar: ");
                                      int cantidad = lea.nextInt();
                                      montodeproveedor = cantidad * 22;
                                      if(montodeproveedor > mayorcompra){ 
                                           mayorcompra = montodeproveedor;
                                      }
                                      if (montodeproveedor > cajatotal) {
                                          System.out.println("-------------------------------------------");
                                          System.out.println("No hay suficiente dinero en caja");
                                          System.out.println("-------------------------------------------");
                                          System.out.println("Cantidad en caja: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("La cantidad que falto para realizar la compra fue: " + (montodeproveedor - cajatotal));
                                          System.out.println("-------------------------------------------");
                                      } else {
                                          stockavena += cantidad;
                                          cajatotal -= montodeproveedor;
                                          volumen_compras += montodeproveedor; // Se acumula el volumen total de compras
                                          System.out.println("-------------------------------------------");
                                          System.out.println("El total de su compra fue: " + montodeproveedor);
                                          System.out.println("-------------------------------------------");
                                          System.out.println("En la caja ahora hay: " + cajatotal);
                                          System.out.println("-------------------------------------------");
                                           if(montodeproveedor > mayorcompra){ 
                                           mayorcompra = montodeproveedor;
                                           productomayorgasto = "Avena";
                                           gastomayorcompra = montodeproveedor;                                            
                                           }
                                      }
                                  }
                                  contadorcompras++;
                                  break;
                          }
                      }
                  }
                  if (opcion == 4) {
                      int facturacion = 0;
                      if (cajatotal == 0) {
                          System.out.println("Por favor abra caja primero");
                      } else {
                          System.out.println("=====================REPORTES=========================");
                          subtotaltrigo += stocktrigo;
                          subtotalavena += stockavena;
                          subtotalazucar += stockazucar;
                          subtotalmaiz += stockmaiz;
                          totalefectivoganado = volumen_ventas - volumen_compras;
                          System.out.println("-------------------------------------------------------");
                          System.out.printf("Cantidad Actual que hay en la Caja: %.2f Lps%n", cajatotal);
                          System.out.println("--------------------------------------------------------");
                          System.out.println("Numero de compras: " + contadorcompras + " | Ventas Realizadas: " + contadordeventa);
                          System.out.println("--------------------------------------------------------");
                          System.out.printf("Volumen total de Compras: %.2f Lps%n", volumen_compras);
                          System.out.println("--------------------------------------------------------");
                          System.out.printf("Volumen total de Ventas efectuadas antes del cierre: %.2f Lps%n", volumen_ventas);
                          System.out.println("--------------------------------------------------------");
                          System.out.printf("Margen de Ganancia: %.2f Lps%n", totalefectivoganado);
                          System.out.println("--------------------------------------------------------");
                          double promedioCompras = 0;
                          if (contadorcompras > 0) {
                              promedioCompras = volumen_compras / contadorcompras;
                          }
                          double promedioVentas = 0;
                          if (contadordeventa > 0) {
                              promedioVentas = volumen_ventas / contadordeventa;
                          }
                          System.out.printf("Promedio de Compras: %.2f Lps%n", promedioCompras);
                          System.out.printf("Promedio de Ventas: %.2f Lps%n", promedioVentas);
                          System.out.println("--------------------------------------------------------");
                          System.out.println("El producto con mayor la mayor venta realizada es: " + productoMayorVenta + " con una cantidad de: "+cantidadmayorventa );
                          System.out.println("El producto con el mayor gasto efectuada es: " + productomayorgasto + " con una cantidad de: "+gastomayorcompra );
                          System.out.println("--------------------------------------------------------");
                          if (facturaAzucar >= facturaAvena && facturaAzucar >= facturaTrigo && facturaAzucar >= facturaMaiz) {
                              productoestrella = "Azucar";
                          } else if (facturaAvena >= facturaAzucar && facturaAvena >= facturaTrigo && facturaAvena >= facturaMaiz) {
                              productoestrella = "Avena";
                          } else if (facturaTrigo >= facturaAzucar && facturaTrigo >= facturaAvena && facturaTrigo >= facturaMaiz) {
                              productoestrella = "Trigo";
                          } else if (facturaMaiz >= facturaAzucar && facturaMaiz >= facturaAvena && facturaMaiz >= facturaTrigo) {
                              productoestrella = "Maiz";
                          }
                          System.out.println("El producto estrella es: " + productoestrella);
                          if (facturaAzucar >= facturaAvena && facturaAzucar >= facturaTrigo && facturaAzucar >= facturaMaiz) {
                              puesto1 = "Azucar";
                              if (facturaAvena >= facturaTrigo && facturaAvena >= facturaMaiz) {
                                  puesto2 = "Avena";
                                  if (facturaTrigo >= facturaMaiz) {
                                      puesto3 = "Trigo";
                                      puesto4 = "Maiz";
                                  } else {
                                      puesto3 = "Maiz";
                                      puesto4 = "Trigo";
                                  }
                              } else if (facturaTrigo >= facturaAvena && facturaTrigo >= facturaMaiz) {
                                  puesto2 = "Trigo";
                                  if (facturaAvena >= facturaMaiz) {
                                      puesto3 = "Avena";
                                      puesto4 = "Maiz";
                                  } else {
                                      puesto3 = "Maiz";
                                      puesto4 = "Avena";
                                  }
                              } else {
                                  puesto2 = "Maiz";
                                  if (facturaAvena >= facturaTrigo) {
                                      puesto3 = "Avena";
                                      puesto4 = "Trigo";
                                  } else {
                                      puesto3 = "Trigo";
                                      puesto4 = "Avena";
                                  }
                              }
                          } else if (facturaAvena >= facturaAzucar && facturaAvena >= facturaTrigo && facturaAvena >= facturaMaiz) {
                              puesto1 = "Avena";
                              if (facturaAzucar >= facturaTrigo && facturaAzucar >= facturaMaiz) {
                                  puesto2 = "Azucar";
                                  if (facturaTrigo >= facturaMaiz) {
                                      puesto3 = "Trigo";
                                      puesto4 = "Maiz";
                                  } else {
                                      puesto3 = "Maiz";
                                      puesto4 = "Trigo";
                                  }
                              } else if (facturaTrigo >= facturaAzucar && facturaTrigo >= facturaMaiz) {
                                  puesto2 = "Trigo";
                                  if (facturaAzucar >= facturaMaiz) {
                                      puesto3 = "Azucar";
                                      puesto4 = "Maiz";
                                  } else {
                                      puesto3 = "Maiz";
                                      puesto4 = "Azucar";
                                  }
                              } else {
                                  puesto2 = "Maiz";
                                  if (facturaAzucar >= facturaTrigo) {
                                      puesto3 = "Azucar";
                                      puesto4 = "Trigo";
                                  } else {
                                      puesto3 = "Trigo";
                                      puesto4 = "Azucar";
                                  }
                              }
                          } else if (facturaTrigo >= facturaAzucar && facturaTrigo >= facturaAvena && facturaTrigo >= facturaMaiz) {
                              puesto1 = "Trigo";
                              if (facturaAzucar >= facturaAvena && facturaAzucar >= facturaMaiz) {
                                  puesto2 = "Azucar";
                                  if (facturaAvena >= facturaMaiz) {
                                      puesto3 = "Avena";
                                      puesto4 = "Maiz";
                                  } else {
                                      puesto3 = "Maiz";
                                      puesto4 = "Avena";
                                  }
                              } else if (facturaAvena >= facturaAzucar && facturaAvena >= facturaMaiz) {
                                  puesto2 = "Avena";
                                  if (facturaAzucar >= facturaMaiz) {
                                      puesto3 = "Azucar";
                                      puesto4 = "Maiz";
                                  } else {
                                      puesto3 = "Maiz";
                                      puesto4 = "Azucar";
                                  }
                              } else {
                                  puesto2 = "Maiz";
                                  if (facturaAzucar >= facturaAvena) {
                                      puesto3 = "Azucar";
                                      puesto4 = "Avena";
                                  } else {
                                      puesto3 = "Avena";
                                      puesto4 = "Azucar";
                                  }
                              }
                          } else if (facturaMaiz >= facturaAzucar && facturaMaiz >= facturaAvena && facturaMaiz >= facturaTrigo) {
                              puesto1 = "Maiz";
                              if (facturaAzucar >= facturaAvena && facturaAzucar >= facturaTrigo) {
                                  puesto2 = "Azucar";
                                  if (facturaAvena >= facturaTrigo) {
                                      puesto3 = "Avena";
                                      puesto4 = "Trigo";
                                  } else {
                                      puesto3 = "Trigo";
                                      puesto4 = "Avena";
                                  }
                              } else if (facturaAvena >= facturaAzucar && facturaAvena >= facturaTrigo) {
                                  puesto2 = "Avena";
                                  if (facturaAzucar >= facturaTrigo) {
                                      puesto3 = "Azucar";
                                      puesto4 = "Trigo";
                                  } else {
                                      puesto3 = "Trigo";
                                      puesto4 = "Azucar";
                                  }
                              } else {
                                  puesto2 = "Trigo";
                                  if (facturaAzucar >= facturaAvena) {
                                      puesto3 = "Azucar";
                                      puesto4 = "Avena";
                                  } else {
                                      puesto3 = "Avena";
                                      puesto4 = "Azucar";
                                  }
                              }
                          }
                          System.out.println("=========RANKING=============");
                          System.out.println("-------------------------------------------------");
                          System.out.println("El producto que mas se ah vendido es: " + puesto1);
                          System.out.println("-------------------------------------------------");
                          System.out.println("El segundo producto mas vendido es: " + puesto2);
                          System.out.println("-------------------------------------------------");
                          System.out.println("El tercer producto mas vendido es: " + puesto3);
                          System.out.println("-------------------------------------------------");
                          System.out.println("El cuarto producto mas vendido es: " + puesto4);
                          System.out.println("-------------------------------------------------");
                      }
                  }
                  if (opcion == 5) {
                      if (cajatotal == 0) {
                          System.out.println("La caja no se puede cerrar si no se ha abierto aun");
                      } else {
                          System.out.println("-----------------------------------------------------------------------------------------------------------------");
                          System.out.printf("La ganacia que hubo es de: %.2f Lps%n", totalefectivoganado);
                          System.out.println("-----------------------------------------------------------------------------------------------------------------");
                          System.out.println("Cantidad en caja: " + cajatotal);
                          System.out.println("-----------------------------------------------------------------------------------------------------------------");
                          System.out.println("Ingrese la cantidad de efectivo que desea depositar en el respectivo banco (No puede ser mas del 60%)");
                          double depositobanco = lea.nextDouble();
                          double maxdeposito = cajatotal * 0.6;
                          if (depositobanco <= 0) {
                              System.out.println("Ingresar esa cantidad no es permitido, vuelva a intentarlo");
                          } else if (depositobanco > maxdeposito) {
                              System.out.println("Ingrese una cantidad valida");
                              System.out.println("La cantidad maxima a depositar es: " + maxdeposito);
                              depositobanco = lea.nextDouble();
                          } else {
                              sobrante = cajatotal - depositobanco;
                              cajatotal = sobrante;
                              System.out.println("-----------------------------------------------------------------------------------------------------------------");
                              System.out.println("La cantidad que hay en la caja es: " + sobrante);
                              System.out.println("La caja ha sido cerrada, ya no se pueden realizar compras o ventas");
                              System.out.println("-----------------------------------------------------------------------------------------------------------------");
                              facturaAvena = 0;
                              facturaAzucar = 0;
                              facturaTrigo = 0;
                              facturaMaiz = 0;
                              cantidadventa = 0;
                              pagototal = 0;
                              mayorventa = 0;
                              mayorcompra = 0;
                              contadordeventa = 0;
                              contadorcompras = 0;
                              montodeproveedor = 0;
                              subtotalazucar = 0;
                              subtotalavena = 0;
                              subtotaltrigo = 0;
                              subtotalmaiz = 0;
                              volumen_ventas = 0;
                              volumen_compras = 0;
                              totalefectivoganado = 0;
                              productoestrella = "";
                              puesto1 = "";
                              puesto2 = "";
                              puesto3 = "";
                              puesto4 = "";
                              puesto5 = "";
                              producto1 = "Azucar";
                              producto2 = "Avena";
                              producto3 = "Trigo";
                              producto4 = "Maiz";
                          }
                      }
                  }
              }
           }
          }