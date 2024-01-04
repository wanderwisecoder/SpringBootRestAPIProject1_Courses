package com.springrest.springrestproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrestproject.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	private CourseService courseService;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Core Java", "This course contains basics of JAVA."));
		list.add(new Course(334, "Spring Frameworks", "This course contains concepts related to spring frame works."));
		list.add(new Course(546, "MySQL", "This course contains MySQL Database."));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(Long courseId) {
		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public List<Course> addCourses(List<Course> courses) {

		for (Course course : courses) {
			list.add(course);
		}
		return list;
	}

	@Override
	public void updateCourse(Long courseId, Course course) {

		list = list.stream().map(c -> {
			if (c.getId() == courseId) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
			}

			return c;
		}).collect(Collectors.toList());
		// int id= Math.toIntExact(courseId);
		// System.out.println(list.get(id));

		// return this.courseService.getCourse(courseId);

	}

	@Override
	public void deleteCourse(int courseId) {
		for (Course course : list) {
			if (course.getId() == courseId) {
				list.remove(course);
				break;
			}
		}

	}

}
