package com.sample.hello;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@RestController
@RequestMapping(value="/rest/student")
class StudentService{

	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	       return new WebMvcConfigurerAdapter() {
	           @Override
	           public void addCorsMappings(CorsRegistry registry) {
	               registry.addMapping("/rest/student").allowedOrigins("http://localhost:8080").
	               allowedMethods("GET", "POST", "PUT", "DELETE"," OPTIONS", "HEAD").allowedHeaders("*");
	           }
	       };
	   }
   @RequestMapping(value="/",method = RequestMethod.GET)
   public HashMap<Long,Student> getAllStudents(){
      return Application.hmStudent;
   }
   
   @RequestMapping(value="/update",method = RequestMethod.PUT)
   public Student updateStudent(@RequestBody Student student) throws Exception {
    
      if(Application.hmStudent.containsKey(new Long(student.getId()))){
         Application.hmStudent.put(new Long(student.getId()),student);
      }else{
         throw new Exception("Student "+student.getId()+" does not exists");
      }
    
      return student;
   }
   
   
   @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
   public Student deleteStudent(@PathVariable long id) throws Exception {
    
      Student student;
    
      if(Application.hmStudent.containsKey(new Long(id))){
         student=Application.hmStudent.get(new Long(id));
         Application.hmStudent.remove(new Long(id));
      }else{
         throw new Exception("Student "+id+" does not exists");
      }
      return student;
   }
   
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public Student getStudent(@PathVariable long id){
      return Application.hmStudent.get(new Long(id));
   }
   
   @RequestMapping(value="/add",method = RequestMethod.POST)
   public Student addStudent(@RequestParam(value="name") String name
         ,@RequestParam(value="subject",defaultValue = "unknown") String subject){
    
      Student student=new Student(name,subject);
      Application.hmStudent.put(new Long(student.getId()),student);
      return student;
    
   }
}
