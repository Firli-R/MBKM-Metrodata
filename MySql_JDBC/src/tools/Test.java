/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.RegionDAO;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Region;

/**
 *
 * @author DevidBa
 */
public class Test {

    public static void tampilMenu() {
        System.out.println("==============================");
        System.out.println("1.Region\n"
                + "2.Country\n"
                + "3.Location\n"
                + "4.Departement\n"
                + "5.Job\n"
                + "6.Employee"
                );
        System.out.println("==============================");
        System.out.println("Masukaan Menu yang anda pilih:");
    }

    public static void main(String[] args) {
        OperasiCRUD run = new OperasiCRUD();

        String ulg = "y";
        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        while (ulg.equals("y")) {
            tampilMenu();
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1: {
                    run.operasiRegion();
                    System.out.print("Apakah anda ingin mengulang (y/t)? ");
                    ulg = input.next();
                    break;
                }
                case 2: {
                    run.operasiCountry();
                    System.out.print("Apakah anda ingin mengulang (y/t)? ");
                    ulg = input.next();
                    break;
                }
                case 3: {
                    run.operasiLocation();
                    System.out.print("Apakah anda ingin mengulang (y/t)? ");
                    ulg = input.next();
                    break;
                }
                case 4: {
                    run.operasiDepartment();
                    System.out.print("Apakah anda ingin mengulang (y/t)? ");
                    ulg = input.next();
                    break;
                }
                case 5: {
                    run.operasiJob();
                    System.out.print("Apakah anda ingin mengulang (y/t)? ");
                    ulg = input.next();
                    break;
                }
                case 6: {
                    run.operationEmployee();
                    System.out.print("Apakah anda ingin mengulang (y/t)? ");
                    ulg = input.next();
                    break;
                }
            }

        }

    }
}
