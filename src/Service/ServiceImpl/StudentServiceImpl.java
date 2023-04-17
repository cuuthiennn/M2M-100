package Service.ServiceImpl;

import Entity.Student;
import Service.StudentService;

public class StudentServiceImpl implements StudentService{
	@Override
	public String xepHocLuc(float diemTrungBinh) {
		if(0 > diemTrungBinh || 10 < diemTrungBinh) return "";
		if(10 == diemTrungBinh) return "Xuat Sac";
		if(10 > diemTrungBinh && 8 <= diemTrungBinh) return "Goi";
		if(8 > diemTrungBinh && 5 <= diemTrungBinh) return "Kha";
		if(5 > diemTrungBinh && 3 <= diemTrungBinh) return "Trung Binh";
		return "Yeu";
	}
}
