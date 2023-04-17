package Service;

import Entity.Student;

public interface ClassRoomService {
	public boolean insertClassRoom(String tenLop);
	public boolean deleteClassRoom(String tenLop);
	public void showClassRoomByName(String tenLop);
	public boolean findClassRoom(String tenLop);
	public boolean findStudentById(Long idStudent);
	public boolean insertStudentIntoClassRoom(Student newStu, String tenLop);
	public boolean deleteStudent(Long idStudent, String tenLop);
}
