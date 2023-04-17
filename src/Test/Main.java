package Test;

import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

import Controller.MainController;

public class Main {
	Scanner scan;
	MainController cller;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.cller = new MainController();
		main.scan = new Scanner(System.in);
		main.menu();
	}
	
	public void menu() {
		int key;
		do {
			System.out.println("===================== MENU =====================");
			System.out.println("1.Nhap sinh vien.");
			System.out.println("2.Tao lop moi.");
			System.out.println("3.Xoa sinh vien.");
			System.out.println("4.Xoa lop.");
			System.out.println("5.Danh sach sinh vien theo lop.");
			System.out.println("6.Danh sach tong.");
			System.out.println("0.Thoat.");
			System.out.println("===================== END =====================");
			System.out.print("Nhap lua chon: ");
			key = scan.nextInt();
			switch (key) {
			case 1: 
				cller.cllerInsertStudent();
				break;
			case 2:
				cller.cllerInsertClassRoom();
				break;
			case 3:
				cller.cllerDeleteStudent();
				break;
			case 4:
				cller.cllerDeleteClassRoom();
				break;
			case 5:
				cller.cllerShowListByTenLop();
				break;
			case 6:
				cller.cllerShowAllList();
				break;
			default:
				break;
			}
		}while(key !=0);
	}
}
