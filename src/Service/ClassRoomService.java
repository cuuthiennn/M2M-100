package Service;

import java.util.List;

import Entity.ClassRoom;
import Entity.Student;

public interface ClassRoomService {
	public int findIndexInList(Long idStudent, ClassRoom listStudent);
}
