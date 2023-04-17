package Controller;

import java.util.Scanner;

import Entity.ClassRoom;
import Entity.Student;
import Repository.Repository;
import Service.ServiceImpl.ClassRoomServiceImpl;
import Service.ServiceImpl.StudentServiceImpl;

public class MainController {
	ClassRoom listStudent;
	StudentServiceImpl sd_service;
	ClassRoomServiceImpl lcr_service;
	Repository repository;
	Scanner scan = new Scanner(System.in);
	
	public MainController() {
		sd_service = new StudentServiceImpl();
		lcr_service = new ClassRoomServiceImpl();
	}
	
	public void cllerInsertClassRoom() {
		System.out.println("===================== Hay nhap loi dung duoi day =====================");
		System.out.print("Nhap ten lop : ");
		String tenLop = scan.nextLine();
		boolean check = lcr_service.insertClassRoom(tenLop);
		if(check)
			System.out.println("Insert success!");
		else
			System.err.println("Insert err!");
	}
	
	public void cllerDeleteClassRoom() {
		System.out.println("===================== Hay nhap loi dung duoi day =====================");
		System.out.print("Nhap ten lop : ");
		String tenLop = scan.nextLine();
		boolean check = lcr_service.deleteClassRoom(tenLop);
		if(check)
			System.out.println("Delete success!");
		else
			System.err.println("Delete err!");
	}
	
	public void cllerInsertStudent() {
		System.out.println("===================== Hay nhap loi dung duoi day =====================");
		System.out.print("Nhap ten lop muon then hoc sinh: ");
		String tenLop = scan.nextLine();
		boolean check_lopexist = lcr_service.findClassRoom(tenLop);
		if(check_lopexist) {
			System.out.print("Ho va ten: ");
			String hoTen = scan.nextLine();
			System.out.print("Id: ");
			Long idStudent = scan.nextLong();
			System.out.print("Diem trung binh: ");
			float diemTrungBinh = scan.nextFloat();
			String hocLuc = sd_service.xepHocLuc(diemTrungBinh);
			Student student = new Student(hoTen, idStudent, diemTrungBinh, hocLuc);
			boolean check = lcr_service.insertStudentIntoClassRoom(student, tenLop);
			if(check)
				System.out.println("Insert success!");
			else
				System.err.println("Insert err!");
		}else {
			System.err.println("Lop khong ton tai!");
		}
		
	}
	
	public void cllerDeleteStudent() {
		System.out.println("===================== Hay nhap loi dung duoi day =====================");
		System.out.print("Nhap ten lop muon then hoc sinh: ");
		String tenLop = scan.nextLine();
		System.out.print("ID: ");
		Long idStudent = scan.nextLong();
		boolean check = lcr_service.deleteStudent(idStudent, tenLop);
		if(check)
			System.out.println("Delete success!");
		else
			System.err.println("Delete err!");
	}
	
	public void cllerShowListByTenLop() {
		System.out.println("===================== Hay nhap loi dung duoi day =====================");
		System.out.print("Nhap ten lop muon xem danh sach hoc sinh: ");
		String tenLop = scan.nextLine();
		if(lcr_service.findClassRoom(tenLop)) 
			lcr_service.showClassRoomByName(tenLop);
		else
			System.err.println("List is empty!");
		
	}
	
	public void cllerShowAllList() {
		if(lcr_service.getRepository().getListClassRoom().isEmpty())
			System.err.println("Empty!");
		else
			lcr_service.getRepository().showAllList();
	}
}
