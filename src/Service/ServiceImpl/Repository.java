package Service.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import Entity.ClassRoom;
import Entity.Student;

public class Repository {
	HashMap<String, ClassRoom> listClassRoom;

	public Repository() {
		listClassRoom = new HashMap<>();
	}

	public HashMap<String, ClassRoom> getListClassRoom() {
		return listClassRoom;
	}

	public boolean insertClassRoom(String tenLop) {
		boolean check = findClassRoom(tenLop);
		if (!check) {
			listClassRoom.put(tenLop, new ClassRoom());
			return true;
		}
		return false;
	}

	public boolean deleteClassRoom(String tenLop) {
		boolean check = findClassRoom(tenLop);
		if (check) {
			listClassRoom.remove(tenLop);
			return true;
		}
		return false;
	}

	public void showClassRoomByName(String tenLop) {
		System.out.println("===================== " + tenLop + " =====================");
		List<Student> temp_list = listClassRoom.get(tenLop).getListStudent();
		listClassRoom.get(tenLop).printList(temp_list);
	}

	public void showAllList() {
		for (String key : listClassRoom.keySet()) {
			showClassRoomByName(key);
		}
	}

	public boolean findClassRoom(String tenLop) {
		boolean result = false;
		for (String key : listClassRoom.keySet()) {
			if (key.equals(tenLop)) {
				result = true;
			}
		}
		return result;
	}
	public boolean findStudentById(Long idStudent) {
		for (String key : listClassRoom.keySet()) {
			List<Student> temp_list = listClassRoom.get(key).getListStudent();
			for (Student student : temp_list) {
				if(student.getIdStudent().equals(idStudent)) {
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
					listClassRoom.get(tenLop).getListStudent().add(newStu);
					return true;
				} catch (Exception e) {
					System.err.println("Loi: ");
					e.printStackTrace();
				}
			}else {
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
			if(doubleCheck) {
				List<Student> temp_list = listClassRoom.get(tenLop).getListStudent();
				for (Student student : temp_list) {
					System.out.println(student.toString());
					if (student.getIdStudent().equals(idStudent)) {
						temp_list.remove(index);
						listClassRoom.replace(tenLop, new ClassRoom(temp_list));
						return true;
					}
					index++;
				}
			}
		}
		return false;
	}
}
