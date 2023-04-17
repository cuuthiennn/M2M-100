package Service.ServiceImpl;

import java.util.List;

import Entity.ClassRoom;
import Entity.Student;
import Service.ClassRoomService;

public class ClassRoomServiceImpl implements ClassRoomService{
	
	@Override
	public int findIndexInList(Long idStudent, ClassRoom listStudent) {
		int result = -1;
		List<Student> temp_list = listStudent.getListStudent();
		for(int i = 0; i < temp_list.size(); i++) {
			if(temp_list.get(i).getIdStudent().equals(idStudent)) {
				result = i;
				break;
			}
		}
		return result;
	}

}
