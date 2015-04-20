package pl.edu.agh.planner.client.applayout.menu.forms;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.edu.agh.planner.client.Context;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;
import java.util.List;

class TeacherDataLoader {

	private List<TeacherRecord> teacherRecordList = new ArrayList<TeacherRecord>();

	public TeacherDataLoader() {
		Context.getInstance().getPlannerServiceAsync().getTeachersList(new AsyncCallback<List<Teacher>>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(List<Teacher> result) {
				for (Teacher teacher : result) {
					TeacherRecord teacherRecord = new TeacherRecord();
					teacherRecord.setNameAttribute(teacher.getName());
					teacherRecord.setLastnameAttribute(teacher.getLastName());

					teacherRecordList.add(teacherRecord);
				}
			}
		});

	}

	public TeacherRecord[] getTeacherRecords() {
		return teacherRecordList.toArray(new TeacherRecord[teacherRecordList.size()]);
	}

}
