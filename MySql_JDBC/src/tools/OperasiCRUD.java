/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.CountryDAO;
import daos.DepartmentDAO;
import daos.EmployeeDAO;
import daos.JobDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import models.Country;
import models.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;

/**
 *
 * @author Firli
 */
public class OperasiCRUD {

    public void menuCRUD() {
        System.out.println("==============================");
        System.out.println("1.Show Data\n"
                + "2.Insert\n"
                + "3.Update\n"
                + "4.Delete\n"
                + "5.Kembali");
        System.out.println("Masukkaan pilihan yang anda pilih:");
    }

    public void operasiRegion() {
        DbConnection koneksi = new DbConnection();
        RegionDAO rdao = new RegionDAO(koneksi.getConncetion());

        System.out.println("============Region============");
        for (Region region : rdao.getAll()) {
            System.out.println(" id:" + region.getRegionId() + "||" + "nama:" + region.getRegionName()
                    + "||Jumlah negara:" + region.getCount());
        }

        menuCRUD();
        Scanner input = new Scanner(System.in);
        int pilihanCRUD = input.nextInt();
        switch (pilihanCRUD) {
            case 1: {
                for (Region data : rdao.getAll()) {
                    System.out.println(" id:" + data.getRegionId() + "||" + "nama:" + data.getRegionName()
                            + "||Jumlah negara:" + data.getCount());
                }
                break;
            }
            case 2: {
                int id, count = 0;
                String nama = "";
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner inputStr = new Scanner(System.in);
                    System.out.println("Masukan Id:");
                    id = input1.nextInt();
                    System.out.println("Masukan Nama Region:");
                    nama = inputStr.nextLine();
                    System.out.println("Masukan Jumlah negara:");
                    count = input2.nextInt();
                    if (id == 0) {
                        throw new IllegalArgumentException("id tidak boleh 0");
                    } else if (nama == null) {
                        throw new IllegalArgumentException("nama tidak boleh kosong");
                    }
                    Region region = new Region(id, nama, count);
                    boolean cek = rdao.insert(region);
                    if (cek) {
                        System.out.println("Data Berhasil diinput");
                        for (Region data : rdao.getAll()) {
                            System.out.println(" id:" + data.getRegionId() + "||" + "nama:" + data.getRegionName()
                                    + "||Jumlah negara:" + data.getCount());
                        }
                    } else {
                        throw new IllegalArgumentException("ID tidak boleh sama");
                    }

                } catch (NumberFormatException e) {
                    System.out.println(e);
                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }

                break;
            }
            case 3: {
                int id = 0;
                int count = 0;
                String nama = "";
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner inputStr = new Scanner(System.in);
                    System.out.println("Masukan Id data yang mau diubah:");
                    id = input1.nextInt();
                    System.out.println("Masukan Nama Region baru:");
                    nama = inputStr.nextLine();
                    System.out.println("Masukan Jumlah negara baru:");
                    count = input2.nextInt();

                    if (id == 0) {
                        throw new IllegalArgumentException("id tidak boleh 0");
                    } else if (nama == null) {
                        throw new IllegalArgumentException("nama tidak boleh kosong");
                    }
                    System.out.println("data sebelum diupdate");
                    System.out.println(rdao.getById(id));;
                    System.out.println("====================");
                    Region region = new Region(id, nama, count);
                    boolean cek = rdao.update(id, region);
                    if (cek == true) {
                        System.out.println("Data berhasil diupdate");
                        System.out.println(rdao.getById(id));;
                        System.out.println("====================");
                        for (Region data : rdao.getAll()) {
                            System.out.println(" id:" + data.getRegionId() + "||" + "nama:" + data.getRegionName()
                                    + "||Jumlah negara:" + data.getCount());
                        }
                    } else {
                        throw new IllegalArgumentException("ID tidak boleh sama");
                    }

                } catch (NumberFormatException e) {
                    System.out.println(e);
                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }

                break;
            }
            case 4: {
                int id = 0;
                try {
                    Scanner input1 = new Scanner(System.in);
                    System.out.println("Masukan Id data yang mau dihapus:");
                    id = input1.nextInt();
                    if (id == 0) {
                        throw new IllegalArgumentException("id tidak boleh 0");
                    }
                    boolean cek = rdao.delete(id);
                    if (cek == true) {
                        System.out.println("Data berhasil dihapus");
                        for (Region data : rdao.getAll()) {
                            System.out.println(" id:" + data.getRegionId() + "||" + "nama:" + data.getRegionName()
                                    + "||Jumlah negara:" + data.getCount());
                        }
                    } else {
                        System.out.println("Data kurang tepat");
                    }
                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }

                break;
            }
            case 5: {
                break;
            }
        }

    }

    public void operasiCountry() {
        DbConnection koneksi = new DbConnection();
        CountryDAO cdao = new CountryDAO(koneksi.getConncetion());
        RegionDAO rdao = new RegionDAO(koneksi.getConncetion());
        System.out.println("============Country============");
        for (Country country : cdao.getAll()) {
            System.out.println("id:" + country.getId() + "||name:" + country.getName() + "||id Region:" + country.getRegionId());
        }
        menuCRUD();
        Scanner input = new Scanner(System.in);
        int pilihanCRUD = input.nextInt();
        switch (pilihanCRUD) {
            case 1: {
                for (Country country : cdao.getAll()) {
                    System.out.println("id:" + country.getId() + "||name:" + country.getName() + "||id Region:" + country.getRegionId());
                }
                break;
            }
            case 2: {
                String id, nama = null;
                int regionId = 0;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner inputStr1 = new Scanner(System.in);
                    Scanner inputStr2 = new Scanner(System.in);
                    System.out.println("Masukan Id data :");
                    id = inputStr1.nextLine();
                    id.toUpperCase();
                    System.out.println("Masukan Nama negara:");
                    nama = inputStr2.nextLine();
                    nama.toUpperCase();
                    for (Region data : rdao.getAll()) {
                        System.out.println(" id:" + data.getRegionId() + "||" + "nama:" + data.getRegionName()
                                + "||Region ID:" + data.getCount());
                    }
                    System.out.println("Masukan id region sesuai tabel region:");
                    regionId = input1.nextInt();

                    if (id == null && nama == null) {
                        throw new IllegalArgumentException("id tidak boleh kosong");
                    } else if (id.length() >= 2) {
                        throw new IllegalArgumentException("id tidak boleh lebih dari 2");
                    } else if (regionId == 0) {
                        throw new IllegalArgumentException("id region tidak boleh kosong");
                    }

                    Country country = new Country(id, nama, regionId);
                    boolean cek = cdao.insert(country);
                    if (cek == true) {
                        System.out.println("Data berhasil di insert");
                        for (Country data : cdao.getAll()) {
                            System.out.println(" id:" + data.getId() + "||" + "nama:" + data.getName()
                                    + "||Region ID:" + data.getRegionId());
                        }
                    } else {
                        throw new IllegalArgumentException("region id harus sama pada tabel region");
                    }

                } catch (NumberFormatException e) {
                    System.out.println(e);
                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }

                break;
            }
            case 3: {
                String id, nama = null;
                int regionId = 0;

                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner inputStr1 = new Scanner(System.in);
                    Scanner inputStr2 = new Scanner(System.in);
                    System.out.println("Masukan Id data yang mau diubah :");
                    id = inputStr1.nextLine();
                    System.out.println("Masukan Nama negara yang mau diubah:");
                    nama = inputStr2.nextLine();
                    for (Region data : rdao.getAll()) {
                        System.out.println(" id:" + data.getRegionId() + "||" + "nama:" + data.getRegionName()
                                + "||Jumlah negara:" + data.getCount());
                    }
                    System.out.println("Masukan id region sesuai tabel region:");
                    regionId = input1.nextInt();

                    if (id == null && nama == null) {
                        throw new IllegalArgumentException("id tidak boleh kosong");
                    } else if (regionId == 0) {
                        throw new IllegalArgumentException("id region tidak boleh kosong");
                    }
                    System.out.println("data sebelum diupdate");
                    System.out.println(cdao.getById(id));;
                    System.out.println("====================");
                    Country country = new Country(id, nama, regionId);
                    boolean cek = cdao.update(id, country);
                    if (cek == true) {
                        System.out.println("Data berhasil di ubah");
                        System.out.println(cdao.getById(id));;
                        System.out.println("====================");
                        for (Country data : cdao.getAll()) {
                            System.out.println(" id:" + data.getId() + "||" + "nama:" + data.getName()
                                    + "||Region ID:" + data.getRegionId());
                        }
                    } else {
                        throw new IllegalArgumentException("region id harus sama pada tabel region");
                    }

                } catch (NumberFormatException e) {
                    System.out.println(e);
                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }

                break;
            }
            case 4: {
                String id = null;
                try {
                    Scanner inputStr = new Scanner(System.in);
                    System.out.println("Masukan Id data yang mau dihapus:");
                    id = inputStr.nextLine();
                    if (id == null) {
                        throw new IllegalArgumentException("id tidak boleh kosong");
                    }
                    boolean cek = cdao.delete(id);
                    if (cek == true) {
                        System.out.println("Data berhasil dihapus");
                        for (Country data : cdao.getAll()) {
                            System.out.println(" id:" + data.getId() + "||" + "nama:" + data.getName()
                                    + "||Region ID:" + data.getRegionId());
                        }
                    } else {
                        System.out.println("Data kurang tepat");
                    }
                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }

                break;
            }
            case 5: {
                break;
            }
        }
    }

    public void operasiLocation() {
        DbConnection koneksi = new DbConnection();
        LocationDAO ldao = new LocationDAO(koneksi.getConncetion());
        CountryDAO cdao = new CountryDAO(koneksi.getConncetion());
        System.out.println("============Location============");
        for (Location data : ldao.getAll()) {
            System.out.println(" id:" + data.getId()
                    + "||" + "alamat:" + data.getAddress()
                    + "||Id Country:" + data.getCountryId());
        }
        menuCRUD();
        Scanner input = new Scanner(System.in);
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1: {
                for (Location data : ldao.getAll()) {
                    System.out.println(" id:" + data.getId()
                            + "||" + "alamat:" + data.getAddress()
                            + "||Id Country:" + data.getCountryId());
                }
            }
            case 2: {
                int id = 0;
                String address, countryId = null;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner inputStr1 = new Scanner(System.in);
                    Scanner inputStr2 = new Scanner(System.in);
                    System.out.println("Masukan Id data :");
                    id = input1.nextInt();
                    System.out.println("Masukan alamat:");
                    address = inputStr1.nextLine();
                    for (Country country : cdao.getAll()) {
                        System.out.println("id:" + country.getId() + "||name:" + country.getName() + "||id Region:" + country.getRegionId());
                    }
                    System.out.println("Masukan id Country berdasarkan tabel country:");
                    countryId = inputStr2.nextLine();

                    if (id == 0) {
                        throw new IllegalArgumentException("id Location tidak boleh nul");
                    } else if (address == null && countryId == null) {
                        throw new IllegalArgumentException("address dan country id tidak boleh kosong");
                    }

                    Location location = new Location(id, address, countryId);
                    boolean cek = ldao.insert(location);
                    if (cek == true) {
                        System.out.println("Data berhasil di insert");
                        for (Location data : ldao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "alamat:" + data.getAddress()
                                    + "||Id Country:" + data.getCountryId());
                        }
                    } else {
                        throw new IllegalArgumentException("country id harus sama pada tabel country");
                    }

                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }
                break;
            }
            case 3: {
                int id = 0;
                String address, countryId = null;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner inputStr1 = new Scanner(System.in);
                    Scanner inputStr2 = new Scanner(System.in);
                    System.out.println("Masukan Id data yang ingin diubah :");
                    id = input1.nextInt();
                    System.out.println("Masukan alamat yang ingin diubah:");
                    address = inputStr1.nextLine();
                    for (Country country : cdao.getAll()) {
                        System.out.println("id:" + country.getId() + "||name:" + country.getName() + "||id Region:" + country.getRegionId());
                    }
                    System.out.println("Masukan id Country berdasarkan tabel country yang ingin diubah:");
                    countryId = inputStr2.nextLine();

                    if (id == 0) {
                        throw new IllegalArgumentException("id location tidak boleh nul");
                    } else if (address == null && countryId == null) {
                        throw new IllegalArgumentException("address dan country id tidak boleh kosong");
                    }
                    System.out.println("data sebelum diupdate");
                    System.out.println(ldao.getById(id));;
                    System.out.println("====================");

                    Location location = new Location(id, address, countryId);
                    boolean cek = ldao.update(id, location);
                    if (cek == true) {
                        System.out.println("Data berhasil di update");
                        System.out.println(ldao.getById(id));;
                        System.out.println("====================");
                        for (Location data : ldao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "alamat:" + data.getAddress()
                                    + "||Id Country:" + data.getCountryId());
                        }
                    } else {
                        throw new IllegalArgumentException("country id harus sama pada tabel country");
                    }

                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }
                break;
            }
            case 4: {
                int id = 0;
                try {
                    Scanner input1 = new Scanner(System.in);
                    System.out.println("Masukan Id data yang mau dihapus:");
                    id = input1.nextInt();
                    if (id == 0) {
                        throw new IllegalArgumentException("id tidak boleh nul");
                    }
                    boolean cek = ldao.delete(id);
                    if (cek == true) {
                        System.out.println("Data berhasil dihapus");
                        for (Location data : ldao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "alamat:" + data.getAddress()
                                    + "||Id Country:" + data.getCountryId());
                        }
                    } else {
                        System.out.println("Data kurang tepat");
                    }
                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                    System.out.println("data yang anda masukan kurang tepat");
                }
                break;
            }
            case 5: {
                break;
            }
        }
    }

    public void operasiDepartment() {
        DbConnection koneksi = new DbConnection();
        DepartmentDAO ddao = new DepartmentDAO(koneksi.getConncetion());
        LocationDAO ldao = new LocationDAO(koneksi.getConncetion());
        System.out.println("============Department============");
        for (Department data : ddao.getAll()) {
            System.out.println(" id:" + data.getId()
                    + "||" + "nama:" + data.getName()
                    + "||" + "Manager:" + data.getManager()
                    + "||location:" + data.getLocation());
        }
        menuCRUD();
        Scanner input = new Scanner(System.in);
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1: {
                System.out.println("============Department============");
                for (Department data : ddao.getAll()) {
                    System.out.println(" id:" + data.getId()
                            + "||" + "nama:" + data.getName()
                            + "||" + "Manager:" + data.getManager()
                            + "||location:" + data.getLocation());
                }
                System.out.println("============Department============");

            }
            case 2: {
                int id, manager, location = 0;
                String name = null;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);
                    Scanner inputStr1 = new Scanner(System.in);
                    System.out.println("Masukan Id data :");
                    id = input1.nextInt();
                    System.out.println("Masukan nama :");
                    name = inputStr1.nextLine();
                    System.out.println("Masukan manager berdasar id employee :");
                    manager = input2.nextInt();

                    for (Location data : ldao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "alamat:" + data.getAddress()
                                + "||Id Country:" + data.getCountryId());
                    }
                    System.out.println("Masukan id location sesuai tabel location :");
                    location = input3.nextInt();

                    if (id == 0) {
                        throw new IllegalArgumentException("id tidak boleh kosong");
                    } else if (name == null) {
                        throw new IllegalArgumentException("nama tidak boleh kosong");
                    }
                    Department department = new Department(id, name, manager, location);
                    boolean cek = ddao.insert(department);
                    if (cek) {
                        System.out.println("data berasil di input");
                        for (Department data : ddao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "nama:" + data.getName()
                                    + "||" + "Manager:" + data.getManager()
                                    + "||location:" + data.getLocation());
                        }
                    } else {
                        throw new IllegalArgumentException("id sudah ada");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("error:" + e);
                } catch (Exception e) {
                    System.out.println("error:" + e);
                }

            }
            case 3: {
                int id, manager, location = 0;
                String name = null;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);
                    Scanner inputStr1 = new Scanner(System.in);
                    System.out.println("Masukan Id data yg mau diubah :");
                    id = input1.nextInt();
                    System.out.println("Masukan nama yang mau diubah :");
                    name = inputStr1.nextLine();
                    System.out.println("Masukan manager berdasar id employee :");
                    manager = input2.nextInt();

                    for (Location data : ldao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "alamat:" + data.getAddress()
                                + "||Id Country:" + data.getCountryId());
                    }
                    System.out.println("Masukan id location sesuai tabel location :");
                    location = input3.nextInt();

                    if (id == 0) {
                        throw new IllegalArgumentException("id tidak boleh kosong");
                    } else if (name == null) {
                        throw new IllegalArgumentException("nama tidak boleh kosong");
                    }
                    System.out.println("data sebelum diupdate");
                    System.out.println(ddao.getById(id));
                    Department department = new Department(id, name, manager, location);
                    boolean cek = ddao.update(id, department);
                    if (cek) {
                        System.out.println("data berasil di ubah");
                        System.out.println(ddao.getById(id));
                        System.out.println("==================");
                        for (Department data : ddao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "nama:" + data.getName()
                                    + "||" + "Manager:" + data.getManager()
                                    + "||location:" + data.getLocation());
                        }
                    } else {
                        throw new IllegalArgumentException("id sudah ada");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("error:" + e);
                } catch (Exception e) {
                    System.out.println("error:" + e);
                }
            }
            case 4: {
                int id = 0;
                try {
                    for (Department data : ddao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "nama:" + data.getName()
                                + "||" + "Manager:" + data.getManager()
                                + "||location:" + data.getLocation());
                    }
                    Scanner input1 = new Scanner(System.in);
                    System.out.println("masukan id yang mau dihapus");
                    id = input1.nextInt();
                    if (id == 0) {
                        throw new IllegalArgumentException("id tidak boleh nul");
                    }
                    boolean cek = ddao.delete(id);
                    if (cek) {
                        System.out.println("data berhasil dihapus");
                        for (Department data : ddao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "nama:" + data.getName()
                                    + "||" + "Manager:" + data.getManager()
                                    + "||location:" + data.getLocation());
                        }
                    } else {
                        throw new IllegalArgumentException("tedapat kesalahan");

                    }

                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            case 5: {
                break;
            }
        }
    }

    public void operasiJob() {
        DbConnection koneksi = new DbConnection();
        JobDAO jdao = new JobDAO(koneksi.getConncetion());
        DepartmentDAO ddao = new DepartmentDAO(koneksi.getConncetion());
        System.out.println("============Job============");
        for (Job data : jdao.getAll()) {
            System.out.println(" id:" + data.getId()
                    + "||" + "title:" + data.getTitle()
                    + "||" + "min_salary:" + data.getMin_salary()
                    + "||max_salary:" + data.getMax_salary());
        }
        menuCRUD();
        Scanner input = new Scanner(System.in);
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1: {
                System.out.println("============Job============");
                for (Job data : jdao.getAll()) {
                    System.out.println(" id:" + data.getId()
                            + "||" + "title:" + data.getTitle()
                            + "||" + "min_salary:" + data.getMin_salary()
                            + "||max_salary:" + data.getMax_salary());
                }
                System.out.println("============Job============");
            }
            case 2: {
                String id, title;
                float min_salary, max_salary;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);
                    Scanner input4 = new Scanner(System.in);

                    System.out.println("Masukan id job");
                    id = input1.nextLine();
                    System.out.println("Masukan title job");
                    title = input2.nextLine();
                    System.out.println("Masukan min salary job");
                    min_salary = input3.nextInt();
                    System.out.println("Masukan max salary job");
                    max_salary = input4.nextInt();
                    if (id == null && title == null) {
                        throw new IllegalArgumentException("data tidak boleh null");
                    } else if (min_salary == 0 && max_salary == 0) {
                        throw new IllegalArgumentException("data tidak boleh null");
                    }
                    System.out.println("data sebelum perubahan");
                    for (Job data : jdao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "title:" + data.getTitle()
                                + "||" + "min_salary:" + data.getMin_salary()
                                + "||max_salary:" + data.getMax_salary());
                    }
                    System.out.println("========================");

                    Job job = new Job(id, title, min_salary, max_salary);
                    boolean cek = jdao.insert(job);
                    if (cek) {
                        System.out.println("data berhasil terinput");
                        for (Job data : jdao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "title:" + data.getTitle()
                                    + "||" + "min_salary:" + data.getMin_salary()
                                    + "||max_salary:" + data.getMax_salary());
                        }
                        System.out.println("========================");

                    } else {
                        throw new IllegalArgumentException("data tidak tepat");
                    }

                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                }
            }
            case 3: {
                String id, title;
                float min_salary, max_salary;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);
                    Scanner input4 = new Scanner(System.in);

                    System.out.println("Masukan id data yang mau diubah ");
                    id = input1.nextLine();
                    System.out.println("Masukan title job");
                    title = input2.nextLine();
                    System.out.println("Masukan min salary job");
                    min_salary = input3.nextInt();
                    System.out.println("Masukan max salary job");
                    max_salary = input4.nextInt();
                    if (id == null && title == null) {
                        throw new IllegalArgumentException("data tidak boleh null");
                    } else if (min_salary == 0 && max_salary == 0) {
                        throw new IllegalArgumentException("data tidak boleh null");
                    }
                    System.out.println("data sebelum perubahan");
                    System.out.println(jdao.getById(id));
                    for (Job data : jdao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "title:" + data.getTitle()
                                + "||" + "min_salary:" + data.getMin_salary()
                                + "||max_salary:" + data.getMax_salary());
                    }
                    System.out.println("========================");

                    Job job = new Job(id, title, min_salary, max_salary);
                    boolean cek = jdao.update(id, job);
                    if (cek) {
                        System.out.println("data update");
                        System.out.println(jdao.getById(id));

                        for (Job data : jdao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "title:" + data.getTitle()
                                    + "||" + "min_salary:" + data.getMin_salary()
                                    + "||max_salary:" + data.getMax_salary());
                        }
                        System.out.println("========================");

                    } else {
                        throw new IllegalArgumentException("data tidak tepat");
                    }

                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                }
            }
            case 4: {
                String id = null;
                try {
                    Scanner inputId = new Scanner(System.in);
                    System.out.println("Masukan id yang mau dihapus");
                    id = inputId.nextLine();
                    System.out.println("data sebelum di hapus");
                    if (id == null) {
                        throw new IllegalArgumentException("data tidak boleh kosong");
                    }
                    for (Job data : jdao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "title:" + data.getTitle()
                                + "||" + "min_salary:" + data.getMin_salary()
                                + "||max_salary:" + data.getMax_salary());
                    }
                    System.out.println("========================");
                    boolean cek = jdao.delete(id);
                    if (cek) {
                        System.out.println("data berhasil terhapus");
                        for (Job data : jdao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "title:" + data.getTitle()
                                    + "||" + "min_salary:" + data.getMin_salary()
                                    + "||max_salary:" + data.getMax_salary());
                        }
                        System.out.println("========================");
                    } else {
                        throw new IllegalArgumentException("terjadi kesalahan pada alur database");
                    }

                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                }

            }
            case 5: {
                break;
            }
        }

    }

    public void operationEmployee() {
        DbConnection koneksi = new DbConnection();
        DepartmentDAO ddao = new DepartmentDAO(koneksi.getConncetion());
        JobDAO jdao = new JobDAO(koneksi.getConncetion());
        EmployeeDAO edao = new EmployeeDAO(koneksi.getConncetion());
        System.out.println("============Employee============");
        for (Employee data : edao.getAll()) {
            System.out.println(" id:" + data.getId()
                    + "||" + "first_name:" + data.getFirst_name()
                    + "||" + "job:" + data.getJob()
                    + "||" + "date:" + data.getDate()
                    + "||" + "salary:" + data.getSalary()
                    + "||" + "manager:" + data.getManager()
                    + "||department:" + data.getDepartment());
        }
        menuCRUD();
        Scanner input = new Scanner(System.in);
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1: {
                for (Employee data : edao.getAll()) {
                    System.out.println(" id:" + data.getId()
                            + "||" + "first_name:" + data.getFirst_name()
                            + "||" + "job:" + data.getJob()
                            + "||" + "date:" + data.getDate()
                            + "||" + "salary:" + data.getSalary()
                            + "||" + "manager:" + data.getManager()
                            + "||department:" + data.getDepartment());
                }
            }
            case 2: {
                int id = 0;
                String first_name, job, date = null;
                float salary;
                int manager, department = 0;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);
                    Scanner input4 = new Scanner(System.in);
                    Scanner input5 = new Scanner(System.in);
                    Scanner input6 = new Scanner(System.in);
                    Scanner inputDate = new Scanner(System.in);

                    System.out.println("Masukan Id Employee");
                    id = input1.nextInt();
                    System.out.println("Masukan first name Employee");
                    first_name = input2.nextLine();
                    System.out.println("Masukan date hire Employee");
                    date = inputDate.nextLine();
                    for (Job data : jdao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "title:" + data.getTitle()
                                + "||" + "min_salary:" + data.getMin_salary()
                                + "||max_salary:" + data.getMax_salary());
                    }
                    System.out.println("========================");
                    System.out.println("Masukan id job Employee sesuai tabel job");
                    job = input3.nextLine();
                    System.out.println("Masukan salary Employee");
                    salary = input4.nextInt();
                    for (Department data : ddao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "nama:" + data.getName()
                                + "||" + "Manager:" + data.getManager()
                                + "||location:" + data.getLocation());
                    }
                    System.out.println("========================");
                    System.out.println("Masukan manager Employee sesuai tabel department");
                    manager = input5.nextInt();
                    System.out.println("Masukan id department Employee sesuai tabel department");
                    department = input6.nextInt();

                    if (id == 0 && salary == 0 && manager == 0 && department == 0) {
                        throw new IllegalArgumentException("data tidak boleh nul");
                    } else if (first_name == null && job == null) {
                        throw new IllegalArgumentException("data tidak boleh nul");
                    }
                    System.out.println("data sebelum diinput");
                    for (Employee data : edao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "first_name:" + data.getFirst_name()
                                + "||" + "job:" + data.getJob()
                                + "||" + "date:" + data.getDate()
                                + "||" + "salary:" + data.getSalary()
                                + "||" + "manager:" + data.getManager()
                                + "||department:" + data.getDepartment());
                    }
                    System.out.println("========================");

                    Employee employee = new Employee(id, first_name, job, salary, manager, department, date);
                    boolean cek = edao.insert(employee);
                    if (cek) {
                        System.out.println("data berhasil terinput");
                        for (Employee data : edao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "first_name:" + data.getFirst_name()
                                    + "||" + "job:" + data.getJob()
                                    + "||" + "date:" + data.getDate()
                                    + "||" + "salary:" + data.getSalary()
                                    + "||" + "manager:" + data.getManager()
                                    + "||department:" + data.getDepartment());
                        }
                        System.out.println("========================");

                    } else {
                        throw new IllegalArgumentException("terjadi kesalahan pada alur database");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            case 3: {
                int id = 0;
                String first_name, job, date = null;
                float salary;
                int manager, department = 0;
                try {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);
                    Scanner input4 = new Scanner(System.in);
                    Scanner input5 = new Scanner(System.in);
                    Scanner input6 = new Scanner(System.in);
                    Scanner inputDate = new Scanner(System.in);

                    System.out.println("Masukan Id yang mau diupdate Employee");
                    id = input1.nextInt();
                    System.out.println("Masukan first name Employee");
                    first_name = input2.nextLine();
                    System.out.println("Masukan date hire Employee");
                    date = inputDate.nextLine();
                    for (Job data : jdao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "title:" + data.getTitle()
                                + "||" + "min_salary:" + data.getMin_salary()
                                + "||max_salary:" + data.getMax_salary());
                    }
                    System.out.println("========================");
                    System.out.println("Masukan id job Employee sesuai tabel job");
                    job = input3.nextLine();
                    System.out.println("Masukan salary Employee");
                    salary = input4.nextInt();
                    for (Department data : ddao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "nama:" + data.getName()
                                + "||" + "Manager:" + data.getManager()
                                + "||location:" + data.getLocation());
                    }
                    System.out.println("========================");
                    System.out.println("Masukan manager Employee sesuai tabel department");
                    manager = input5.nextInt();
                    System.out.println("Masukan id department Employee sesuai tabel department");
                    department = input6.nextInt();

                    if (id == 0 && salary == 0 && manager == 0 && department == 0) {
                        throw new IllegalArgumentException("data tidak boleh nul");
                    } else if (first_name == null && job == null) {
                        throw new IllegalArgumentException("data tidak boleh nul");
                    }
                    System.out.println("data sebelum diupdate");
                    System.out.println(edao.getById(id));
                    for (Employee data : edao.getAll()) {
                        System.out.println(" id:" + data.getId()
                                + "||" + "first_name:" + data.getFirst_name()
                                + "||" + "job:" + data.getJob()
                                + "||" + "date:" + data.getDate()
                                + "||" + "salary:" + data.getSalary()
                                + "||" + "manager:" + data.getManager()
                                + "||department:" + data.getDepartment());
                    }
                    System.out.println("========================");

                    Employee employee = new Employee(id, first_name, job, salary, manager, department, date);
                    boolean cek = edao.update(id, employee);
                    if (cek) {
                        System.out.println(edao.getById(id));
                        System.out.println("data berhasil terupdate");
                        for (Employee data : edao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "first_name:" + data.getFirst_name()
                                    + "||" + "job:" + data.getJob()
                                    + "||" + "date:" + data.getDate()
                                    + "||" + "salary:" + data.getSalary()
                                    + "||" + "manager:" + data.getManager()
                                    + "||department:" + data.getDepartment());
                        }
                        System.out.println("========================");

                    } else {
                        throw new IllegalArgumentException("terjadi kesalahan pada alur database");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            case 4: {
                int id = 0;
                try {
                    Scanner inputDelete = new Scanner(System.in);
                    System.out.println("Masukan id yang ingin anda hapus");
                    id = inputDelete.nextInt();
                    if(id==0){
                        throw new IllegalArgumentException();
                    }
                    boolean cek = edao.delete(id);
                    if(cek){
                        System.out.println("data berhasil dihapus");
                         for (Employee data : edao.getAll()) {
                            System.out.println(" id:" + data.getId()
                                    + "||" + "first_name:" + data.getFirst_name()
                                    + "||" + "job:" + data.getJob()
                                    + "||" + "date:" + data.getDate()
                                    + "||" + "salary:" + data.getSalary()
                                    + "||" + "manager:" + data.getManager()
                                    + "||department:" + data.getDepartment());
                        }
                        System.out.println("========================");
                    }else{
                        throw new IllegalArgumentException("terjadi kesalahan pada alur database");
                    }
                } catch (IllegalArgumentException e) {
                }catch (Exception e) {
                }
            }
            case 5:{
                break;
            }
        }
    }

}
