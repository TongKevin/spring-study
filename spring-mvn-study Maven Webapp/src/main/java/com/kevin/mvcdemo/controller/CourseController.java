package com.kevin.mvcdemo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		logger.info("in view course, courseid={}", courseId);
		
		Course course = courseService.getCourseById(courseId);
		
		model.addAttribute(course);
		
		return "course_overview";
	}
	
	@RequestMapping(value = "/view2/{courseId}", method = RequestMethod.GET)
	public String viewCourese2(@PathVariable("courseId")
	Integer courseId, Map<String, Object> model)
	{
		logger.info("in view course2, courseid={}", courseId);
		
		Course course = courseService.getCourseById(courseId);
		
		model.put("course", course);
		
		return "course_overview";
	}
	
	@RequestMapping(value = "view3", method = RequestMethod.GET)
	public String viewCourse3(HttpServletRequest request)
	{
		
		logger.info("in view course3, courseid={}",
				request.getParameter("courseId"));
		
		Course course = courseService.getCourseById(Integer.valueOf(request
				.getParameter("courseId")));
		
		request.setAttribute("course", course);
		
		return "course_overview";
	}
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
	public String createCourse()
	{
		return "course_admin/edit";
	}
	
}
