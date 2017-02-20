package com.kevin.mvcdemo.service.Impl;

import org.springframework.stereotype.Service;

import com.kevin.mvcdemo.model.Course;
import com.kevin.mvcdemo.service.CourseService;


@Service("courseService")
public class CourseServiceImpl implements CourseService
{
	
	@Override
	public Course getCourseById(Integer courseId)
	{

		Course course = new Course();
		course.setCourseId(courseId);
		course.setTitle("course1");
		return course;
	}
	
}
