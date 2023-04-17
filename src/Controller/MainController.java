package Controller;

import java.util.List;
import java.util.Scanner;

import Entity.ClassRoom;
import Entity.Student;
import Service.ClassRoomService;
import Service.StudentService;
import Service.ServiceImpl.ClassRoomServiceImpl;
import Service.ServiceImpl.Repository;
import Service.ServiceImpl.StudentServiceImpl;

public class MainController {
	ClassRoom listStudent;
	StudentService sd_service;
	ClassRoomService lsd_service;
	Repository lcr_service;
	Scanner scan = new Scanner(System.in);
	public MainController() {
		sd_service = new StudentServiceImpl();
		lsd_service = new ClassRoomServiceImpl();
		lcr_service = new Repository();
			
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
			System.out.print("Id: ");
			Long idStudent = scan.nextLong();
			System.out.print("Ho va ten: ");
			String hoTen = scan.nextLine();
			scan.nextLine();
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
		scan.nextLine();
		String tenLop = scan.nextLine();
		System.out.print("ID: ");
		Long idStudent = scan.nextLong();
		System.out.println(tenLop +">>>>>"+idStudent);
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
		if(lcr_service.getListClassRoom().isEmpty())
			System.err.println("Empty!");
		else
			lcr_service.showAllList();
	}
}
