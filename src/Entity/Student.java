package Entity;

public class Student {
	private String hoTen;
	private Long idStudent;
	private Float diemTrungBinh;
	private String hocLuc;
	
	public Student() {
	}

	public Student(String hoTen, Long idStudent, float diemTrungBinh, String hocLuc) {
		super();
		this.hoTen = hoTen;
		this.idStudent = idStudent;
		this.diemTrungBinh = diemTrungBinh;
		this.hocLuc = hocLuc;
	}

	@Override
	public String toString() {
		return "Student [hoTen:" + hoTen + ", idStudent:" + idStudent + ", diemTrungBinh:" + diemTrungBinh + ", hocLuc:"
				+ hocLuc + "]";
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public float getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(Float diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}

	public String getHocLuc() {
		return hocLuc;
	}

	public void setHocLuc(String hocLuc) {
		this.hocLuc = hocLuc;
	}
	
}
