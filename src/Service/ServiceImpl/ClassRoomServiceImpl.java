package Service.ServiceImpl;

import java.util.List;

import Entity.ClassRoom;
import Entity.Student;
import Repository.Repository;
import Service.ClassRoomService;

public class ClassRoomServiceImpl extends Repository implements ClassRoomService{
	Repository repository;
	
	public ClassRoomServiceImpl() {
		repository = new Repository();
	}
	
	public Repository getRepository() {
		return repository;
	}

	public boolean insertClassRoom(String tenLop) {
		boolean check = findClassRoom(tenLop);
		if (!check) {
			repository.getListClassRoom().put(tenLop, new ClassRoom());
			return true;
		}
		return false;
	}

	public boolean deleteClassRoom(String tenLop) {
		boolean check = findClassRoom(tenLop);
		if (check) {
			repository.getListClassRoom().remove(tenLop);
			return true;
		}
		return false;
	}

	public void showClassRoomByName(String tenLop) {
		System.out.println("===================== " + tenLop + " =====================");
		repository.getListClassRoom().get(tenLop).printList();
	}

	public boolean findClassRoom(String tenLop) {
		boolean result = false;
		for (String key : repository.getListClassRoom().keySet()) {
			if (key.equals(tenLop)) {
				result = true;
			}
		}
		return result;
	}

	public boolean findStudentById(Long idStudent) {
		for (String key : repository.getListClassRoom().keySet()) {
			List<Student> temp_list = repository.getListClassRoom().get(key).getListStudent();
			for (Student student : temp_list) {
				if (student.getIdStudent().equals(idStudent)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean insertStudentIntoClassRoom(Student newStu, String tenLop) {
		boolean check = findClassRoom(tenLop);
		boolean doubleCheck = findStudentById(newStu.getIdStudent());
		if (check) {
			if (!doubleCheck) {
				try {
					repository.getListClassRoom().get(tenLop).getListStudent().add(newStu);
					return true;
				} catch (Exception e) {
					System.err.println("Loi: ");
					e.printStackTrace();
				}
			} else {
				System.err.println("ID da ton tai!");
			}
		}
		return false;
	}

	public boolean deleteStudent(Long idStudent, String tenLop) {
		boolean check = findClassRoom(tenLop);
		boolean doubleCheck = findStudentById(idStudent);
		int index = 0;
		if (check) {
			if (doubleCheck) {
				List<Student> temp_list = repository.getListClassRoom().get(tenLop).getListStudent();
				for (Student student : temp_list) {
					if (student.getIdStudent().equals(idStudent)) {
						temp_list.remove(index);
						ClassRoom temp_classroom = new ClassRoom(temp_list);
						repository.getListClassRoom().replace(tenLop, temp_classroom);
						return true;
					}
					index++;
				}
			}
		}
		return false;
	}
}
