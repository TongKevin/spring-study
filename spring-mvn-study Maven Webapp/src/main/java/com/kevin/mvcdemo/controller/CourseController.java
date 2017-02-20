package com.kevin.mvcdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kevin.mvcdemo.model.Course;
import com.kevin.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController
{
	private static Logger logger = LoggerFactory
			.getLogger(CourseController.class);
	
	private CourseService courseService;
	
	@Autowired
	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId")
	Integer courseId, Model model)
	{
		
		logger.debug("in view course, courseid={}", courseId);
		
		Course course = courseService.getCourseById(courseId);
		
		model.addAttribute(course);
		
		return "course_overview";
	}
}
