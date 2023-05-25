/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project01;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        String search;
        do {
            choice = 0;
            try {
                System.out.println("1.Them san pham.");
                System.out.println("2.Chinh sua san pham bang pCode. ");
                System.out.println("3.Xoa san pham bang pCode.");
                System.out.println("4.Xap xep san pham theo ten.");
                System.out.println("5.Xap xep san pham theo pPrice.");
                System.out.println("6.Hien thi danh sach san pham.");
                System.out.println("7.Luu danh sach san pham ra file product.txt.");
                System.out.println("8.Doc noi dung file va hien thi product.txt.");
                System.out.println("9.Thoat");
                System.out.print("Chon : ");
                choice = sc.nextInt();
                sc.nextLine();
                System.out.println("-------------------------------------");
                switch (choice) {
                    case 1:
                        addProduct(products);
                        break;
                    case 2:
                        System.out.print("Nhap ma cua san pham muon sua :");
                        search = sc.nextLine();
                        searchNchange(products, search);
                        break;
                    case 3:
                        System.out.print("Nhap ma cua san pham muon xoa :");
                        search = sc.nextLine();
                        searchNdel(products, search);
                        break;
                    case 4:
                        sortByName(products);
                        break;
                    case 5:
                        sortByPrice(products);
                        break;
                    case 6:
                        show(products);
                        break;
                    case 7:
                        writeFile(products);
                        break;
                    case 8:
                        readFile(products);
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Khong hop le, nhap lai");
                        System.out.println("-------------------------------------");
                }
            } catch (Exception e) {
                System.out.println("Khong hop le, nhap lai");
                System.out.println("-------------------------------------");
                sc.nextLine();
            }
        } while (choice != 9);
    }

    static void addProduct(ArrayList<Product> products) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap code san pham : ");
        String pCode = checkString();
        System.out.print("Nhap ten san pham : ");
        String pName = checkString();
        System.out.print("Nhap gia san pham : ");
        int pPrice = checkNumber();
        products.add(new Product(pCode, pName, pPrice));
        System.out.println("Them san pham thanh cong !");
        System.out.println("-------------------------------------");
    }

    static void show(ArrayList<Product> products) {
        System.out.printf("%-15s%-20s%-10s\n", "Code", "Name", "Price");
        for (Product p : products) {
            System.out.printf("%-15s%-20s%-10d\n", p.getpCode(), p.getpName(), p.getpPrice());
        }
        System.out.println("-------------------------------------");
    }

    static void searchNdel(ArrayList<Product> products, String search) {
        Scanner sc = new Scanner(System.in);
        boolean temp = false;
        for (Product p : products) {
            if (search.equalsIgnoreCase(p.getpCode())) {
                temp = true;
                System.out.print("Da tim thay san pham! nhap 'y' de xoa :");
                String s = sc.next();
                if (s.equalsIgnoreCase("y")) {
                    products.remove(p);
                    System.out.println("Xoa " + p.getpCode() + " thanh cong!");
                    break;
                }
                break;
            }
        }
        if (!temp) {
            System.out.println("Khong tim thay san pham!");
        }
        System.out.println("-------------------------------------");
    }

    static void searchNchange(ArrayList<Product> products, String search) {
        Scanner sc = new Scanner(System.in);
        boolean temp = false;
        for (Product p : products) {
            if (search.equalsIgnoreCase(p.getpCode())) {
                temp = true;
                System.out.println("Da tim thay san pham \npCode :" + p.getpCode() + "\npName:" + p.getpName() + "\npPrice:" + p.getpPrice());
                System.out.print("Nhap pCode:");
                String pcode = checkString();
                p.setpCode(pcode);
                System.out.print("Nhap pName:");
                String pname = checkString();
                p.setpName(pname);
                System.out.print("Nhap pPrice:");
                int pprice = checkNumber();
                p.setpPrice(pprice);
                System.out.println("Thay doi thanh cong");
                break;
            }
        }
        if (!temp) {
            System.out.println("Khong tim thay san pham!");
        }
        System.out.println("-------------------------------------");
    }

    static void sortByName(ArrayList<Product> products) {
//        ArrayList<Product> pSort = new ArrayList<>();
//        pSort.addAll(products);
        Comparator<Product> priceComparator = (Product p1, Product p2) -> {
            char c1 = p1.getpName().charAt(0);
            char c2 = p2.getpName().charAt(0);
            return Character.compare(c1, c2);
        };

        Collections.sort(products, priceComparator);
        show(products);
    }

    static void sortByPrice(ArrayList<Product> products) {
        //ArrayList<Product> pSort = new ArrayList<>();
        //pSort.addAll(products);
        Comparator<Product> priceComparator = (Product p1, Product p2) -> {
            if (p1.getpPrice() < p2.getpPrice()) {
                return 1;
            } else if (p1.getpPrice() > p2.getpPrice()) {
                return -1;
            } else {
                return 0;
            }
        };

        Collections.sort(products, priceComparator);
        show(products);
    }

    static int checkNumber() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int number;
                number = sc.nextInt();
                if(number < 0){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.print("Khong hop le, nhap lai :");
                sc.nextLine();
            }
        }
    }
    
    static String checkString(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String s;
                s = sc.nextLine();
                if(s.length() == 0){
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.out.print("Khong duoc de trong!, nhap lai :");
            }
        }
    }
    static void writeFile(ArrayList<Product> products) {
        try {
            PrintWriter pw = new PrintWriter("D:/Java_Core/project01/products.txt", "UTF-8");
            for (Product p : products) {
                pw.printf("%-15s%-20s%-10d\n", p.getpCode(), p.getpName(), p.getpPrice());
            }
            System.out.println("Add file thanh cong!!");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void readFile(ArrayList<Product> products) {
        products.clear();
        try {
            File file = new File("D:/Java_Core/project01/products.txt");
            Scanner sc = new Scanner(file, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] fields = line.split("\\s{2,}+");
                String pCode = fields[0];
                String pName = fields[1];
                int pPrice = Integer.parseInt(fields[2]);
                products.add(new Product(pCode, pName, pPrice));
            }
            System.out.println("Doc file thanh cong!!");
            sc.close();
            show(products);
        } catch (Exception e) {
            System.out.println("Khong the doc duoc file");
            e.printStackTrace();
        }
    }
}
