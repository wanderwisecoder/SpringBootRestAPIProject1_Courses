package com.springrest.springrestproject.service;

import java.util.List;

import com.springrest.springrestproject.entities.Course;

public interface CourseService {
	public List<Course> getCourses();

	public Course getCourse(Long courseId);

	public Course addCourse(Course course);

	public List<Course> addCourses(List<Course> courses);

	public void updateCourse(Long courseId, Course course);

	public void deleteCourse(int courseId);
}
