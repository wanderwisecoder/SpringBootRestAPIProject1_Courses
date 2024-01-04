package com.springrest.springrestproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrestproject.entities.Course;
import com.springrest.springrestproject.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "This is Home Page.";
	}

	// get courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}

	// get a single course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable Long courseId) {
		return this.courseService.getCourse(courseId);
	}

	// add a new course in the list
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}

	// add new courses
	@PostMapping("/courses")
	public List<Course> addCourses(@RequestBody List<Course> courses) {
		return this.courseService.addCourses(courses);
	}

	// update existing course
	@PutMapping("/course/{courseId}")
	public void updateCourse(@PathVariable Long courseId, @RequestBody Course course) {
		// TODO: process PUT request
		System.out.println("Course details updated Successfully.");
		 this.courseService.updateCourse(courseId, course);
	}
	
	// delete course from database
	@DeleteMapping("/course/{courseId}")
	public void deleteBook(@PathVariable("courseId") int courseId) {
        this.courseService.deleteCourse(courseId);
    }

}
